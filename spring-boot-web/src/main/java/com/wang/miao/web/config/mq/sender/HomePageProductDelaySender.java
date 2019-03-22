package com.wang.miao.web.config.mq.sender;

import com.xds.configuration.mq.config.HomePageProductDelayConfig;
import com.xds.dao.directsale.v20.ProductIndexRecommend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Description:
 * 首页商品展示 延迟消息生产者
 *
 * @author zhangzongli
 * @create 2019-03-21 16:06
 */
@Component
@Slf4j
public class HomePageProductDelaySender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 首页商品展示 延迟消息发送方法
     * @param productIndexRecommend 发送信息内容
     * @param time 延时时间
//     * @param isHomePageFlag 是否上首页标识 START_TO_HOME_PAGE：上首页标识  END_TO_HOME_PAGE：下首页标识
     */
    public void sendDelay(ProductIndexRecommend productIndexRecommend, Long time) {
        log.info("首页商品列表id:{}延迟消息生成时间:{}",productIndexRecommend.getId(), new Date().toString());
//        switch (isHomePageFlag) {
//            case HomePageProductMqConstant.START_TO_HOME_PAGE:
//                log.info("将于 " + productIndexRecommend.getStartDate() + "新增首页商品展示redis缓存");
//                break;
//            case HomePageProductMqConstant.END_TO_HOME_PAGE:
//                log.info("将于 " + productIndexRecommend.getEndDate() + "删除首页商品展示redis缓存");
//                break;
//            default:
//                log.info(productIndexRecommend.toString());
//        }

//        //消息发送体 map
//        Map<String, Object> messageMap = new HashMap<String, Object>(2) {
//            {
//                put(HomePageProductMqConstant.MESSAGE_MAP_ID_KEY, productIndexRecommend.getId());
//                put(HomePageProductMqConstant.MESSAGE_MAP_IS_HOME_PAGE_FLAG, isHomePageFlag);
//            }
//        };

        this.amqpTemplate.convertAndSend(HomePageProductDelayConfig.HOME_PAGE_PRODUCT_DELAY_EXCHANGE,
            HomePageProductDelayConfig.HOME_PAGE_PRODUCT_DELAY_ROUTING_KEY,
            productIndexRecommend.getId(),
            message -> {
                // 如果配置了 params.put("x-message-ttl", 5 * 1000); 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
                // 毫秒级
                message.getMessageProperties().setExpiration(time + "");
                return message;
        });
    }

}