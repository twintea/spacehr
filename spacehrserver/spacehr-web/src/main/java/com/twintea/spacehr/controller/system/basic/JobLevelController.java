package com.twintea.spacehr.controller.system.basic;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.config.AccessLimit;
import com.twintea.spacehr.model.Joblevel;
import com.twintea.spacehr.service.JoblevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/system/basic/jl")
public class JobLevelController {
    @Autowired
    private JoblevelService joblevelService;
    @GetMapping("/")
    public RespBean getAllJobLevel(){
        List<Joblevel> joblevels = joblevelService.list();
        if (!ObjectUtils.isEmpty(joblevels)){
            return RespBean.ok(null,joblevels);
        }
        return RespBean.error("加载失败...");
    }

    @PutMapping("/")
    @AccessLimit(seconds = 5,maxCount = 1)
    public RespBean updateJobLevelById(@RequestBody Joblevel joblevel){
        if (joblevelService.updateById(joblevel)){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @PostMapping("/")
    @AccessLimit(seconds = 5,maxCount = 1)
    public RespBean addJobLevel(@RequestBody Joblevel joblevel){
        if (ObjectUtils.isEmpty(joblevel)){
            return RespBean.error("请完整填写职位名称和职位等级！");
        }
        if (joblevelService.save(joblevel)){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id){
        if (joblevelService.removeById(id)){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelsByIds(Integer[] ids){
        if (joblevelService.removeBatchByIds(Arrays.asList(ids))){
            return RespBean.ok("批量删除成功!");
        }
        return RespBean.error("批量删除失败!");
    }
}
