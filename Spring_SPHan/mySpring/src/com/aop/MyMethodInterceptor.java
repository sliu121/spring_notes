package com.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Before method proceed..." + methodInvocation.getMethod().getName());
        Object b= methodInvocation.proceed();
        System.out.println("After method proceed..." + methodInvocation.getMethod().getName());
        return b;
    }
}
