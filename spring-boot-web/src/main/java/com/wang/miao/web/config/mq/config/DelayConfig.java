package com.wang.miao.web.config.mq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *      首页商品展示 rabbitmq 延迟队列
 *
 * @author zhangzongli
 * @create 2019-03-21 15:27
 */
@Configuration
@Slf4j
public class DelayConfig {

    /**
     * 延迟队列 TTL 名称
     */
    public static final String DELAY_QUEUE = "delay.queue";

    /**
     * DLX，dead letter 发送到的 exchange
     * 延时消息就是发送到该交换机的
     */
    public static final String DELAY_EXCHANGE = "delay.exchange";

    /**
     * routing key 名称
     * 具体消息发送在该 routingKey 的
     */
    public static final String DELAY_ROUTING_KEY = "delay.key";

    public static final String BEGIN_QUEUE = "begin.queue";
    public static final String BEGIN_EXCHANGE = "begin.exchange";
    public static final String BEGIN_ROUTING_KEY = "begin.key";

    /**
     * 创建一个死信队列
     * @return
     */
    @Bean("delayQueue")
    public Queue delayQueue() {
        return new Queue(DELAY_QUEUE, true);
    }

    /**
     * 配置死信队列
     * @return DirectExchange
     */
    @Bean("delayExchange")
    public DirectExchange delayExchange() {
        return new DirectExchange(DELAY_EXCHANGE);
    }

    /**
     * 死信队列 死信交换机 死信key绑定
     * @return
     */
    @Bean("dlxBinding")
    public Binding dlxBinding(@Qualifier("delayQueue") Queue delayQueue, @Qualifier("delayExchange") DirectExchange delayExchange) {
        return BindingBuilder.bind(delayQueue).to(delayExchange).with(DELAY_ROUTING_KEY);
    }

    /**
     * 正常队列配置
     *      配置死信交换机 DLX=DELAY_EXCHANGE
     *      配置死信key 不使用该队列的key，而是消息过期发送至死信交换机后 使用死信key
     *
     * 1、params.put("x-message-ttl", 5 * 1000);
     * 第一种方式是直接设置 Queue 延迟时间 但如果直接给队列设置过期时间,这种做法不是很灵活,（当然二者是兼容的,默认是时间小的优先）
     * 2、rabbitTemplate.convertAndSend(book, message -> {
     * message.getMessageProperties().setExpiration(2 * 1000 + "");
     * return message;
     * });
     * 第二种就是每次发送消息动态设置延迟时间
     * 采用第二种，对于时间固定的 采用第一种
     **/
    @Bean("beginQueue")
    public Queue beginQueue() {
        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", DELAY_EXCHANGE);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", DELAY_ROUTING_KEY);
        return new Queue(BEGIN_QUEUE, true, false, false, params);
    }

    /**
     * 配置正常交换机
     * @return
     */
    @Bean("beginDirectExchange")
    public DirectExchange beginDirectExchange() {
        return new DirectExchange(BEGIN_EXCHANGE);
    }

    /**
     * 正常队列 正常交换机 正常key 绑定
     * @return
     */
    @Bean("beginBinding")
    public Binding beginBinding(@Qualifier("beginQueue") Queue beginQueue, @Qualifier("beginDirectExchange") DirectExchange beginDirectExchange) {
        return BindingBuilder.bind(beginQueue).to(beginDirectExchange).with(BEGIN_ROUTING_KEY);
    }

}