package com.twintea.spacehr.controller.system.basic;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.config.AccessLimit;
import com.twintea.spacehr.model.Position;
import com.twintea.spacehr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/")
    public RespBean getAllPositions() {
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    @AccessLimit(seconds = 5,maxCount = 1)
    public RespBean addPosition(@RequestBody Position position) {
        if (positionService.save(position)) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");

    }

    @PutMapping("/")
    @AccessLimit(seconds = 5,maxCount = 1)
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.updateById(position)) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");

    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id) {
        if (positionService.removeById(id)) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");

    }

    @DeleteMapping("/")
    public RespBean deletePosByIds(Integer[] ids) {
        if (positionService.removeBatchByIds(Arrays.asList(ids))) {
            return RespBean.ok("批量删除成功！");
        }
        return RespBean.error("批量删除失败！");
    }
}
