package com.wang.miao.web.config.filter;

import com.wang.miao.web.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * 描述:
 *    Filter Config
 * @author zhangzl
 * @create 2018-12-24 10:20 PM
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new LogFilter());
        registrationBean.setUrlPatterns(new ArrayList<String>() {
            {
                add("/api/*");
            }
        });
        registrationBean.setName("logTimeFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
