package com.example.WikiUrfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableScheduling
@EnableAspectJAutoProxy
public class WikiUrfuApplication {

	public static void main(String[] args) {
		SpringApplication.run(WikiUrfuApplication.class, args);
	}
}