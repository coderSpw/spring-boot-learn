package com.spw.dynamic.jpa.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.jpa")
public class JpaProperties {
    private Boolean showSql;
    private String database;
}
