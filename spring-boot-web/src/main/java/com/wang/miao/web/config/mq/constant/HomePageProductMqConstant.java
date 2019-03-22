package com.wang.miao.web.config.mq.constant;

/**
 * Description:
 * 首页商品展示 推送mq常量
 *
 * @author zhangzongli
 * @create 2019-03-21 16:48
 */
public class HomePageProductMqConstant {

    /**
     * 上首页标识
     * 将要刷新到redis
     */
    public static final String START_TO_HOME_PAGE = "start";

    /**
     * 下首页标识
     * 将要redis中删除
     */
    public static final String END_TO_HOME_PAGE = "end";

    /** 消息发送体 map id  key */
    public static final String MESSAGE_MAP_ID_KEY = "id";

    /** 消息发送体 map 是否上首页 key */
    public static final String MESSAGE_MAP_IS_HOME_PAGE_FLAG = "isHomePageFlag";

}