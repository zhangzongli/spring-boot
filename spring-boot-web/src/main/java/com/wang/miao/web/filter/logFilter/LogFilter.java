package com.wang.miao.web.filter.logFilter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 描述:
 *    Log filter 过滤器
 * @author zhangzl
 * @create 2018-12-24 10:16 PM
 */
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("Execute cost=" + (System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {

    }
}
