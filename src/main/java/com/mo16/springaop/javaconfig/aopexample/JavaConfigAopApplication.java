package com.mo16.springaop.javaconfig.aopexample;

import com.mo16.springaop.javaconfig.aopexample.services.MessageService;
import com.mo16.springaop.javaconfig.aopexample.services.PasswordEncoder;
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
        var encoder = context.getBean(PasswordEncoder.class);
        encoder.encode("12345 is the best password ever");
    }

    @Bean
    public MessageService messageService(){
        return System.out::println;
    }

}
