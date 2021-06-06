package com.spw.learn.mb.service.impl;

import com.spw.learn.mb.entity.Test;
import com.spw.learn.mb.mapper.TestMapper;
import com.spw.learn.mb.service.TestService;
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
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
