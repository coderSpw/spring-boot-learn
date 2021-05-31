package com.spw.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Description 服务提供者启动类
 * @Author spw
 * @Date 2021/5/30
 */
@EnableDubbo
@EnableHystrix
@SpringBootApplication
public class Provider2Application {
    public static void main(String[] args) {
        SpringApplication.run(Provider2Application.class, args);
    }
}
