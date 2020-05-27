package com.qn.listener;

import com.qn.interceptor.LogHandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LogListener implements ServletContextListener {

    Logger logger = LoggerFactory.getLogger(LogHandlerInterceptor.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("监听器开始初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("监听器开始销毁");
    }
}
