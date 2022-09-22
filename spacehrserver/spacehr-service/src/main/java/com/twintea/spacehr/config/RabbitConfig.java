package com.twintea.spacehr.config;

import com.twintea.spacehr.model.constants.CustomConstants;
import com.twintea.spacehr.service.MailSendLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class RabbitConfig {
    public static final Logger logger = LoggerFactory.getLogger(RabbitConfig.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MailSendLogService mailSendLogService;


    @PostConstruct
    public void initRabbitTemplate() {
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            assert correlationData != null;
            String msgId = correlationData.getId();
            if (ack) {
                //消息成功发送到交换机
                logger.info("{}:消息成功发送到交换机", msgId);
                //更新消息状态码
                mailSendLogService.updateStatus(msgId, 1);
            } else {
                //发送失败
                logger.error("{}:发送到交换机失败！{}", msgId, cause);
            }
        });
        rabbitTemplate.setReturnsCallback(returned -> {
            //消息没有成功到达队列
            logger.error("失败！{}:消息发送到队列失败！", returned.getMessage().getMessageProperties().getMessageId());
        });
    }



    @Bean
    Queue msgQueue() {
        return new Queue(CustomConstants.HR_MAIL_QUEUE, true);
    }

    @Bean
    Exchange msgExchange() {
        return new DirectExchange(CustomConstants.HR_MAIL_EXCHANGE, true, false);
    }

    @Bean
    Binding msgBinding() {
        return BindingBuilder.bind(msgQueue()).to(msgExchange())
                .with(CustomConstants.HR_MAIL_ROUTING_KEY).noargs();
    }

}
