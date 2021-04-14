package com.mo16.springaop.javaconfig.aopexample.annotiations;

import java.lang.annotation.*;

/**
 * have a similar behavior as org.springframework.transaction.annotation.Transactional
 * end it works on class level and method level.
 * when a method annotated with this annotation the {@link com.mo16.springaop.javaconfig.aopexample.aspects.TransactionManagerAspect} manageTransaction()
 * is executed to handle the Transaction
 */
@Inherited
@Target({ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Transactional {
}
