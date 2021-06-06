package com.spw.learn.mb.service.impl;

import com.spw.learn.mb.entity.User;
import com.spw.learn.mb.mapper.UserMapper;
import com.spw.learn.mb.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author spw
 * @since 2021/6/7
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
