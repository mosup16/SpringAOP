package com.mo16.springaop.javaconfig.aopexample.services;

import com.mo16.springaop.javaconfig.aopexample.annotiations.Loggable;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderImpl implements PasswordEncoder {

    @Loggable(log = "password encrypted successfully")
    @Override
    public void encode(String password) {
        System.out.println("password encrypted");
    }
}
