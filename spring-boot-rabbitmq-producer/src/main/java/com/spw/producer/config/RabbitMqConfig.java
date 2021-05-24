package com.spw.producer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(RabbitProperties.class)
public class RabbitMqConfig {
    @Autowired
    private RabbitProperties rabbitProperties;

    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(rabbitProperties.getHost());
        factory.setPort(rabbitProperties.getPort());
        factory.setUsername(rabbitProperties.getUsername());
        factory.setPassword(rabbitProperties.getPassword());
        factory.setVirtualHost(rabbitProperties.getVirtualHost());
        factory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
        factory.setPublisherReturns(true);
        return factory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(rabbitConnectionFactory());
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            log.info("消息唯一标识: {}", correlationData);
            log.info("消息确认: {}", ack);
            if (!ack) {
                log.info("失败原因: {}", cause);
            }
        });
        rabbitTemplate.setReturnsCallback(returnedMessage -> {
            log.info("消息主体: {}",returnedMessage.getMessage());
            log.info("状态码: {}", returnedMessage.getReplyCode());
            log.info("状态信息: {}", returnedMessage.getReplyText());
            log.info("交换机: {}", returnedMessage.getExchange());
            log.info("绑定路由键: {}", returnedMessage.getRoutingKey());
        });
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
}
