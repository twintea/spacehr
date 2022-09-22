package com.twintea.spacehr.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.twintea.spacehr.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserLoginService implements UserDetailsService {
    @Autowired
    private HrService hrService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (ObjectUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        Hr hr = hrService.getOne(new LambdaQueryWrapper<Hr>().eq(Hr::getUsername, username));
        hr.setRoles(hrService.getRolesByHrId(hr.getId()));
        return hr;
    }
}
