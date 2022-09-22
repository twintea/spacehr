package com.twintea.spacehr.service;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.Hr;
import com.baomidou.mybatisplus.extension.service.IService;
import com.twintea.spacehr.model.Role;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
* @author Pixar
* @description 针对表【hr】的数据库操作Service
* @createDate 2022-06-22 00:42:40
*/
public interface HrService extends IService<Hr> {

    List<Role> getRolesByHrId(Integer id);


    RespBean getAllHrs(Integer id,String keyWords);

    RespBean updateHr(Hr hr);

    List<Hr> getHrsExcludeCurrentHr();

    RespBean updatePassword(String oldPass, String pass, Integer hrid);

    RespBean updateUserface(MultipartFile file, String userface, Integer id, Authentication authentication);
}
