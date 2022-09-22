//package com.twintea.spacehr.filter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.twintea.spacehr.Resp.RespBean;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * 集成进LoginFilter
// */
//@Component
//public class VerificationCodeFilter extends GenericFilter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
////        登录请求
//        if ("POST".equals(request.getMethod()) && "/doLogin".equals(request.getServletPath())) {
//            String code = request.getParameter("code");
//            HttpSession session = request.getSession();
////            System.out.println("sessionId为：："+session.getId());
//            String verifyCode = (String) session.getAttribute("verify_code");
//            System.out.println("服务器返回的验证码：---------》"+verifyCode);
//            System.out.println("用户输入的验证码：------------------->"+code);
//            if (verifyCode == null || code == null || "".equals(code) || !code.toLowerCase().equals(verifyCode.toLowerCase())) {
//                //验证码不正确
//                response.setContentType("application/json;charset=utf-8");
//                PrintWriter out = response.getWriter();
//                out.print(new ObjectMapper().writeValueAsString(RespBean.error("验证码填写错误！")));
//                out.flush();
//                out.close();
//                return;
//            }
//            //验证码正确，放行
//            filterChain.doFilter(servletRequest, servletResponse);
//
//        } else {//放行
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//    }
//}
