package com.twintea.spacehr.mapper;

import com.twintea.spacehr.model.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Pixar
* @description 针对表【department】的数据库操作Mapper
* @createDate 2022-06-22 00:42:40
* @Entity com.twintea.spacehr.domain.Department
*/
public interface DepartmentMapper extends BaseMapper<Department> {

    List<Department> getAllDeptWithChildren(Integer parentId);
}




