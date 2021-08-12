package com.syl.inter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/syl/inter/beans.xml");
        UserCheck userCheck = (UserCheck) applicationContext.getBean("userCheck");
        userCheck.userCheck();
    }
}
