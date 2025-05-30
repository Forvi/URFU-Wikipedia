package com.example.WikiUrfu.listeners;

import com.example.WikiUrfu.events.TeacherEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor

public class TeacherEventListener {

    private final RabbitTemplate rabbitTemplate;

    @Async
    @EventListener
    public void handleTeacherEvent(TeacherEvent event) {
        String message = String.format("Преподаватель %s: %s (%s)",
                event.getAction(),
                event.getTeacher().getName(),
                event.getTeacher().getId());

        log.info("Событие: {}", message);
        rabbitTemplate.convertAndSend("teacher-events", message);


    }
}
