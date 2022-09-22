package com.twintea.spacehr.controller;

import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.config.AccessLimit;
import com.twintea.spacehr.config.VerificationCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class LoginController {


    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登录，请登录！");
    }


    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerificationCode verificationCode = new VerificationCode();
        BufferedImage image = verificationCode.getImage();
        String text = verificationCode.getText();
        HttpSession session = request.getSession(true);
        session.setAttribute("verify_code",text);
        String verifyCode =(String) request.getSession().getAttribute("verify_code");
        VerificationCode.output(image,response.getOutputStream());
        System.out.println("验证码刷新：-->"+verifyCode);
        System.out.println("sessionId为：："+session.getId());
    }
}
