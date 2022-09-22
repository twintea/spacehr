package com.twintea.spacehr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.Department;
import com.twintea.spacehr.model.Employee;
import com.twintea.spacehr.mapper.DepartmentMapper;
import com.twintea.spacehr.mapper.EmployeeMapper;
import com.twintea.spacehr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pixar
 * @description 针对表【department】的数据库操作Service实现
 * @createDate 2022-06-22 00:42:40
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
        implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Department> getAllDeptWithChildren(Integer parentId) {
        return departmentMapper.getAllDeptWithChildren(parentId);
    }

    @Override
    @Transactional
    public Boolean addDept(Department department) {
        //设置插入部门操作的父部门 isParent为1
        Department parentDept = departmentMapper.selectById(department.getParentid());
        parentDept.setIsParent(1);
        departmentMapper.updateById(parentDept);
        //插入部门
        department.setChildren(new ArrayList<>());
        departmentMapper.insert(department);
        //设置depPath
        department.setDepPath(parentDept.getDepPath() + "." + department.getId());
        departmentMapper.updateById(department);
        return true;
    }

    @Override
    public RespBean deleteDept(Integer id) {
        //删除部门：
        Department dept = this.getById(id);
        // 1、有子部门，不能删.
        if (dept.getIsParent() == 1) {
            return RespBean.error("该部门下有子部门，删除失败！");
        }
        //2、该部门下有员工，不能删
        QueryWrapper<Employee> employeeQueryWrapper = new QueryWrapper<>();
        employeeQueryWrapper
                .eq("department_id", id);
        Long count = employeeMapper.selectCount(employeeQueryWrapper);
        if (count > 0) {
            return RespBean.error("该部门下还有【" + count + "】位员工，删除失败！");
        }
        //3、正常删除 并判断该部门的父部门是否需要置 parentId 为 0(无孩子）
        this.removeById(id);
        Department parentDept = this.getById(dept.getParentid());
        QueryWrapper<Department> departmentQueryWrapper = new QueryWrapper<>();
        departmentQueryWrapper
                .eq("parentid", dept.getParentid())
                .last("limit 1");
        if (departmentMapper.selectCount(departmentQueryWrapper) == 0) {
            parentDept.setIsParent(0);
            this.updateById(parentDept);
        }
        return RespBean.ok("删除成功！");


    }
}




