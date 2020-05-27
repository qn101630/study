package com.qn.filter;

import com.qn.interceptor.LogHandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LogFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(LogHandlerInterceptor.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("过滤器生效！！！");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
