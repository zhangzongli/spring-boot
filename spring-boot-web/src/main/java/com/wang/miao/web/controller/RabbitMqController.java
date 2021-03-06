package com.wang.miao.web.controller;

import com.wang.miao.web.config.mq.config.DelayConfig;
import com.wang.miao.web.config.mq.sender.DelaySender;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Description:
 * RabbitMq Controller
 *
 * @author zhangzongli
 * @create 2019-03-23 11:22
 */
@RestController
@RequestMapping("/mq")
public class RabbitMqController {

    @Autowired
    private DelaySender delaySender;

    @GetMapping("/send-delay")
    public void sendDelay() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        delaySender.sendDelay(context, 20000L);
    }
}