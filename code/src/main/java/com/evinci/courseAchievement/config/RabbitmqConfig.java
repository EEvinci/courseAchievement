package com.evinci.courseAchievement.config;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    public Queue workQueue() {
        return new Queue("work.queue");
    }
}