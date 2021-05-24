package com.spw.dynamic.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(-1)
@Slf4j
@Aspect
@Component
public class DatasourceAspect {

    @Before(value = "@annotation(com.spw.dynamic.config.Datasource)")
    public void before(JoinPoint joinPoint) {
        log.info("数据源拦截开始");
        //获取类上注解
        Datasource clazzDatasource = (Datasource) joinPoint.getSignature().getDeclaringType().getAnnotation(Datasource.class);
        //获取方法上注解
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Datasource methodDatasource = signature.getMethod().getAnnotation(Datasource.class);
        //注解层级 方法 > 类
        //默认设置为master
        DatasourceContextHolder.setDatasource(DatasourceType.master.name());
        if (clazzDatasource != null) {
            DatasourceContextHolder.setDatasource(clazzDatasource.value());
        }
        if (methodDatasource != null) {
            DatasourceContextHolder.setDatasource(methodDatasource.value());
        }
        log.info("数据源拦截结束");
    }

}
