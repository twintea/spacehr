package com.twintea.spacehr.service;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.Department;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Pixar
* @description 针对表【department】的数据库操作Service
* @createDate 2022-06-22 00:42:40
*/
public interface DepartmentService extends IService<Department> {

    List<Department> getAllDeptWithChildren(Integer parentId);

    Boolean addDept(Department department);

    RespBean deleteDept(Integer id);
}
