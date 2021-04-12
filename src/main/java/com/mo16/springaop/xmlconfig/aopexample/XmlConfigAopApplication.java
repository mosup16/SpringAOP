package com.mo16.springaop.xmlconfig.aopexample;

import com.mo16.springaop.xmlconfig.aopexample.services.XmlConfigMessageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigAopApplication {
    public static void main(String[] args) {
        var  context = new ClassPathXmlApplicationContext("xml-aop-config.xml");
        var messageService = context.getBean(XmlConfigMessageService.class);
        messageService.onMessage("hello my friends from xml configs");
    }
}
