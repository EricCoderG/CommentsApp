package com.dp.utils;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SimpleRedisLock implements ILock{
    private String name;
    private static final String LOCK_PREFIX = "lock:";
    private static final String ID_PREFIX = UUID.randomUUID() + "-";
    private StringRedisTemplate stringRedisTemplate;

    public SimpleRedisLock(String name, StringRedisTemplate redisTemplate) {
        this.name = name;
        this.stringRedisTemplate = redisTemplate;
    }
    @Override
    public boolean tryLock(long timeoutSec) {
        // 获取线程标识
        String threadId =  ID_PREFIX + Thread.currentThread().getId();
        // 获取锁
        Boolean success = stringRedisTemplate.opsForValue().setIfAbsent(LOCK_PREFIX + name, String.valueOf(threadId), timeoutSec, TimeUnit.SECONDS);
        // 避免自动拆箱空指针
        return Boolean.TRUE.equals(success);
    }

    @Override
    public void unlock() {
        // 获取线程标识
        String threadId =  ID_PREFIX + Thread.currentThread().getId();
        // 判断是否是自己的锁
        String id = stringRedisTemplate.opsForValue().get(LOCK_PREFIX + name);
        if (!threadId.equals(id)) {
            return;
        }
        stringRedisTemplate.delete(LOCK_PREFIX + name);
    }
}
