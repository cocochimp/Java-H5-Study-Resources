package com.koko.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

@Aspect
class AnnotationPointcut {
    @Before("execution(* com.koko.service.UserServiceImpl.*(..))")
    public void before () {
        System.out.println("====方法执行前====");
    }
    @After("execution(* com.koko.service.UserServiceImpl.*(..))")
    public void after () {
        System.out.println("====方法执行后====");
    }
    //在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点
    @Around("execution(* com.koko.service.UserServiceImpl.*(..))")
    public void around (ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前");
        Signature signature = pjp.getSignature();//获得签名
        System.out.println("signature:" + signature);

        Object proceed = pjp.proceed();//执行方法
        System.out.println(proceed);
        System.out.println("环绕后");
    }
}

