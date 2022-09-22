package com.twintea.spacehr.service;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.HrRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Pixar
* @description 针对表【hr_role】的数据库操作Service
* @createDate 2022-06-22 00:42:40
*/
public interface HrRoleService extends IService<HrRole> {

    RespBean updateHrRoles(Integer hrid, Integer[] rids);
}
