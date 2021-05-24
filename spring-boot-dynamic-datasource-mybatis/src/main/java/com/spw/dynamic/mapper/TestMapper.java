package com.spw.dynamic.mapper;

import com.spw.dynamic.model.Sync;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    List<Sync> findMaster();
    List<Sync> findSlave();
}
