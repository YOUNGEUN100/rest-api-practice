package com.example.practice4.aop.aops;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {
    @Pointcut("execution(* com.example.practice4.aop.controller..*.*(..)) ")
    private void logPointCut() {}

    @Before("logPointCut()")
    public void beforeLogAop(JoinPoint joinPoint) {
        System.out.println("LogAop의 before가 실행됨");
    }

    @AfterReturning(value = "logPointCut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("Logaop의 AfterReturning가 실행됨");
    }

}
