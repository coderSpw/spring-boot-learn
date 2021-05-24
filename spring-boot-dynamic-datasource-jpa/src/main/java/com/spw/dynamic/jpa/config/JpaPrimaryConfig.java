package com.spw.dynamic.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryPrimary",
        basePackages = "com.spw.dynamic.jpa.repository.primary",
        transactionManagerRef = "transactionManagerPrimary")
@EnableConfigurationProperties(JpaProperties.class)
public class JpaPrimaryConfig {
    @Autowired
    private JpaProperties jpaProperties;
    @Autowired
    @Qualifier("primary")
    private DataSource primary;

    @Primary
    @Bean("entityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactory(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean("entityManagerFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(primary)
                .properties(getProperties())
                .packages("com.spw.dynamic.jpa.model")
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }

    private Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>(2);
        properties.put("showSql", jpaProperties.getShowSql());
        properties.put("database", jpaProperties.getDatabase());
        return properties;
    }

    @Primary
    @Bean("transactionManagerPrimary")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }

}
