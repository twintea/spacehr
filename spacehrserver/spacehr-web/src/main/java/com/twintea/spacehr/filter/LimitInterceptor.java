package com.twintea.spacehr.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twintea.spacehr.Resp.RespBean;
import com.twintea.spacehr.config.AccessLimit;
import com.twintea.spacehr.utils.RedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@Component
public class LimitInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(LimitInterceptor.class);

    @Autowired
    private RedisCache redisCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断请求是否属于方法的请求
        if (handler instanceof HandlerMethod) {

            HandlerMethod hm = (HandlerMethod) handler;

            //获取方法中的注解,看是否有该注解
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }
            int seconds = accessLimit.seconds(); // 失效时间 单位（秒）
            int maxCount = accessLimit.maxCount(); // 最大请求次数
            String key = request.getServletPath()+request.getSession().getId();

            Integer count = 0;
            //从redis中获取用户访问的次数
            if (redisCache.getCacheObject(key) != null) {
                count = (Integer) redisCache.getCacheObject(key);
            }

            if (count == 0) {
                //第一次访问
                redisCache.setCacheObject(key, 1);
                redisCache.expire(key, seconds, TimeUnit.SECONDS); //置缓存失效时间(单位：秒)
                logger.info("{}第一次访问",key);
            } else if (count < maxCount) {
                //加1
                redisCache.incr(key, 1);
            } else {
                //超出访问次数
                logger.error("超出访问次数");
                render(response, "请求次数过于频繁！");
                return false;
            }
        }
        return true;
    }

    /**
     * 封装返回值
     *
     * @param response
     * @param msg
     * @throws Exception
     */
    private void render(HttpServletResponse response, String msg) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(new ObjectMapper().writeValueAsString(RespBean.error(msg)));
        out.flush();
        out.close();
    }


}
