package com.syl.beanlife;




import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class PersonService implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {
    private String name;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public PersonService(String str){
        System.out.println("constructing... ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setting property name: name... ");
        this.name = name;
    }

    public void sayHi(){
        System.out.println("hi, " + name);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Setting bean name...");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Setting bean factory... ");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Setting ApplicationContext... ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean... ");
    }
//  我们自己的初始化方法

    public void init(){
        System.out.println("my own init method");
    }
//    //   使用注解方式
//    @PostConstruct public void initUseAt(){
//        System.out.println("my own init method");
//    }

//  我们自己的销毁方法
    public void myDestroy(){
        System.out.println("Destroyed!"); // you won't see it as the container has been destroyed already.
    }
//    //   使用注解方式
//    @PreDestroy
//    public void myDestroyUseAt(){
//        System.out.println("Destroyed!"); // you won't see it as the container has been destroyed already.
//    }

}
