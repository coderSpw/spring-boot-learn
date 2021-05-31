package com.spw.dubbo.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spw.dubbo.api.User;
import com.spw.dubbo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author spw
 * @Date 2021/5/30
 */
@Slf4j
@Component
@DubboService
public class UserServiceImpl implements UserService {

    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public List<User> findUserById(Integer id) {
        log.info("provider 2 ...........");
        List<User> list = new ArrayList<>();
        list.add(User.builder().id(1).name("熊大").addr("北京").build());
        list.add(User.builder().id(2).name("熊二").addr("上海").build());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            log.info("error: {}", e);
        }
        return list;
    }

    public List<User> fallback(Integer id) {
        List<User> list = new ArrayList<>();
        list.add(User.builder().id(id).name("无名").addr("未知").build());
        return list;
    }
}
