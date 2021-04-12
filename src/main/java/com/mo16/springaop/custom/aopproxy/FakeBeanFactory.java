package com.mo16.springaop.custom.aopproxy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class FakeBeanFactory {
    public <T> T getBean(Class<T> clazz) {
        if (clazz.equals(Customer.class)) {
            var loggingProxy = new CustomerLoggingProxy();
            loggingProxy.setBefore(() -> log.info("payment is being processed")); //you can get Before Instance from a beanFactory
            loggingProxy.setAfter(() -> log.info("payment is processed"));//you can get After Instance from a beanFactory
            return clazz.cast(loggingProxy);
        } else return null;
    }
}
