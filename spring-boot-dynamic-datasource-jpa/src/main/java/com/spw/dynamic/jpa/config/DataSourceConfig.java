package com.spw.dynamic.jpa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean("primary")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primary() {
        return DataSourceBuilder.create().build();
    }

    @Bean("secondary")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondary() {
        return DataSourceBuilder.create().build();
    }

}
