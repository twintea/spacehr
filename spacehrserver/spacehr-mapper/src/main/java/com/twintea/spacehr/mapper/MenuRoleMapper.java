package com.twintea.spacehr.mapper;

import com.twintea.spacehr.model.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
* @author Pixar
* @description 针对表【menu_role】的数据库操作Mapper
* @createDate 2022-06-22 00:42:40
* @Entity com.twintea.spacehr.domain.MenuRole
*/
public interface MenuRoleMapper extends BaseMapper<MenuRole> {


    List<Integer> getMidsByRid(Integer rid);

    boolean insertByRid(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}




