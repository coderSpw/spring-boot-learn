package com.spw.dynamic;

import com.spw.dynamic.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDynamicDatasourceMybatisApplicationTests {
	@Autowired
	private TestService testService;

	@Test
	void test() {
		System.out.println("master:" + testService.findMaster().toString());
		System.out.println("slave:" + testService.findSlave().toString());
	}

}
