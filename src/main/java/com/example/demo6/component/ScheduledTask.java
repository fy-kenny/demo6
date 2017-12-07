package com.example.demo6.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * File comments...
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/10/19 14:25
 */
@Component
public class ScheduledTask {

    @Scheduled(fixedRate = 5000)
    public void printTime() {
        System.out.println("time: " + new Date().toLocaleString());
    }
}
