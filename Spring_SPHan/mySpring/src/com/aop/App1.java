package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/aop/beans.xml");
        /***
         *  传统方法调用 没有任何变化
         */
//        Test1Service test1Service = (Test1Service) ac.getBean("test1Service");
//        test1Service.sayHello();

        /**
         *
         */
        TestServiceInt testService = (TestServiceInt) ac.getBean("proxyFactoryBean");
        testService.sayHello();
        ((TestServiceInter2) testService).sayBey();


    }
}
