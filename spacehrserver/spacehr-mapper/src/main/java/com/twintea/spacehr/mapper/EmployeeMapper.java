package com.twintea.spacehr.mapper;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.twintea.spacehr.model.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

/**
* @author Pixar
* @description 针对表【employee】的数据库操作Mapper
* @createDate 2022-06-22 00:42:40
* @Entity com.twintea.spacehr.domain.Employee
*/
public interface EmployeeMapper  extends BaseMapper<Employee> {

    IPage<Employee> getAllEmp(IPage page, @Param("employee") Employee employee, @Param("begin_date") Date[] dates);

    List<Employee> getEmpList();

    Integer getMaxWorkId();


    void insertBatch(List<Employee> employeeList);

    Employee getEmpWithPropertiesNameById(@Param("id") Integer id);

}




