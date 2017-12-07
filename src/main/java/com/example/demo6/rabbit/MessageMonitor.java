package com.example.demo6.rabbit;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;

/**
 * File comments...
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/9/18 17:31
 */
@Slf4j
@Service
public class MessageMonitor implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        log.info("RabbitMQ receive message: ", message);
    }
}
