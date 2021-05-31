package com.spw.dubbo.controller;

import com.alibaba.fastjson.JSONObject;
import com.spw.dubbo.api.User;
import com.spw.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description 入口
 * @Author spw
 * @Date 2021/5/30
 */
@RestController
public class UserController {

    @DubboReference(check = false,loadbalance = "roundrobin")
    private UserService userService;

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable(value = "id") Integer id) {
        List<User> userList = userService.findUserById(id);
        return JSONObject.toJSONString(userList);
    }

}
