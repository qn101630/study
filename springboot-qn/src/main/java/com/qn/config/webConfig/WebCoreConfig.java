package com.qn.config.webConfig;

import com.qn.filter.LogFilter;
import com.qn.listener.LogListener;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 过滤器、监听器注入
 */
@SpringBootConfiguration
public class WebCoreConfig {
    @Bean
    public FilterRegistrationBean myFitler() {
        return new FilterRegistrationBean<>(new LogFilter());
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        return new ServletListenerRegistrationBean(new LogListener());
    }
}
