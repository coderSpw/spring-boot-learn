package com.spw.dubbo.service.impl;

import com.spw.dubbo.api.User;
import com.spw.dubbo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    public List<User> findUserById(Integer id) {
        log.info("provider 1 ...........");
        List<User> list = new ArrayList<>();
        list.add(User.builder().id(1).name("熊大").addr("北京").build());
        list.add(User.builder().id(2).name("熊二").addr("上海").build());
        return list;
    }
}
