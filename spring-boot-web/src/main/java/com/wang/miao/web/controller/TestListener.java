package com.wang.miao.web.controller;

import org.springframework.stereotype.Component;

/**
 * Description:
 * Test Listener
 *
 * @author zhangzongli
 * @create 2019-03-23 19:48
 */
public class TestListener {

    public void listen(String msg) {
        System.out.println("msg = [" + msg + "]");
    }
}