package com.mo16.springaop.javaconfig.aopexample.annotiations;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Loggable {
    String log() default "";
}
