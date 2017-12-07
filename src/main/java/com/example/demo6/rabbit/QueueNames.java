package com.example.demo6.rabbit;

import com.example.demo6.Demo6Application;

/**
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/8/2 15:10
 */
public interface QueueNames {

    String QUEUE_PREFIX = Demo6Application.APP_PACKAGE_NAME;
    String MESSAGE_QUEUE = QUEUE_PREFIX + ".message_queue";
    String USER_QUEUE = QUEUE_PREFIX + ".user_queue";
    String STUDENT_WORK_QUEUE = QUEUE_PREFIX + ".student_work_queue";
}
