package com.spw.learn.configuration;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Description mybatis-plus配置类
 * @Author spw
 * @Date 2021/6/6
 */
@Configuration
@MapperScan("com.spw.learn.mb.mapper")
public class MybatisPlusConfig {

    /**
     * 性能分析
     * @return
     */
    @Bean
    @Profile({"dev","test"})
    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
        PerformanceMonitorInterceptor performanceMonitorInterceptor = new PerformanceMonitorInterceptor();
        performanceMonitorInterceptor.setUseDynamicLogger(true);
        return new PerformanceMonitorInterceptor();
    }

    /**
     * 插件配置
     * @return
     */
    @Bean
    public MybatisPlusInterceptor optimisticLockerInterceptor() {
        MybatisPlusInterceptor plusInterceptor = new MybatisPlusInterceptor();
        //分页插件
        plusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        //乐观锁插件
        plusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return plusInterceptor;
    }

}
