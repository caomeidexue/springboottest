package com.jiang.localspringbootdemo.redisbloomfiter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.google.common.hash.Hashing;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class TestRedisBloomFilter {
    private static final int TOTAL = 10000;
    private static final double FPP = 0.0005;


    public static void main(String[] args) {
       // RedisBloomFilter redisBloomFilter = RedisBloomFilter.create(TOTAL, FPP);
        //redisBloomFilter.resetBitmap();
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), TOTAL, FPP);

        IntStream.range(0, /* 3* */TOTAL).boxed()
                .map(i -> Hashing.md5().hashInt(i).toString())
                .collect(toList()).forEach(s -> {
            //redisBloomFilter.put(s);
            bloomFilter.put(s);
        });

        String str1 = Hashing.md5().hashInt(99999).toString();
        String str2 = Hashing.md5().hashInt(9999).toString();
        String str3 = "abcdefghijklmnopqrstuvwxyz123456";
        System.out.println(  bloomFilter.mightContain(str1));
        System.out.println( bloomFilter.mightContain(str2));
        System.out.println( bloomFilter.mightContain(str3));
    }
    
}
