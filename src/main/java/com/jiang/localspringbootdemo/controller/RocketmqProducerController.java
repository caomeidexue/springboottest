package com.jiang.localspringbootdemo.controller;

import com.jiang.localspringbootdemo.rocketmq.MyProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author jqb
 * @Description
 * @Date 2020-04-27 16:12
 */
@RestController
public class RocketmqProducerController {

    @Autowired
    private MyProducer producer;


    /**
     * topic
     */
    private static final String topic = "my_topic_test01";

    @GetMapping(value = "/mq/test1")
    public Object test1(String text)  {
        /**
         * message构造函数，三个参数分别为 主题、二级分类、消息内容（需要转换为字节数组）
         */
        Message message = new Message(topic,"lcl",("hello RocketMQ"+text).getBytes());


        SendResult result = null;
        try {
            result = producer.getProducer().send(message);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(result);

        return new HashMap<>();
    }
}
