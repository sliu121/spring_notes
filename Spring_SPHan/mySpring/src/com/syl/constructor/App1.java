package com.syl.constructor;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/syl/constructor/beans.xml");
        Emloyee emloyee = (Emloyee) ac.getBean("emp0");
        System.out.println(emloyee.getName()+": "+emloyee.getAge());
    }
}
