package com.twintea.spacehr.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.Employee;
import com.twintea.spacehr.model.MailSendLog;
import com.twintea.spacehr.model.constants.CustomConstants;
import com.twintea.spacehr.model.vo.EmployeeVo;
import com.twintea.spacehr.listener.ExcelListener;
import com.twintea.spacehr.service.EmployeeService;
import com.twintea.spacehr.mapper.EmployeeMapper;
import com.twintea.spacehr.service.MailSendLogService;
import com.twintea.spacehr.utils.RedisCache;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Pixar
 * @description 针对表【employee】的数据库操作Service实现
 * @createDate 2022-06-22 00:42:40
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
        implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MailSendLogService mailSendLogService;
    @Autowired
    private RedisCache redisCache;

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    @Override
    public RespBean getAllEmp(Integer page, Integer size, Employee employee, Date[] dates) {
        Page<Employee> employeePage = new Page<>(page, size);
        IPage<Employee> emp = employeeMapper.getAllEmp(employeePage, employee, dates);
        return RespBean.ok(null, emp);

    }

    @Override
    public RespBean getMaxWorkId() {
        Integer maxWorkId = employeeMapper.getMaxWorkId();
        return RespBean.ok(null, String.format("%08d", maxWorkId + 1));
    }

    @Override
    public Employee getEmpWithPropertiesNameById(Integer id) {
        return employeeMapper.getEmpWithPropertiesNameById(id);
    }

    @Override
    public Boolean addEmp(Employee employee) {
        //计算 合同期限
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        //月份相加减最后转化为年
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 +
                Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract));
        double contractTerm = Double.parseDouble(decimalFormat.format(month / 12));
        employee.setContractTerm(contractTerm);
        if (this.save(employee)) {
            employee = employeeMapper.getEmpWithPropertiesNameById(employee.getId());
            String msgId = UUID.randomUUID().toString();
            //操作数据库mail_send_log
            MailSendLog mailSendLog = new MailSendLog();
            mailSendLog.setEmpid(employee.getId());
            mailSendLog.setMsgid(msgId);
            mailSendLog.setExchange(CustomConstants.HR_MAIL_EXCHANGE);
            mailSendLog.setRoutekey(CustomConstants.HR_MAIL_ROUTING_KEY);
            mailSendLog.setCreatetime(new Date());
            mailSendLog.setCount(0);
            mailSendLog.setTrytime(new Date(System.currentTimeMillis() + 1000 * 60 * CustomConstants.MSG_TIMEOUT));
            mailSendLogService.save(mailSendLog);
            //发送入职邮件
            rabbitTemplate.convertAndSend(CustomConstants.HR_MAIL_EXCHANGE, CustomConstants.HR_MAIL_ROUTING_KEY,
                    employee, new CorrelationData(msgId));
            return true;
        }
        return false;
    }

    /**
     * 导出数据
     *
     * @param response
     * @return
     */
    @Override
    public void exportData(HttpServletResponse response) {
        //从数据库查询数据
        List<Employee> empList = employeeMapper.getEmpList();
        ArrayList<EmployeeVo> empVoList = new ArrayList<>();
        for (Employee employee : empList) {
            EmployeeVo employeeVo = new EmployeeVo();
            BeanUtils.copyProperties(employee, employeeVo);
            employeeVo.setNationName(employee.getNation().getName());
            employeeVo.setPoliticsstatusName(employee.getPoliticsstatus().getName());
            employeeVo.setJoblevelName(employee.getJoblevel().getName());
            employeeVo.setPositionName(employee.getPosition().getName());
            employeeVo.setDepartmentName(employee.getDepartment().getName());
            empVoList.add(employeeVo);
        }
        //设置下载信息
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = "data";
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        try {
            EasyExcel.write(response.getOutputStream(), EmployeeVo.class).sheet("员工表").doWrite(empVoList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void importData(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), new ExcelListener(employeeMapper)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}




