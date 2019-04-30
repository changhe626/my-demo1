package com.onyx.mydemo.demo2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zk on 2017/12/23.
 * 作用: com.onyx2.aspect.
 */
@Aspect
@Component
public class HttpAspect {

    private JoinPoint joinPoint;

    //import org.slf4j.Logger;
    //当前类名的.class
    private static final Logger LOGGER= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.onyx.mydemo.demo2.controller.GirlsController.*(..))")
    public void log(){

    }

    //..表示任何参数都被拦截
    @Before("execution(public * com.onyx.mydemo.demo2.controller.GirlsController.getGirlsList(..))")
    public void doBefore(){
        //System.out.println("1111");
        LOGGER.info("1111");
        //url
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        LOGGER.info("url={}",request.getRequestURL());
        //post/get
        LOGGER.info("method={}",request.getMethod());
        //ip
        LOGGER.info("ip={}",request.getRemoteAddr());
        //类方法
        LOGGER.info("class_Method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        LOGGER.info("args={}",joinPoint.getArgs());
    }

    @Before("log()")
    public void doBefore2(){
        //System.out.println("1.1111");
        LOGGER.info("1.1111");
    }

    //拦截GirlsController 中的所有的方法,*表示所有
    @After("execution(public * com.onyx.mydemo.demo2.controller.GirlsController.*(..))")
    public void doAfter(){
        //System.out.println("2222");
        LOGGER.info("2222");

    }

    /**
     * 获取返回的内容,要具体的内容的话,Girl加上toString方法
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void afterReturning(Object object){
        //返回null时候,抛出异常
        LOGGER.info("returning={}",object.toString());
    }



}
