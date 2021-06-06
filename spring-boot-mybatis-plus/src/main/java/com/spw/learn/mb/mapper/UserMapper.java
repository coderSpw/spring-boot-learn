package com.spw.learn.mb.mapper;

import com.spw.learn.mb.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author spw
 * @since 2021/6/7
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    User selectOneById(@Param("id") Long id);
}
