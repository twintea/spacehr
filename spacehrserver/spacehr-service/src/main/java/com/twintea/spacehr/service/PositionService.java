package com.twintea.spacehr.service;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.Position;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Pixar
* @description 针对表【position】的数据库操作Service
* @createDate 2022-06-22 00:42:40
*/
public interface PositionService extends IService<Position> {

    RespBean getAllPositions();
}
