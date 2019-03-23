package com.wang.miao.web.config.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * normal
 *
 * @author zhangzongli
 * @create 2019-03-23 15:04
 */
@Configuration
public class NormalMqConfig {

    @Bean
    public Queue queue() {
        return new Queue("hello");
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with("ha");
    }


}