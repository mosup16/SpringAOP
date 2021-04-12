package com.mo16.springaop.xmlconfig.aopexample.services;

import org.springframework.stereotype.Component;

@Component
public class XmlConfigMessageServiceImpl implements XmlConfigMessageService {
    @Override
    public void onMessage(String msg) {
        System.out.println(msg);
    }
}
