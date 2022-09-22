package com.twintea.spacehr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twintea.spacehr.model.Nation;
import com.twintea.spacehr.service.NationService;
import com.twintea.spacehr.mapper.NationMapper;
import org.springframework.stereotype.Service;

/**
* @author Pixar
* @description 针对表【nation】的数据库操作Service实现
* @createDate 2022-06-22 00:42:40
*/
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation>
    implements NationService{

}




