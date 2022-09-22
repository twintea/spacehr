package com.twintea.spacehr.mapper;

import com.twintea.spacehr.model.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Pixar
* @description 针对表【menu】的数据库操作Mapper
* @createDate 2022-06-22 00:42:40
* @Entity com.twintea.spacehr.domain.Menu
*/
@Resource
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenuByHrId(Integer id);

    List<Menu> getAllMenuWithRoles();

    List<Menu> getAllMenus();

}




