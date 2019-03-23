package com.wang.miao.web;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 描述:
 *    Application
 * @author zhangzl
 * @create 2018-12-20 8:46 AM
 */
@SpringBootApplication
@EntityScan("com.wang.miao")
@EnableJpaRepositories(basePackages = {"com.wang.miao"})
@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
