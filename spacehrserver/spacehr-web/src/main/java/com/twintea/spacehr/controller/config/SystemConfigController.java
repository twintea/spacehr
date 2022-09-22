package com.twintea.spacehr.controller.config;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public RespBean getMenuByHrId(){
            return menuService.getMenuByHrId();
    }
}
