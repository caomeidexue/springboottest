package com.jiang.localspringbootdemo.redisbloomfiter;

import redis.clients.jedis.Pipeline;

@FunctionalInterface
public interface PipelineExecutor {
    void load(Pipeline pipeline);
}
