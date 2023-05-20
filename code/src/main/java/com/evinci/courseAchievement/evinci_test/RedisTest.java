package com.evinci.courseAchievement.evinci_test;

import redis.clients.jedis.Jedis;

public class RedisTest {
   public static void main(String[] args) {
      // 创建 Jedis 对象，并指定 Redis 服务器的 IP 地址和端口号
      Jedis jedis = new Jedis("127.0.0.1", 6379);
      
      try {
         // 测试连接是否成功
         System.out.println("连接成功，正在测试连接...");
         String result = jedis.ping();
         System.out.println("测试连接结果：" + result);
         System.out.println("Successful");
      } catch (Exception e) {
         System.out.println("连接失败：" + e.getMessage());
      } finally {
         // 关闭 Jedis 对象
         jedis.close();
      }
   }
}