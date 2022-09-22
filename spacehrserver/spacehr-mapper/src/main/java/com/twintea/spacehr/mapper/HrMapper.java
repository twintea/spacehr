package com.twintea.spacehr.mapper;

import com.twintea.spacehr.model.Hr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.twintea.spacehr.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * @author Pixar
 * @description 针对表【hr】的数据库操作Mapper
 * @createDate 2022-06-22 00:42:40
 * @Entity com.twintea.spacehr.domain.Hr
 */
public interface HrMapper extends BaseMapper<Hr> {

    List<Role> getRolesByHrId(Integer id);

    List<Hr> getAllHrs(@Param("id") Integer id, @Param("keyWords") String keyWords);

    List<Hr> getHrsExcludeCurrentHr(Integer id);
}




