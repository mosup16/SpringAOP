package com.mo16.springaop.javaconfig.aopexample;

import com.mo16.springaop.javaconfig.aopexample.services.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
@EnableAspectJAutoProxy
@SpringBootApplication
public class JavaConfigAopApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(JavaConfigAopApplication.class, args);
        var messageService = context.getBean(MessageService.class);
        messageService.onMessage("hello my friends");
    }

    @Bean
    public MessageService messageService(){
        return System.out::println;
    }

}
