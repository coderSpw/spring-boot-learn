package com.spw.dynamic.service;

import com.spw.dynamic.model.Sync;

import java.util.List;

public interface TestService {
    List<Sync> findMaster();
    List<Sync> findSlave();
}
