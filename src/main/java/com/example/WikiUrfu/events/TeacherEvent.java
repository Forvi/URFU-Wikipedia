package com.example.WikiUrfu.events;

import com.example.WikiUrfu.entity.TeacherEntity;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class TeacherEvent extends ApplicationEvent {
    private final TeacherEntity teacher;
    private final String action;

    public TeacherEvent(Object source, TeacherEntity teacher, String action) {
        super(source);
        this.teacher = teacher;
        this.action = action;
    }

}
