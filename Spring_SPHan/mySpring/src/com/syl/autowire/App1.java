package com.syl.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/syl/autowire/applicationContext.xml");
        Master master = (Master) ac.getBean("master");
        System.out.println(master.getName() + ": "+ master.getDog().getName() +", " + master.getDog().getAge());
        Master master2 = (Master) ac.getBean("master2");
        System.out.println(master2.getName() + ": "+ master2.getDog().getName() +", " + master2.getDog().getAge());
    }
}
