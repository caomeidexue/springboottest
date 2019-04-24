package com.jiang.localspringbootdemo.controller;

import com.jiang.localspringbootdemo.service.TestService;
import com.jiang.localspringbootdemo.util.RedisDistrubuitedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping
public class TestController {

   private CountDownLatch countDownLatch =  new CountDownLatch(1000);


    @Autowired
    private TestService testService;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Autowired
    private RedisDistrubuitedLock lock;

    @RequestMapping("/test")
    @ResponseBody
    public Object test(){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        for (int i = 0; i < 10000; i++) {
            opsForValue.set("redisKey"+i,"姜庆波",10, TimeUnit.SECONDS);
        }

        String redisKey = opsForValue.get("redisKey");
        testService.insert();
        redisTemplate.convertAndSend("sprinboot-redis-messaage", "Hello, SpringBoot redis message!!!!");
       return redisKey;
    }



    @RequestMapping("/testLock")
    @ResponseBody
    public Object testLock(){

        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(
                    ()->{
                        try {
                            countDownLatch.await();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        boolean flag = lock.setLock("测试", 1000);
                        System.out.println(flag);

                    }
            ).start();
            countDownLatch.countDown();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        boolean 测试 = lock.releaseLock("测试", "1234");
        System.out.println("释放锁成功:"+测试);


        return "aaa";
    }


    @PostMapping("/testTransaction")
    @ResponseBody
    public void testTransaction(){
       // testService.batchInsert();
        int i = 0;

        while (true){

        }
        //return "aaa";
    }


    public static void main(String[] args) {
        /*CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("测试");
                }
            });
            thread.start();
            countDownLatch.countDown();
        }*/

        while (true){


        }    }
}
