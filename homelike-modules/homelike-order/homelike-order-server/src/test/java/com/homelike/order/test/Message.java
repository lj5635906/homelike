package com.homelike.order.test;

import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-03-29 16:59
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Message {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @org.junit.Test
    public void send(){
        amqpTemplate.convertAndSend("myQueue","now : "+new Date());
    }

}
