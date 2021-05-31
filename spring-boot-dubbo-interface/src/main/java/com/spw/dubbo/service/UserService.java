package com.spw.dubbo.service;

import com.spw.dubbo.api.User;

import java.util.List;

/**
 * @Description 用户统一接口
 * @Author spw
 * @Date 2021/5/30
 */
public interface UserService {

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    List<User> findUserById(Integer id);
}
