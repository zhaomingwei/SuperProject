package com.zw.cn.redis;

import com.zw.cn.redis.redisLock.RedisTool;
import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: zhaowei
 * Date: 2020/5/18
 * Time: 10:26
 * To change this template use File | Settings | File Templates.
 * Description: 模拟秒杀库存数量场景
 */
public class RedisDistributedLockTest {

    static int n = 500;

    public static void secsKill() {
        System.out.println(--n);
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            Jedis conn = new Jedis("10.39.251.126", 6879);
            String uuid = UUID.randomUUID().toString();
            try {
                boolean flag = RedisTool.tryGetDistributedLock(conn, "testRedisLock", uuid , 1000);
                //获取锁成功
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                    secsKill();
                }
            } finally {
                RedisTool.releaseDistributedLock(conn, "testRedisLock", uuid);
            }
        };
        for (int i = 0; i < 10000; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }

}