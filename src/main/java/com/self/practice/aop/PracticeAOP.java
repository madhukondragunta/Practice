package com.self.practice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PracticeAOP {

   @Before("execution(* com.self.practice.kafka.KafkaConsumerService.*(..))")
    public Object before(){
        System.out.println("-----------------KafkaConsumerService about to called----------------------");
        return null;
    }
    @After("execution(* com.self.practice.kafka.*.*(..))")
    public Object after(){
        System.out.println("-----------------KafkaConsumerService completed ----------------------");
        return null;
    }
}
