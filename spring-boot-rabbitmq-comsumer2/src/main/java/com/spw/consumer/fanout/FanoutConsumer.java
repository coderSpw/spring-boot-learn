package com.spw.consumer.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
@RabbitListener(queues = "fanout.queue")
public class FanoutConsumer {
    @RabbitHandler
    public void receive(String message) {
        log.info("fanout.queue ====> receive: {}", message);
    }

}
