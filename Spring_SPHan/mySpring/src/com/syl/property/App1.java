package com.syl.property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/syl/property/beans.xml");

        Student student1 = (Student) ac.getBean("stu1");
        System.out.println(student1.getId() +": "+ student1.getFirst_name() +
                " " + student1.getLast_name() +", " + student1.getAge());

        Student student2 = (Student) ac.getBean("stu2");
        System.out.println(student2.getId() +": "+ student2.getFirst_name() +
                " " + student2.getLast_name() +", " + student2.getAge());
        Student student3 = (Student) ac.getBean("stu3");
        System.out.println(student3.getId() + ": " + student3.getFirst_name() +
                " " + student3.getLast_name() + ", " + student3.getAge());
    }
}
