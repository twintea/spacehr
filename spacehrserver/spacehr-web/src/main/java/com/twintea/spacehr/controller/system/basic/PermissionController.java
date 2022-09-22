package com.twintea.spacehr.controller.system.basic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.config.AccessLimit;
import com.twintea.spacehr.model.MenuRole;
import com.twintea.spacehr.model.Role;
import com.twintea.spacehr.service.MenuRoleService;
import com.twintea.spacehr.service.MenuService;
import com.twintea.spacehr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissionController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuRoleService menuRoleService;

    @GetMapping("/")
    public RespBean getAllRoles() {
        List<Role> roleList = roleService.list();
        return RespBean.ok(null, roleList);
    }

    @GetMapping("/menu")
    public RespBean getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public RespBean getMidsByRid(@PathVariable Integer rid) {
        return menuRoleService.getMidsByRid(rid);
    }

    @PutMapping("/")
    @AccessLimit(seconds = 5,maxCount = 1)
    public RespBean updateMenuRoleByRid(Integer rid, Integer[] mids) {
        if (ObjectUtils.isEmpty(rid)) {
            return RespBean.error("系统错误！");
        }
        if (menuRoleService.updateMenuRoleByRid(rid, mids)) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");

    }

    @PostMapping("/addRole")
    @AccessLimit(seconds = 5,maxCount = 1)
    public RespBean addRole(@RequestBody Role role) {
        if (ObjectUtils.isEmpty(role)) {
            return RespBean.error("系统错误！");
        }
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        if (roleService.save(role)) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/deleteRole/{rid}")
    public RespBean deleteRoleByRid(@PathVariable Integer rid) {
        menuRoleService.remove(new QueryWrapper<MenuRole>().eq("rid", rid));
        if (roleService.removeById(rid)) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败！");
    }

}
