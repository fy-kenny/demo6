package com.example.demo6.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String queue, Object content) {
        log.info("sending \t\t[queue={}] : [message={}]", queue, content);

        this.rabbitTemplate.convertAndSend(queue, content);

        log.info("sent \t\t\t[queue={}] : [message={}]", queue, content);
    }

}