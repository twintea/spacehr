package com.twintea.spacehr.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    @Autowired
    SessionRegistry sessionRegistry;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        String verify_code = (String) request.getSession().getAttribute("verify_code");
        if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE) || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            //Json形式登录
            Map<String,String> loginData = new HashMap<>();
            try {
                //通过io流解析并反序列化成map
                loginData = new ObjectMapper().readValue(request.getInputStream(),Map.class);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                String code = loginData.get("code");
                checkCode(verify_code,code);
            }
            String username = loginData.get(getUsernameParameter());
            username = username != null ? username : "";
            username = username.trim();
            String password = loginData.get(getPasswordParameter());
            password = password != null ? password : "";
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
            this.setDetails(request, authRequest);
//            Hr principal = new Hr();
//            principal.setUsername(username);
//            sessionRegistry.registerNewSession(request.getSession(true).getId(), principal);
            return this.getAuthenticationManager().authenticate(authRequest);

        } else { //字符串形式登录
            checkCode(verify_code,request.getParameter("code"));
            return super.attemptAuthentication(request, response);
        }
    }

    private void checkCode(String verify_code, String code) {
        System.out.println("服务器返回的验证码：---------》"+verify_code);
        System.out.println("用户输入的验证码：------------------->"+code);
            if (verify_code == null || code == null || "".equals(code) || !code.toLowerCase().equals(verify_code.toLowerCase())) {
                //验证码不正确
                throw  new AuthenticationServiceException("验证码输入错误！");
            }
    }
}
