package com.example.WikiUrfu.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String TEACHER_EVENTS_QUEUE = "teacher-events";
    public static final String DEPARTMENT_EVENTS_QUEUE = "department-events";
    public static final String INSTITUTE_EVENTS_QUEUE = "institute-events";

    @Bean
    public Queue teacherEventsQueue() {
        return new Queue(TEACHER_EVENTS_QUEUE, true);
    }

    @Bean
    public Queue departmentEventsQueue() {
        return new Queue(DEPARTMENT_EVENTS_QUEUE, true);
    }

    @Bean
    public Queue instituteEventsQueue() {
        return new Queue(INSTITUTE_EVENTS_QUEUE, true);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }
}