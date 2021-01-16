package com.jiang.localspringbootdemo.service.impl;

import com.jiang.localspringbootdemo.entity.OtimisticLockAccount;
import com.jiang.localspringbootdemo.mapper.OtimisticLockAccountMapper;
import com.jiang.localspringbootdemo.service.OtimisticLockAccountService;
import com.jiang.localspringbootdemo.util.RedisDistrubuitedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OtimisticLockAccountServiceImpl implements OtimisticLockAccountService {

    private  AtomicInteger atomicInteger = new AtomicInteger(0);

    @Autowired
    private OtimisticLockAccountMapper otimisticLockAccountMapper;

    @Autowired
    private RedisDistrubuitedLock redisDistrubuitedLock;




    @Override
    @Transactional
    public int updateData(int amount, int orgianlAmount,int id) {




        int i = atomicInteger.incrementAndGet();
        System.out.println("调用次数:"+i);
        OtimisticLockAccount otimisticLockAccount = otimisticLockAccountMapper.selectByPrimaryKey(id);
        otimisticLockAccount.setVersionAmount(otimisticLockAccount.getVersionAmount()-amount);
        otimisticLockAccount.setAmount(otimisticLockAccount.getAmount()-amount);
        otimisticLockAccount.setCucurrentVersionAmount(orgianlAmount);
        otimisticLockAccount.setLastModifyTime(new Date());
        int  a = otimisticLockAccountMapper.updateByPrimaryKeySelective(otimisticLockAccount);
        OtimisticLockAccount account = new OtimisticLockAccount();
        account.setUniqueid(UUID.randomUUID().toString());
        account.setAmount(new Random().nextInt());
        account.setVersionAmount(new Random().nextInt());
        account.setLastModifyTime(new Date());
        account.setRemark("test"+new Random().nextInt());
        otimisticLockAccountMapper.insertSelective(account);


        return a;
    }


    @Override
    @Transactional
    public int updateDataWitDistructLock(int amount, int orgianlAmount, int id) {

        int i = atomicInteger.incrementAndGet();
        System.out.println("当前时间"+System.currentTimeMillis()/1000 +":调用次数:"+i);

        int a = -1;



        try {
            if (redisDistrubuitedLock.setLock(String.valueOf(id),3000L)){
                System.out.println("获得锁-----------------");
                OtimisticLockAccount otimisticLockAccount = otimisticLockAccountMapper.selectByPrimaryKey(id);
                if (otimisticLockAccount.getAmount() -amount < 0){
                    System.out.println("没有体现金额");
                    return a;
                }

                otimisticLockAccount.setVersionAmount(otimisticLockAccount.getVersionAmount()-amount);
                otimisticLockAccount.setAmount(otimisticLockAccount.getAmount()-amount);
                otimisticLockAccount.setCucurrentVersionAmount(orgianlAmount);
                otimisticLockAccount.setLastModifyTime(new Date());
                otimisticLockAccount.setRemark("aaa");
                otimisticLockAccount.setUniqueid(UUID.randomUUID().toString());

                a  = otimisticLockAccountMapper.updateByPrimaryKeySelective(otimisticLockAccount);
            }else {
                OtimisticLockAccount account = new OtimisticLockAccount();
                account.setUniqueid(UUID.randomUUID().toString());
                account.setAmount(new Random().nextInt());
                account.setVersionAmount(new Random().nextInt());
                account.setLastModifyTime(new Date());
                account.setRemark("test"+new Random().nextInt());
                otimisticLockAccountMapper.insertSelective(account);
                TimeUnit.MILLISECONDS.sleep(5000);
            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            redisDistrubuitedLock.deleteKey(String.valueOf(id));
        }


        return a;
    }


    @Override
    public void insert(OtimisticLockAccount otimisticLockAccount) {

        otimisticLockAccountMapper.insertSelective(otimisticLockAccount);
        //throw new RuntimeException("ccccc");

    }
}
