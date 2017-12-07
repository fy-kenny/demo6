package com.example.demo6.rabbit;

import com.example.demo6.model.StudentWork;
import com.example.demo6.model.User;
import com.example.demo6.service.StudentWorkService;
import com.example.demo6.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/8/2 15:10
 */

@Slf4j
@Component
public class Receiver {

    @Autowired
    private StudentWorkService studentWorkService;
    @Autowired
    private UserService userService;

    @RabbitListener(queues = {QueueNames.MESSAGE_QUEUE})
    public void onMessageQueue(String workId) throws Exception{
        log.info("received \t\t[queue={}] : [message={}]", QueueNames.MESSAGE_QUEUE, workId);

        process(workId);

        log.info("processed \t[queue={}] : [message={}]", QueueNames.MESSAGE_QUEUE, workId);
    }

    private void process(String workId) {
        log.info("processing \t[queue={}] : [message={}]", QueueNames.MESSAGE_QUEUE, workId);
    }

    @RabbitListener(queues = {QueueNames.USER_QUEUE})
    public void onUserQueue(User user) throws Exception{
        log.info("received \t\t[queue={}] : [message={}]", QueueNames.USER_QUEUE, user);

        saveUser(user);

        log.info("processed \t[queue={}] : [message={}]", QueueNames.USER_QUEUE, user);
    }

    private void saveUser(User user) {
        log.info("processing \t[queue={}] : [message={}]", QueueNames.USER_QUEUE, user);

        log.warn("id = " + user.getId());
        log.warn("userId = " + user.getUserId());
        log.warn("userName = " + user.getUserName());

        userService.save(user);
    }

    @RabbitListener(queues = {QueueNames.STUDENT_WORK_QUEUE})
    public void onStudentWorkQueue(StudentWork studentWork) throws Exception{
        log.info("received \t\t[queue={}] : [message={}]", QueueNames.STUDENT_WORK_QUEUE, studentWork);

        saveStudentWork(studentWork);

        log.info("processed \t[queue={}] : [message={}]", QueueNames.STUDENT_WORK_QUEUE, studentWork);
    }

    private void saveStudentWork(StudentWork studentWork) {
        log.info("processing \t[queue={}] : [message={}]", QueueNames.STUDENT_WORK_QUEUE, studentWork);

        log.warn("id = " + studentWork.getId());
        log.warn("studentName = " + studentWork.getName());

        studentWorkService.save(studentWork);
    }
}