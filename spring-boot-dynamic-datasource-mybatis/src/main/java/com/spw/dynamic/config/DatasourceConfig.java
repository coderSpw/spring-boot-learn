package com.spw.dynamic.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Bean
    @Primary
    @Qualifier("master")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource master() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("slave")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource slave() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("customSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DynamicDatasource datasourceConfig) {
        try {
            SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
            sqlSessionFactory.setDataSource(datasourceConfig);
            sqlSessionFactory.setTypeAliasesPackage("com.spw.dynamic.model");
            ResourcePatternResolver resolver =  new PathMatchingResourcePatternResolver();
            sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*Mapper.xml"));
            return sqlSessionFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Bean("customDataSourceTransactionManager")
    public DataSourceTransactionManager transactionManager (DynamicDatasource datasourceConfig) {
        return new DataSourceTransactionManager(datasourceConfig);
    }

}
