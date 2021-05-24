package com.spw.dynamic.service.impl;

import com.spw.dynamic.config.Datasource;
import com.spw.dynamic.mapper.TestMapper;
import com.spw.dynamic.model.Sync;
import com.spw.dynamic.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper mapper;

    @Datasource
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Sync> findMaster() {
        return mapper.findMaster();
    }


    @Override
    @Datasource("slave")
    @Transactional(rollbackFor = Exception.class)
    public List<Sync> findSlave() {
        return mapper.findSlave();
    }
}
