package com.wang.miao.web.config.mq.listener;

import com.wang.miao.web.config.mq.config.DelayConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 * 首页商品展示延迟队列消费者
 *
 * @author zhangzongli
 * @create 2019-03-21 16:28
 */
@Component
@Slf4j
public class DelayListener {

    /**
     * 首页商品展示 延迟队列 接收方法
//     * @param messageMap
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = DelayConfig.DELAY_QUEUE, durable = "true"),
        exchange = @Exchange(value = DelayConfig.DELAY_EXCHANGE),
        key = DelayConfig.DELAY_ROUTING_KEY))
    public void receiveMessage(String msg, Message message) {
        try {

            // 获取该首页商品详情
            // TODO: 2019/3/21 更新redis
            System.out.println("msg = [" + msg + "], message = [" + message + "]");

        } catch (Exception e) {
            log.error("RabbitMQ Error" + e.getMessage(), e);
        }
    }

}