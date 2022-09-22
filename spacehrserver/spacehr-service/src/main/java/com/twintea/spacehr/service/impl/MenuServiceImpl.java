package com.twintea.spacehr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.Hr;
import com.twintea.spacehr.model.Menu;
import com.twintea.spacehr.service.MenuService;
import com.twintea.spacehr.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Pixar
* @description 针对表【menu】的数据库操作Service实现
* @createDate 2022-06-22 00:42:40
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public RespBean getMenuByHrId() {
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer id = hr.getId();
       List<Menu>  menus = menuMapper.getMenuByHrId(id);
        return RespBean.ok(null,menus);
    }

    @Override
    public List<Menu> getAllMenuWithRoles() {
        return menuMapper.getAllMenuWithRoles();
    }

    @Override
    public RespBean getAllMenus() {
        List<Menu> allMenus = menuMapper.getAllMenus();
        return RespBean.ok(null,allMenus);
    }


}




