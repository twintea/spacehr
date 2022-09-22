package com.twintea.spacehr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.HrRole;
import com.twintea.spacehr.service.HrRoleService;
import com.twintea.spacehr.mapper.HrRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Pixar
 * @description 针对表【hr_role】的数据库操作Service实现
 * @createDate 2022-06-22 00:42:40
 */
@Service
public class HrRoleServiceImpl extends ServiceImpl<HrRoleMapper, HrRole>
        implements HrRoleService {
    @Autowired
    private HrRoleMapper hrRoleMapper;

    @Override
    @Transactional
    public RespBean updateHrRoles(Integer hrid, Integer[] rids) {
        //先删除 hrid 对应的role
        this.remove(new QueryWrapper<HrRole>().eq("hrid", hrid));
        //添加相应的rids
        if (hrRoleMapper.insertBatch(hrid, rids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败！");
    }
}




