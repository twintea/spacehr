package com.twintea.spacehr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.Position;
import com.twintea.spacehr.service.PositionService;
import com.twintea.spacehr.mapper.PositionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Pixar
* @description 针对表【position】的数据库操作Service实现
* @createDate 2022-06-22 00:42:40
*/
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position>
    implements PositionService{

    @Override
    public RespBean getAllPositions() {
        List<Position> positions = this.list();
        return RespBean.ok(null,positions);
    }
}




