package com.twintea.spacehr.controller.salary;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.config.AccessLimit;
import com.twintea.spacehr.model.Salary;
import com.twintea.spacehr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @GetMapping("/")
    public RespBean getSalaries() {
        List<Salary> salaries = salaryService.list();
        return RespBean.ok(null, salaries);
    }
    @PostMapping("/")
    @AccessLimit(seconds = 5,maxCount = 1)
    public RespBean addSalaries(@RequestBody Salary salary){
        salary.setCreateDate(new Date());
        if (salaryService.save(salary)){
        return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败！");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteSalary(@PathVariable Integer id){
        if (salaryService.removeById(id)){
            return RespBean.ok("删除成功！");
        }
            return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    @AccessLimit(seconds = 5,maxCount = 1)
    public RespBean updateSalary(@RequestBody Salary salary){
        if (salaryService.updateById(salary)){
            return RespBean.ok("更新成功！");
        }
            return RespBean.error("更新失败！");
    }
}
