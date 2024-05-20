package com.koko.log;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;
public class log implements MethodBeforeAdvice, AfterReturningAdvice {
    //method:要执行的目标对象的方法（method being invoked）
    //args:参数（args: arguments to the method）
    //object:目标对象 （target：target of the method invocation）
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + "的" + method.getName() + "被执行了");
    }
    //returnValue:返回值
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了" + method.getName() + "方法，返回值为" + returnValue);
    }
}

