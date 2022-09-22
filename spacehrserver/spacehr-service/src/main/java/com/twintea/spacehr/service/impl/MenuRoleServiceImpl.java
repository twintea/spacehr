package com.twintea.spacehr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.MenuRole;
import com.twintea.spacehr.mapper.MenuRoleMapper;
import com.twintea.spacehr.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Pixar
 * @description 针对表【menu_role】的数据库操作Service实现
 * @createDate 2022-06-22 00:42:40
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole>
        implements MenuRoleService {
    @Autowired
    private MenuRoleMapper menuRoleMapper;

    @Override
    public RespBean getMidsByRid(Integer rid) {
        List<Integer> mids = menuRoleMapper.getMidsByRid(rid);
        return RespBean.ok(null, mids);
    }

    @Override
    @Transactional
    public boolean updateMenuRoleByRid(Integer rid, Integer[] mids) {
        this.remove(new QueryWrapper<MenuRole>().eq("rid", rid));
        if (mids==null){
            return true;
        }
       return menuRoleMapper.insertByRid(rid,mids);
    }
}




