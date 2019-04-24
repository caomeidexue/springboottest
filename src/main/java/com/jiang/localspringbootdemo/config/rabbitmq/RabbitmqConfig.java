package com.jiang.localspringbootdemo.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue paymentNotifyQueue() {
        return new Queue("notify.payment");
    }
}
