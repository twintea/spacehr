package com.twintea.spacehr.task;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.twintea.spacehr.model.Employee;
import com.twintea.spacehr.model.MailSendLog;
import com.twintea.spacehr.model.constants.CustomConstants;
import com.twintea.spacehr.service.EmployeeService;
import com.twintea.spacehr.service.MailSendLogService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class MailSendTask {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    private MailSendLogService mailSendLogService;
    @Autowired
    private EmployeeService employeeService;

    @Scheduled(cron = "0/10 * * * * ?")
    public void mailSendTask() {
        List<MailSendLog> logs = mailSendLogService.
                list(new LambdaQueryWrapper<MailSendLog>().eq(MailSendLog::getStatus, 0).lt(MailSendLog::getTrytime,new Date()));
        logs.forEach(mailSendLog -> {
            if (mailSendLog.getCount() >= CustomConstants.MAX_COUNT) {
                //修改状态码为失败
                mailSendLogService.updateStatus(mailSendLog.getMsgid(), 2);
            } else {
                //重复发送
                mailSendLogService.update(mailSendLog, new LambdaUpdateWrapper<MailSendLog>().
                        eq(MailSendLog::getMsgid, mailSendLog.getMsgid())
                        .set(MailSendLog::getUpdatetime, new Date())
                        .set(MailSendLog::getCount, mailSendLog.getCount() + 1));
               Employee emp = employeeService.getEmpWithPropertiesNameById(mailSendLog.getEmpid());
                rabbitTemplate.convertAndSend(CustomConstants.HR_MAIL_EXCHANGE,
                        CustomConstants.HR_MAIL_ROUTING_KEY, emp,
                        new CorrelationData(mailSendLog.getMsgid()));
            }
        });

    }
}
