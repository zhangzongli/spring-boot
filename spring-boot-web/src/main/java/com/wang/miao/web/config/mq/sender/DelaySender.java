package com.wang.miao.web.config.mq.sender;

import com.wang.miao.web.config.mq.config.DelayConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description:
 * 首页商品展示 延迟消息生产者
 *
 * @author zhangzongli
 * @create 2019-03-21 16:06
 */
@Component
@Slf4j
public class DelaySender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 首页商品展示 延迟消息发送方法
     * @param msg 发送信息内容
     * @param time 延时时间
     */
    public void sendDelay(String msg, Long time) {

        this.amqpTemplate.convertAndSend(DelayConfig.BEGIN_EXCHANGE,
            DelayConfig.BEGIN_ROUTING_KEY, msg,
            message -> {
                // 如果配置了 params.put("x-message-ttl", 5 * 1000); 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
                // 毫秒级
                message.getMessageProperties().setExpiration(time + "");
                return message;
        });
    }

}