package com.syl.beanlife;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App2 {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/syl/beanlife/beans.xml");
        PersonService personService = (PersonService) applicationContext.getBean("personService");
//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com/syl/beanlife/applicationContext.xml"));
//        PersonService personService = (PersonService) beanFactory.getBean("personService");
        personService.sayHi();
        /***
         * constructing...
         * setting property name: name...
         * Setting bean name...
         * Setting bean factory...
         * Setting ApplicationContext...
         * Before Initialization...
         * Initializing Bean...
         * my own init method
         * After Initialization...
         * hi, Siyu Liu
         *
         */
    }
}
