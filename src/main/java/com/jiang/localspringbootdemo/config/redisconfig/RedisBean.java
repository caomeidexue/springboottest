package com.jiang.localspringbootdemo.config.redisconfig;

import com.jiang.localspringbootdemo.rediswatch.MyKeyExpirationEventMessageListener;
import com.jiang.localspringbootdemo.rediswatch.RedisKeyExpireWatch;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisBean {

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                                   MessageListenerAdapter listenerAdapter){

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("__keyevent@0__:expired"));
        return container;
    }


    @Bean
    MessageListenerAdapter listenerAdapter(RedisKeyExpireWatch receiver){
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }


    @Bean
    RedisKeyExpireWatch redisKeyExpireWatch(){
        return new RedisKeyExpireWatch();
    }


   // @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory){
        return new StringRedisTemplate(connectionFactory);
    }


    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        return container;
    }





    @Bean
    public MyKeyExpirationEventMessageListener myKeyExpirationEventMessageListener (RedisConnectionFactory connectionFactory){
        MyKeyExpirationEventMessageListener listener = new MyKeyExpirationEventMessageListener(redisMessageListenerContainer(connectionFactory));
        return listener;
    }

    @Bean
    public JedisPool redisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMaxWaitMillis(-1);
        jedisPoolConfig.setMaxTotal(200);
        jedisPoolConfig.setMinIdle(0);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379,10000,null);
        return  jedisPool;
    }

    @Bean
    public Jedis getJedis(JedisPool jedisPool){
        return jedisPool.getResource();
    }







}
