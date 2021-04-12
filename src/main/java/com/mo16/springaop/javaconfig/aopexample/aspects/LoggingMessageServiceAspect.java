package com.mo16.springaop.javaconfig.aopexample.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingMessageServiceAspect {

    @Before("execution(* com.mo16.springaop.javaconfig.aopexample.services.MessageService.onMessage(String))")
    public void logOnMessageReceived(JoinPoint joinPoint) {
        log.info("message received -> " + joinPoint.getArgs()[0]);
    }

    @After("execution(* com.mo16.springaop.javaconfig.aopexample.services.MessageService.onMessage(..))")
    public void logOnMessageProcessed(JoinPoint joinPoint) {
        log.info("message processed -> " + joinPoint.getArgs()[0]);
    }
}
