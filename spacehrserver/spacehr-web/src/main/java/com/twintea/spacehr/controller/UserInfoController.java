package com.twintea.spacehr.controller;

import com.alibaba.excel.util.StringUtils;
import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.config.AccessLimit;
import com.twintea.spacehr.model.Hr;
import com.twintea.spacehr.service.HrService;
import com.twintea.spacehr.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/user/userInfo")
public class UserInfoController {
    @Autowired
    private HrService hrService;

    @GetMapping("/")
    public Hr getCurrentUser(Authentication authentication) {
        return (Hr) authentication.getPrincipal();
    }

    @PutMapping("/")
    @AccessLimit(seconds = 5,maxCount = 1)
    public RespBean updateUser(@RequestBody Hr hr, Authentication authentication){
        if (hr.getPhone().length()!=11){
            return RespBean.error("手机号码位数为11位!");
        }
        if (hrService.updateById(hr)){
            SecurityContextHolder.getContext().
                    setAuthentication(new UsernamePasswordAuthenticationToken(
                            hr,authentication.getCredentials(), authentication.getAuthorities()));
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @PutMapping("/hr/passwd")
    @AccessLimit(seconds = 5,maxCount = 1)
    public RespBean updatePassword(@RequestBody Map<String,Object> info){
        String oldPass = (String) info.get("oldPass");
        String pass = (String) info.get("pass");
        Integer hrid = (Integer) info.get("hrid");
        if (!StringUtils.isNotBlank(oldPass) && !StringUtils.isNotBlank(pass) && hrid ==null){
            return RespBean.error("数据错误！");
        }
        return hrService.updatePassword(oldPass, pass, hrid);
    }



    @PostMapping("/fileUpload/userface")
    @AccessLimit(seconds = 15,maxCount = 3)
    public RespBean updateUserface(MultipartFile file,String userface,Integer id,Authentication authentication){

        return hrService.updateUserface(file,userface,id,authentication);
    }
}
