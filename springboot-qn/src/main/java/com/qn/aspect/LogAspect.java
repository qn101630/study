package com.qn.aspect;

import com.qn.interceptor.LogHandlerInterceptor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Order(1)
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(LogHandlerInterceptor.class);

    /**
     * 线程存放信息
     */
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 定义切入点
     * 第一个*：标识所有返回类型
     * 字母路径：包路径
     * 两个点..：当前包以及子包
     * 第二个*：所有的类
     * 第三个*：所有的方法
     * 最后的两个点：所有类型的参数
     */
    @Pointcut("execution(public * com.qn.controller..*.*(..))")
    public void webLog() {
    }

    /**
     * 在切入点开始处切入内容
     *
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 记录请求时间
        startTime.set(System.currentTimeMillis());
        // 获取请求域
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // 记录请求内容
        logger.info("Aspect-URL: " + request.getRequestURI().toLowerCase());
        logger.info("Aspect-HTTP_METHOD: " + request.getMethod());
        logger.info("Aspect-IP: " + request.getRemoteAddr());
        logger.info("Aspect-REQUEST_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("Aspect-Args: " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 在切入点之后处理内容
     */
    @After("webLog()")
    public void doAfter() {

    }

    /**
     * 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        logger.info("Aspect-Response: " + ret);
        Long endTime = System.currentTimeMillis();
        logger.info("Aspect-SpeedTime: " + (endTime - startTime.get()) + "ms");
    }

}


