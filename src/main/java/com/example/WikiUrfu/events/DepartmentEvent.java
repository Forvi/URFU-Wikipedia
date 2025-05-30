package com.example.WikiUrfu.events;

import com.example.WikiUrfu.entity.DepartmentEntity;
import org.springframework.context.ApplicationEvent;

public class DepartmentEvent extends ApplicationEvent {
    private final DepartmentEntity department;
    private final String action;

    // Сщтыекгсещк
    public DepartmentEvent(Object source, DepartmentEntity department, String action) {
        super(source);  // Источник события (обычно this)
        this.department = department;
        this.action = action;
    }

    // Пуееукы
    public DepartmentEntity getDepartment() {
        return department;
    }

    public String getAction() {
        return action;
    }
}