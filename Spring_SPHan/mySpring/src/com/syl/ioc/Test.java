package com.syl.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class Test {
    public static void main(String[] args){
/** 从 ApplicationContext 里获取 bean
 * */
        //        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/syl/ioc/applicationContext.xml");
/** 从 BeanFactory 里获取 bean
 * */
//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com/syl/ioc/applicationContext.xml"));
//        beanFactory.getBean("student");

        /**
         * ApplicationContext 测试 singleton and prototype
         * **/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/syl/ioc/beans.xml");
        System.out.println("Test Begin...");

        /**
         * 使用 singleton, where singleton = "true"
         */
//        Student s1 = (Student) applicationContext.getBean("student");
//        Student s2 = (Student) applicationContext.getBean("student");
//        System.out.println(s1 == s2);

        /**
         * 使用 prototype, where singleton = "false"
         */
        Student s1 = (Student) applicationContext.getBean("student");
        Student s2 = (Student) applicationContext.getBean("student");
        System.out.println(s1 == s2);
    }
}
