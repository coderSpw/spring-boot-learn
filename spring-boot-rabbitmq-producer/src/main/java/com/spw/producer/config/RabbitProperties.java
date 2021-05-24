package com.spw.producer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitProperties {
    private String host;
    private Integer port;
    private String username;
    private String password;
    private String virtualHost;
}
