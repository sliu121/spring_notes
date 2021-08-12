package com.atsyl.spring.mod;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestBySpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
//		Person person = (Person)  bf.getBean("person");

//		getBean by id
		//		Person person = (Person) ac.getBean("person");
//		getBean by class
		Person person = ac.getBean(Person.class);
		System.out.println(person.toString());
	}

}
