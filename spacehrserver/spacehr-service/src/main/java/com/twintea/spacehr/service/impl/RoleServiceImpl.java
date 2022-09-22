package com.twintea.spacehr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twintea.spacehr.model.Role;
import com.twintea.spacehr.service.RoleService;
import com.twintea.spacehr.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Pixar
* @description 针对表【role】的数据库操作Service实现
* @createDate 2022-06-22 00:42:40
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




