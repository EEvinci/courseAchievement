package com.evinci.courseAchievement.evinci_test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQ {
    public static void main(String[] args) {
        // RabbitMQ test
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        // factory.setPort(5672);
        // factory.setVirtualHost("/");

        try {
            // 创建连接
            Connection connection = factory.newConnection();
            // 创建信道
            Channel channel = connection.createChannel();
            // 声明队列
            String queueName = "hello";
            channel.queueDeclare(queueName, false, false, false, null);
            // 发送消息
            String message = "Hello RabbitMQ";
            channel.basicPublish("", queueName, null, message.getBytes("UTF-8"));
            System.out.println("发送消息成功：" + message);
            // 关闭信道
            channel.close();
            // 关闭连接
            connection.close();
        } catch (Exception e) {
            System.out.println("发送消息失败：" + e.getMessage());
        }


    }

}
