package com.example.demo6.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/8/2 15:10
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue messageQueue() {
        return new Queue(QueueNames.MESSAGE_QUEUE);
    }

    @Bean
    public Queue userQueue() {
        return new Queue(QueueNames.USER_QUEUE);
    }

    @Bean
    public Queue studentWorkQueue() {
        return new Queue(QueueNames.STUDENT_WORK_QUEUE);
    }

    @Bean(name = "messageConverter")
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean(name = "rabbitTemplate")
    RabbitTemplate rabbitTemplate(
            @Qualifier(value = "messageConverter") MessageConverter messageConverter,
            ConnectionFactory connectionFactory) {

        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);

        return template;
    }
}