package com.spw.dynamic.jpa;

import com.spw.dynamic.jpa.repository.primary.PrimaryRepository;
import com.spw.dynamic.jpa.repository.secondary.SecondaryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDynamicDatasourceJpaApplicationTests {
	@Autowired
	private PrimaryRepository primaryRepository;
	@Autowired
	private SecondaryRepository secondaryRepository;

	@Test
	void jpaDynamicTest() {
		System.out.println(primaryRepository.findAll());
		System.out.println(secondaryRepository.findAll());
	}

}
