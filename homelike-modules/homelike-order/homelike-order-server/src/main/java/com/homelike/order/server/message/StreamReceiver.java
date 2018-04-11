package com.homelike.order.server.message;

import com.homelike.order.common.request.CreateOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-30 10:08
 **/
@Component
@Slf4j
@EnableBinding(StreamClient.class)
public class StreamReceiver {

//    @StreamListener(StreamClient.INPUT)
//    public void process(Object message){
//        log.info("StreamReceiver : {} ",message);
//    }

    /**
     * 接收CreateOrderRequest
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.RESPONSE)
    public String process(CreateOrderRequest message){
        log.info("StreamReceiver INPUT : {} ",message);

        // 直接返回信息,将该信息发送到 StreamClient.RESPONSE 消息队列
        return "received.";
    }

    @StreamListener(StreamClient.RESPONSE)
    public void responseProcess(String message){
        log.info("StreamReceiver RESPONSE : {} ",message);
    }
}
