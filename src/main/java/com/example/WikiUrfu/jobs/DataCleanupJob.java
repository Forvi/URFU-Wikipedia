package com.example.WikiUrfu.jobs;

import com.example.WikiUrfu.repository.TeacherRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataCleanupJob {

    private final TeacherRepo teacherRepo;

    @Scheduled(cron = "0 0 3 * * *") // Каждый день в 3:00
    @Transactional
    public void cleanupInactiveTeachers() {
        LocalDateTime oneYearAgo = LocalDateTime.now().minus(1, ChronoUnit.YEARS);
        int deleted = teacherRepo.deleteByCreatedAtBefore(oneYearAgo);
        log.info("Удалено {} неактивных преподавателей", deleted);
    }
}