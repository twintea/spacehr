package com.twintea.spacehr.controller.system;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.config.AccessLimit;
import com.twintea.spacehr.model.Hr;
import com.twintea.spacehr.service.HrRoleService;
import com.twintea.spacehr.service.HrService;
import com.twintea.spacehr.service.RoleService;
import com.twintea.spacehr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    private HrService hrService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private HrRoleService hrRoleService;

    @GetMapping("/")
    public RespBean getAllHrs(String keyWords) {
        return hrService.getAllHrs(HrUtils.getCurrentHr().getId(), keyWords);
    }

    @PutMapping("/")
    @AccessLimit(seconds = 5,maxCount = 1)
    public RespBean updateHr(@RequestBody Hr hr) {
        return hrService.updateHr(hr);
    }

    @GetMapping("/roles")
    public RespBean getAllRoles() {
        return RespBean.ok(null, roleService.list());
    }

    @PutMapping("/role")
    public RespBean updateHrRoles(Integer hrid, Integer[] rids) {
        return hrRoleService.updateHrRoles(hrid, rids);
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        if (hrService.removeById(id)) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
