package com.example.WikiUrfu.listeners;

import com.example.WikiUrfu.events.DepartmentEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DepartmentEventListener {

    private final RabbitTemplate rabbitTemplate;

    @Async
    @EventListener
    public void handleDepartmentEvent(DepartmentEvent event) {
        String message = String.format("Department %s: %s (%s)",
                event.getAction(),
                event.getDepartment().getName(),
                event.getDepartment().getId());

        log.info("Event: {}", message);
        rabbitTemplate.convertAndSend("department-events", message);
    }
}