package com.wang.miao.web.config.mq.listener;

import com.xds.configuration.mq.config.HomePageProductDelayConfig;
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
public class HomePageProductDelayListener {

    /**
     * 首页商品展示 延迟队列 接收方法
//     * @param messageMap
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = HomePageProductDelayConfig.HOME_PAGE_PRODUCT_QUEUE_NAME, durable = "true"),
        exchange = @Exchange(value = HomePageProductDelayConfig.HOME_PAGE_PRODUCT_DELAY_EXCHANGE),
        key = HomePageProductDelayConfig.HOME_PAGE_PRODUCT_ROUTING_KEY))
    public void receiveMessage(Integer id, Message message) {
        try {
//            log.info("【homePageProductDelayQueue 监听的消息】 - 【消费时间】 - [{}]- 【首页商品展示列表id:】 - [{}]",
//                new Date(), messageMap.get(HomePageProductMqConstant.MESSAGE_MAP_ID_KEY));
//            switch ((String) messageMap.get(HomePageProductMqConstant.MESSAGE_MAP_IS_HOME_PAGE_FLAG)) {
//                case HomePageProductMqConstant.START_TO_HOME_PAGE:
//                    break;
//                case HomePageProductMqConstant.END_TO_HOME_PAGE:
//                    break;
//                default:
//            }

            // 获取该首页商品详情
            // TODO: 2019/3/21 更新redis
            String a = "1";

        } catch (Exception e) {
            log.error("RabbitMQ Error" + e.getMessage(), e);
        }
    }

}