package com.spw.dynamic.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class DynamicDatasource extends AbstractRoutingDataSource {
    @Autowired
    @Qualifier("master")
    private DataSource master;

    @Autowired
    @Qualifier("slave")
    private DataSource slave;

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("切换数据源: {}", DatasourceContextHolder.getDatasource());
        return DatasourceContextHolder.getDatasource();
    }

    @Override
    public void afterPropertiesSet() {
        log.info("设置数据源开始");
        //设置默认数据源为master
        this.setDefaultTargetDataSource(master);
        //放入数据源用于后边路由key使用
        Map<Object, Object>  targetDatasource = new HashMap<>(2);
        targetDatasource.put(DatasourceType.master.name(), master);
        targetDatasource.put(DatasourceType.slave.name(), slave);
        this.setTargetDataSources(targetDatasource);
        //将targetDatasources 加载到resolvedDataSources
        super.afterPropertiesSet();
        log.info("设置数据源结束");
    }

}
