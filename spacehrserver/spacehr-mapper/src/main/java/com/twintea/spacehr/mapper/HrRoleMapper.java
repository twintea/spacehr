package com.twintea.spacehr.mapper;

import com.twintea.spacehr.model.HrRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Pixar
 * @description 针对表【hr_role】的数据库操作Mapper
 * @createDate 2022-06-22 00:42:40
 * @Entity com.twintea.spacehr.domain.HrRole
 */
public interface HrRoleMapper extends BaseMapper<HrRole> {

    boolean insertBatch(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);
}




