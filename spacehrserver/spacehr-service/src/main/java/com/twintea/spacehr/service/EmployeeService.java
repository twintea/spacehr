package com.twintea.spacehr.service;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
* @author Pixar
* @description 针对表【employee】的数据库操作Service
* @createDate 2022-06-22 00:42:40
*/
public interface EmployeeService extends IService<Employee> {

    RespBean getAllEmp(Integer page, Integer size, Employee employee, Date[] date);

    RespBean getMaxWorkId();

    Employee getEmpWithPropertiesNameById(Integer id);

    Boolean addEmp(Employee employee);

    void exportData(HttpServletResponse response);

    void importData(MultipartFile file);

}
