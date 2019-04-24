package com.jiang.localspringbootdemo.rediswatch;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

public class MyKeyExpirationEventMessageListener extends KeyExpirationEventMessageListener {

    public MyKeyExpirationEventMessageListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println(new String(message.getBody()));
        System.out.println(new String(message.getChannel()));
        System.out.println(new String(pattern));
        super.onMessage(message, pattern);
    }

}
