package com.twintea.spacehr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twintea.spacehr.Resp.RespBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomExpiredSessionStrategy implements SessionInformationExpiredStrategy {

    //页面跳转的方式
    //页面跳转的处理逻辑
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        //跳转的路径
        HttpServletResponse resp = event.getResponse();
        redirectStrategy.sendRedirect(event.getRequest(), resp, "/logout");
        resp.setStatus(401);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(new ObjectMapper().writeValueAsString(RespBean.ok("您的登陆已经超时或者已经在另一台机器登陆，您被迫下线！")));
        out.flush();
        out.close();
    }
}
