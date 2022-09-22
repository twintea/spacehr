package com.twintea.spacehr.config;


import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

/**
 * 接口防刷注解类
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface AccessLimit {

    // 失效时间 单位（秒）
    int seconds();

    // 最大请求次数
    int maxCount();

}
