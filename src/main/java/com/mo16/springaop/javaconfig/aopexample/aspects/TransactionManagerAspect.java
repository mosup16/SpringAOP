package com.mo16.springaop.javaconfig.aopexample.aspects;

import com.mo16.springaop.javaconfig.aopexample.annotiations.Loggable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagerAspect {

    private final TransactionUtils utils;

    public TransactionManagerAspect(TransactionUtils utils) {
        this.utils = utils;
    }

    @Pointcut("@annotation(com.mo16.springaop.javaconfig.aopexample.annotiations.Transactional) " +
            "|| @within(com.mo16.springaop.javaconfig.aopexample.annotiations.Transactional)")
    public void onTransactional(){}

    @Around("onTransactional()")
    public Object manageTransaction(ProceedingJoinPoint joinPoint){
        utils.startTransaction();
        Object proceeded = null;
        try {
            proceeded = joinPoint.proceed();
            utils.commitTransaction();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
            utils.rollBackTransaction(throwable);
        }
        return proceeded;
    }


    @Component
    static class TransactionUtils{
        @Loggable(log = "beginning a transaction")
        public void startTransaction() {}

        @Loggable(log = "commit a transaction")
        public void commitTransaction() {}

        @Loggable(log = "rolled back a transaction")
        public void rollBackTransaction(Throwable throwable) {}
    }

}
