package com.twintea.mailserver.receiver;

import com.rabbitmq.client.Channel;
import com.twintea.spacehr.model.Employee;
import com.twintea.spacehr.model.constants.CustomConstants;
import com.twintea.spacehr.utils.RedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class MailReceiver {

    private static final Logger logger = LoggerFactory.getLogger(MailReceiver.class);

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailProperties mailProperties;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private RedisCache redisCache;

    @RabbitListener(queues = CustomConstants.HR_MAIL_QUEUE)
    public void handler(Message message, Channel channel) throws IOException {
        Employee employee = (Employee) message.getPayload();
        Long delTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        String msgId = (String) message.getHeaders().get("spring_returned_message_correlation");
        if (msgId.equals(redisCache.getCacheObject("mail_send"))) {
            //手动确认消息已消费
            logger.info("{}:消息已消费", msgId);
            channel.basicAck(delTag, false);
            return;
        }
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        try {
            messageHelper.setFrom(mailProperties.getUsername());
            messageHelper.setTo(employee.getEmail());
            messageHelper.setSentDate(new Date());
            messageHelper.setSubject("入职欢迎");
            Context context = new Context();
            context.setVariable("name", employee.getName());
            context.setVariable("positionName", employee.getPosition().getName());
            context.setVariable("joblevelName", employee.getJoblevel().getName());
            context.setVariable("departmentName", employee.getDepartment().getName());
            String mail = templateEngine.process("mail", context);
            messageHelper.setText(mail, true);
            javaMailSender.send(mimeMessage);
            //存入redis
            redisCache.setCacheObject("mail_send", msgId, 1, TimeUnit.HOURS);
        } catch (MessagingException e) {
//            消息消费失败
            channel.basicNack(delTag, false, true);
            e.printStackTrace();
            logger.error("邮件发送失败！" + e.getMessage());
        }

    }
}
