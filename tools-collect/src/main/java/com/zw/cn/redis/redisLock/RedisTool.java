package com.zw.cn.redis.redisLock;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2020/5/18
 * Time: 9:16
 * To change this template use File | Settings | File Templates.
 * Description: TODO
 */
@Component
public class RedisTool {
    private static final String LOCK_SUCCESS="OK";
    private static final String SET_IF_NOT_EXIST="NX";
    private static final String SET_WITH_EXPIRE_TIME="PX";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * @desc 1. 当前没有锁（key不存在），那么就进行加锁操作，并对锁设置个有效期，同时value表示加锁的客户端。
     *       2. 已有锁存在，不做任何操作。
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识,标识是哪个请求获取到的锁,可用UUID.randomUUID().toString()方法生成
     * @param expireTime 过期时间(秒)
     * @return 是否成功获取锁
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime){
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if(LOCK_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }

    /**
     * @desc 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识,标识是哪个请求获取到的锁,可用UUID.randomUUID().toString()方法生成
     * @return 是否成功释放锁
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId){
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script);
        if(RELEASE_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }

}
