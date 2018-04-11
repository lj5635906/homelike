package com.homelike.order.server.rest;

import com.homelike.common.web.vo.ResultVo;
import com.homelike.order.common.request.CreateOrderRequest;
import com.homelike.order.server.message.StreamClient;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-29 17:07
 **/
@RestController
@RequestMapping("/message")
public class MessageRest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private StreamClient streamClient;

    @PostMapping("/homelike")
    public ResultVo homelike(){
        amqpTemplate.convertAndSend("homelike","now : "+new Date());
        return ResultVo.ok();
    }

    @PostMapping("/computer")
    public ResultVo computer(){
        amqpTemplate.convertAndSend("myOrder","computer","now : "+new Date());
        return ResultVo.ok();
    }

    @PostMapping("/fruit")
    public ResultVo fruit(){
        amqpTemplate.convertAndSend("myOrder","fruit","now : "+new Date());
        return ResultVo.ok();
    }

    @PostMapping("/stream-send1")
    public ResultVo streamSend1(){
        String message = "now "+new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
        return ResultVo.ok();
    }

    @PostMapping("/stream-send")
    public ResultVo streamSend(){
        CreateOrderRequest request = new CreateOrderRequest();
        request.setCustomerId(1L);
        request.setCustomerShoppingAddressId(2L);
        streamClient.output().send(MessageBuilder.withPayload(request).build());
        return ResultVo.ok();
    }


}
