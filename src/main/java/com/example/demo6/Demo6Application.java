package com.example.demo6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Demo6Application {
	public static final String APP_PACKAGE_NAME = "com.example.demo6";

	public static void main(String[] args) {
		SpringApplication.run(Demo6Application.class, args);
	}
}
