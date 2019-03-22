package com.wang.miao.web.config.mq.config;

import org.springframework.amqp.core.*;
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
public class HomePageProductDelayConfig {

    /**
     * 延迟队列 TTL 名称
     */
    private static final String HOME_PAGE_PRODUCT_DELAY_QUEUE = "home.page.product.delay.queue";

    /**
     * DLX，dead letter 发送到的 exchange
     * 延时消息就是发送到该交换机的
     */
    public static final String HOME_PAGE_PRODUCT_DELAY_EXCHANGE = "home.page.product.delay.exchange";

    /**
     * routing key 名称
     * 具体消息发送在该 routingKey 的
     */
    public static final String HOME_PAGE_PRODUCT_DELAY_ROUTING_KEY = "home.page.product.delay.key";

    public static final String HOME_PAGE_PRODUCT_QUEUE_NAME = "home.page.product.queue";
    public static final String HOME_PAGE_PRODUCT_EXCHANGE_NAME = "home.page.product.exchange";
    public static final String HOME_PAGE_PRODUCT_ROUTING_KEY = "home.page.product.key";

    /**
     * 延迟队列配置
     * <p>
     * 1、params.put("x-message-ttl", 5 * 1000);
     * 第一种方式是直接设置 Queue 延迟时间 但如果直接给队列设置过期时间,这种做法不是很灵活,（当然二者是兼容的,默认是时间小的优先）
     * 2、rabbitTemplate.convertAndSend(book, message -> {
     * message.getMessageProperties().setExpiration(2 * 1000 + "");
     * return message;
     * });
     * 第二种就是每次发送消息动态设置延迟时间,这样我们可以灵活控制
     **/
    @Bean
    public Queue homePageProductDelayQueue() {
        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", HOME_PAGE_PRODUCT_EXCHANGE_NAME);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", HOME_PAGE_PRODUCT_ROUTING_KEY);
        return new Queue(HOME_PAGE_PRODUCT_DELAY_QUEUE, true, false, false, params);
    }

    /**
     * 需要将一个队列绑定到交换机上，要求该消息与一个特定的路由键完全匹配。
     * 这是一个完整的匹配。如果一个队列绑定到该交换机上要求路由键 “dog”，则只有被标记为“dog”的消息才被转发，
     * 不会转发dog.puppy，也不会转发dog.guard，只会转发dog。
     * @return DirectExchange
     */
    @Bean
    public DirectExchange homePageProductDelayExchange() {
        return new DirectExchange(HOME_PAGE_PRODUCT_DELAY_EXCHANGE);
    }

    @Bean
    public Binding dlxBinding() {
        return BindingBuilder.bind(homePageProductDelayQueue()).to(homePageProductDelayExchange()).with(HOME_PAGE_PRODUCT_DELAY_ROUTING_KEY);
    }

    @Bean
    public Queue homePageProductQueue() {
        return new Queue(HOME_PAGE_PRODUCT_QUEUE_NAME, true);
    }

    /**
     * 将路由键和某模式进行匹配。此时队列需要绑定要一个模式上。
     * 符号“#”匹配一个或多个词，符号“*”匹配不多不少一个词。因此“audit.#”能够匹配到“audit.irs.corporate”，但是“audit.*” 只会匹配到“audit.irs”。
     **/
    @Bean
    public TopicExchange orderTopicExchange() {
        return new TopicExchange(HOME_PAGE_PRODUCT_EXCHANGE_NAME);
    }

    @Bean
    public Binding homePageProductBinding() {
        return BindingBuilder.bind(homePageProductQueue()).to(orderTopicExchange()).with(HOME_PAGE_PRODUCT_ROUTING_KEY);
    }

}