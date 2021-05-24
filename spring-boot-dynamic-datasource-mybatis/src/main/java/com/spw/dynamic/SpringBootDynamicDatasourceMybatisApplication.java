package com.spw.dynamic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan(basePackages = {"com.spw.dynamic.mapper"})
@EnableTransactionManagement(order = 2)
public class SpringBootDynamicDatasourceMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDynamicDatasourceMybatisApplication.class, args);
	}

}
