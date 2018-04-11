package com.homelike.order.server.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-30 10:06
 **/
public interface StreamClient {

    /**
     * myMessage 队列消费消息
     */
    String INPUT = "myMessage";

    /**
     * myMessage 队列消费消息后回应 myMessage2 消息队列
     */
    String RESPONSE = "myMessage2";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.INPUT)
    MessageChannel output();

    @Input(StreamClient.RESPONSE)
    SubscribableChannel responseInput();

    @Output(StreamClient.RESPONSE)
    MessageChannel responseOutput();

}
