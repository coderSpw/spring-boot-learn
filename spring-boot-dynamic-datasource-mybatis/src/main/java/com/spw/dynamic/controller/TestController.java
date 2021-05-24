package com.spw.dynamic.controller;

import com.spw.dynamic.model.Sync;
import com.spw.dynamic.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestService service;

    @GetMapping("/findMaster")
    public List<Sync> findmaster() {
        List<Sync> sync = service.findMaster();
        return sync;
    }

    @GetMapping("/findSlave")
    public List<Sync> findslave() {
        List<Sync> sync = service.findSlave();
        return sync;
    }
}
