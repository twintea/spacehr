package com.twintea.spacehr.service;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Pixar
* @description 针对表【menu】的数据库操作Service
* @createDate 2022-06-22 00:42:40
*/
public interface MenuService extends IService<Menu> {

    RespBean getMenuByHrId();

    List<Menu> getAllMenuWithRoles();

    RespBean getAllMenus();

}
