package com.homelike.order.server.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * RabbitMq消息接收
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-29 16:56
 **/
@Component
@Slf4j
public class RabbitMqReceiver {

    // 1.手动创建队列 @RabbitListener(queues = "myQueue")
    // 2.自动创建队列 @RabbitListener(queuesToDeclare = @Queue("homelike"))
    // 3.自动创建队列 Exchange和Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("homelike"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("接收消息 : {}", message);
    }


    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void processComputer(String message) {
        log.info("computer : {}", message);
    }


    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
    ))
    public void processFruit(String message) {
        log.info("fruit : {}", message);
    }

}
