package com.wang.miao.web.filter.logFilter;

import com.wang.miao.web.filter.logFilter.LogFilter;
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
public class LogFilterConfig {

    @Bean
    @SuppressWarnings("unchecked")
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
