package com.twintea.spacehr.controller.emp;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.config.AccessLimit;
import com.twintea.spacehr.model.*;
import com.twintea.spacehr.model.constants.CustomConstants;
import com.twintea.spacehr.service.*;
import com.twintea.spacehr.model.*;
import com.twintea.spacehr.service.*;
import com.twintea.spacehr.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PoliticsstatusService politicsstatusService;
    @Autowired
    private NationService nationService;
    @Autowired
    private JoblevelService joblevelService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private RedisCache redisCache;

    @GetMapping("/")
    public RespBean getAllEmp(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer size, Employee employee,
                              Date[] date) {
//       int a=10/0;
        return employeeService.getAllEmp(page, size, employee,date);
    }

    @GetMapping("/dept")
    public RespBean getAllDeptsWithInfo(){
       return RespBean.ok(null,departmentService.getAllDeptWithChildren(-1)) ;
    }

    @PostMapping("/")
    @AccessLimit(seconds = 5,maxCount = 1)
    public RespBean addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee)) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败！");
    }

    @GetMapping("/politics")
    public RespBean getAllPoliticsStatus() {
        List<Politicsstatus> politicsstatuses = politicsstatusService.list();
        return RespBean.ok(null, politicsstatuses);
    }

    @GetMapping("/nations")
    public RespBean getAllNations() {
        List<Nation> nations = nationService.list();
        return RespBean.ok(null,nations);
    }
    @GetMapping("/joblevels")
    public RespBean getAllJobLevels(){
        List<Joblevel> joblevels = joblevelService.list();
        return RespBean.ok(null,joblevels);
    }
    @GetMapping("/positions")
    public RespBean getAllPositions(){
        List<Position> positions = positionService.list();
        return RespBean.ok(null,positions);
    }
    @GetMapping("/maxWorkId")
    public RespBean getMaxWorkId(){
        return employeeService.getMaxWorkId();
    }

    @DeleteMapping("/{id}")
    public RespBean deleteById(@PathVariable Long id){
        if ( employeeService.removeById(id)){
                return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败！");
    }
    @PutMapping("/")
    @AccessLimit(seconds = 15,maxCount = 3)
    public RespBean updateById(@RequestBody Employee employee){
        if (employeeService.updateById(employee)){
            return RespBean.ok("修改成功！");
        }
        return RespBean.error("修改失败！");
    }

    /**
     * 导出数据
     */
    @GetMapping("/export")
    @AccessLimit(seconds = 15,maxCount = 1)
    public void exportData(HttpServletResponse response){
        employeeService.exportData(response);
    }

    /**
     * 导入数据
     */
    @PostMapping("/import")
    @AccessLimit(seconds = 15,maxCount = 1)
    public RespBean importData(MultipartFile file){
        employeeService.importData(file);
        return RespBean.ok("导入成功！");
    }
}
