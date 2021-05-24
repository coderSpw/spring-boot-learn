package com.spw.producer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.RecoveryCallback;

@SpringBootTest
class SpringBootRabbitmqProducerApplicationTests {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	void fanoutTest() {
		String message = "a fanout type message, num: ";
		final String fanoutQueue = "fanout.queue";
		for (int i = 0; i < 10; i++) {
			rabbitTemplate.convertAndSend(fanoutQueue, message+(i+1));
		}
	}

}
