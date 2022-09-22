package com.twintea.spacehr.controller.system.basic;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.config.AccessLimit;
import com.twintea.spacehr.model.Department;
import com.twintea.spacehr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/basic/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public RespBean getAllDeptWithChildren() {
        return RespBean.ok(null, departmentService.getAllDeptWithChildren(-1));
    }

    @PostMapping("/")
    @AccessLimit(seconds = 5,maxCount = 1)
    public RespBean addDept(@RequestBody Department department) {
        if (departmentService.addDept(department)) {
            return RespBean.ok("添加成功", department);
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDept(@PathVariable Integer id) {
        return departmentService.deleteDept(id);
    }

}
