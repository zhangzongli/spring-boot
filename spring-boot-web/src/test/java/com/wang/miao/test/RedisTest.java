package com.wang.miao.test;

import com.wang.miao.web.Application;
import com.wang.miao.web.redis.RedisConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

/**
 * Description:
 * Redis Test
 *
 * @author zhangzongli
 * @create 2019-04-02 19:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void redisTest() throws UnsupportedEncodingException {

        redisTemplate.opsForValue().set(RedisConstant.STRING_KEY, "emmmmmm");

        System.out.println(redisTemplate.opsForValue().get(RedisConstant.STRING_KEY));

    }



}