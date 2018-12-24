package com.wang.miao.web.aop;

import java.lang.annotation.*;

/**
 * log 自定义注解
 * @author zhangzl
 * @date 2018/12/24 9:24 AM
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
}
