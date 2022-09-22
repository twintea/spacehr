package com.twintea.spacehr.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.Hr;
import com.twintea.spacehr.model.Role;
import com.twintea.spacehr.service.HrService;
import com.twintea.spacehr.mapper.HrMapper;
import com.twintea.spacehr.service.UploadService;
import com.twintea.spacehr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Pixar
 * @description 针对表【hr】的数据库操作Service实现
 * @createDate 2022-06-22 00:42:40
 */
@Service
public class HrServiceImpl extends ServiceImpl<HrMapper, Hr>
        implements HrService {
    @Autowired
    private HrMapper hrMapper;
    @Autowired
    private UploadService uploadService;

    @Override
    public List<Role> getRolesByHrId(Integer id) {
        return hrMapper.getRolesByHrId(id);
    }

    @Override
    public RespBean getAllHrs(Integer id, String keyWords) {
        List<Hr> hrs = hrMapper.getAllHrs(id, keyWords);
        return RespBean.ok(null, hrs);
    }

    @Override
    public RespBean updateHr(Hr hr) {
        if (this.updateById(hr)) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @Override
    public List<Hr> getHrsExcludeCurrentHr() {
        return hrMapper.getHrsExcludeCurrentHr(HrUtils.getCurrentHr().getId());
    }

    @Override
    public RespBean updatePassword(String oldPass, String pass, Integer hrid) {
        Hr hr = hrMapper.selectById(hrid);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(oldPass,hr.getPassword())) {
            String encodeNewPass = encoder.encode(pass);
            if (hrMapper.update(hr, new UpdateWrapper<Hr>().set("password", encodeNewPass).eq("id", hrid)) == 1) {
                return RespBean.ok("更新成功！");
            }
            return RespBean.ok("更新失败！");
        }
        return RespBean.error("原密码错误！");
    }

    @Override
    public RespBean updateUserface(MultipartFile file, String userface, Integer id, Authentication authentication) {
        Hr currentHr = (Hr) authentication.getPrincipal();
        if (file !=null){
            RespBean uploadRespBean = uploadService.upload(file);
            if (StringUtils.hasText(uploadRespBean.getMsg())){
                return uploadRespBean;
            }
            String uploadUserfaceUrl = (String) uploadRespBean.getData();
            Hr hr = hrMapper.selectById(id);
            hrMapper.update(hr,new UpdateWrapper<Hr>().set("userface",uploadUserfaceUrl).eq("id",id));

            currentHr.setUserface(uploadUserfaceUrl);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                    currentHr,authentication.getCredentials(),authentication.getAuthorities()));
            return RespBean.ok("更新成功！",uploadUserfaceUrl);
        }
        if (StringUtils.hasText(userface)){
            Hr hr = hrMapper.selectById(id);
            hrMapper.update(hr,new UpdateWrapper<Hr>().set("userface",userface).eq("id",id));
            currentHr.setUserface(userface);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                    currentHr,authentication.getCredentials(),authentication.getAuthorities()));
            return RespBean.ok("更新成功！",userface);
        }
        return RespBean.error("更新失败！");
    }
}




