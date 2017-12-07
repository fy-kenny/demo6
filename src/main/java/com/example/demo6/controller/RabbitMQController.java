package com.example.demo6.controller;

import com.example.demo6.model.StudentWork;
import com.example.demo6.model.User;
import com.example.demo6.rabbit.QueueNames;
import com.example.demo6.rabbit.Sender;
import com.example.demo6.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RabbitMQ Controller
 */
@RestController
@RequestMapping("rabbitMQ/")
public class RabbitMQController {

    @Autowired
    private Sender sender;

    @GetMapping("save")
    public ResponseEntity<String> save(){

        String id = ObjectId.get().toHexString();
        User user  = new User(id, 1234, "user1", null);

        String studentWorkId = ObjectId.get().toHexString();
        StudentWork studentWork = new StudentWork(studentWorkId, "studentWork1");

        sender.send(QueueNames.MESSAGE_QUEUE, id);
        sender.send(QueueNames.USER_QUEUE, user);
        sender.send(QueueNames.STUDENT_WORK_QUEUE, studentWork);

        return ResponseEntity.ok(id);
    }
}
