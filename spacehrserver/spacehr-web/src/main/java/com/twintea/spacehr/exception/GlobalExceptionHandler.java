package com.twintea.spacehr.exception;

import com.twintea.spacehr.Resp.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

//@RestControllerAdvice
//public  class GlobalExceptionHandler {
//    @ExceptionHandler(SQLException.class)
//    public RespBean sqlException(SQLException e) {
//        if (e instanceof SQLIntegrityConstraintViolationException) {
//            System.out.println(e);
//            return RespBean.error("该数据有关联数据，操作失败！");
//        } else {
//            System.out.println(e);
//            return RespBean.error("数据库异常，操作失败！");
//        }
//    }
//}
