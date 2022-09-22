package com.twintea.mailserver;

import com.twintea.spacehr.model.constants.CustomConstants;
import com.twintea.spacehr.utils.RedisCache;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MailserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailserverApplication.class, args);
    }

    @Bean
    Queue queue(){
        return new Queue(CustomConstants.HR_MAIL_QUEUE);
    }

    @Bean
    RedisCache redisCache(){
        return new RedisCache();
    }
}
