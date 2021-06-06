package com.spw.learn;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spw.learn.mb.entity.User;
import com.spw.learn.mb.mapper.UserMapper;
import com.spw.learn.mb.service.TestService;
import com.spw.learn.mb.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringBootMybatisPlusApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Autowired
    private UserService userService;

	@Autowired
    private TestService testService;

	@Test
	void contextLoads() {
	}

	@Test
	void testSelect() {
		//主键查询
		System.out.println(userMapper.selectById(2));
		//批量主键查询
		userMapper.selectBatchIds(Arrays.asList(2, 3, 5)).forEach(System.out::println);
		//查询总数
		System.out.println(userMapper.selectCount(null));
	}

	@Test
	void testPage() {
		Page<User> page = new Page<>(1, 3);
		Page<User> userPage = userMapper.selectPage(page, null);
		System.out.println(userPage.getRecords());
	}

	@Test
	void testInsert() {
		User user = User.builder().name("didi").age(10).email("coderSpw@163.com").build();
		userMapper.insert(user);
	}

	@Test
	void testUpdate() {
	    //乐观锁 现根据id查询数据再更新
        User user = userMapper.selectById(1401557598988279810L);
        //User user2 = User.builder().id(user.getId()).name("enheng").age(12).email("coderSpw@163.com").build();
        LambdaUpdateWrapper<User> updateWrapper = Wrappers.lambdaUpdate(User.class)
                .eq(User::getId, user.getId());
        userMapper.update(user, updateWrapper);
		//userMapper.updateById(user);
	}

	@Test
    void testSelectWrapper() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class)
                .likeRight(User::getName, "J")
                .or(o -> {
                    o.between(User::getAge, 12, 21)
                            .ne(User::getEmail, "test4@baomidou.com");
                });

        userMapper.selectObjs(queryWrapper).forEach(System.out::println);
    }

    @Test
    void testLogicDelete() {
	    userMapper.deleteById(1401557598988279810L);
    }

    @Test
    void testInsertBath() {
	    List<User> userList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            userList.add(com.spw.learn.mb.entity.User.builder().name("didi"+i).age(i).email("coderSpw"+i+"@163.com").build());
        }
        boolean b = userService.saveOrUpdateBatch(userList, 2);
        System.out.println(b);
    }

    @Test
    void testXml() {
        System.out.println(userMapper.selectOneById(1401557598988279810L));
        System.out.println(testService.getById(1));
    }

}
