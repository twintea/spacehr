package com.twintea.spacehr.service.impl;

import com.twintea.spacehr.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataSource dataSource;

    //文件放在 resources目录下
    @Override
    public Boolean resetDataBase(String sqlScriptName) {
        Connection conn = null;
        try {
            // 从Druid数据源（数据库连接池）中获取一个数据库连接
            conn = dataSource.getConnection();
            ClassPathResource rc = new ClassPathResource(sqlScriptName);
            EncodedResource er = new EncodedResource(rc, StandardCharsets.UTF_8);
            // ScriptUtils：是SpringBoot源码中使用的工具类，能够执行Sql脚本
            // sql脚本执行中途，遇到错误，默认会抛出异常，停止执行
            // 建议传入参数true，忽略中途的错误，但是后面4个参数又是必需的，只需要填入源码中的默认值即可
            ScriptUtils.executeSqlScript(conn, er, true, true,
                    "--", ";", "/*", "*/");

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 不要忘了释放连接
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
