package com.mo16.springaop.javaconfig.aopexample.aspects;

import com.mo16.springaop.javaconfig.aopexample.annotiations.Loggable;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggableLoggerAspect {

    @Pointcut("@annotation(com.mo16.springaop.javaconfig.aopexample.annotiations.Loggable)")
    void loggableMethod() {
    }

    @Pointcut("loggableMethod()")
    void onLoggable() {
    }

    @SneakyThrows
    @After("onLoggable()")
    public void logOnLoggable(JoinPoint point) {
        //todo : check if there is an optimal solution
        var signature = (MethodSignature) point.getSignature();
        Loggable loggable = point.getTarget()
                .getClass()
                .getMethod(signature.getName(), signature.getParameterTypes())
                .getAnnotation(Loggable.class);

        log.info(loggable.log());
    }
}
