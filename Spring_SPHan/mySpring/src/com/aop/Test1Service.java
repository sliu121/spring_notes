package com.aop;

public class Test1Service implements TestServiceInt, TestServiceInter2{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("hi, "+ getName());
    }

    @Override
    public void sayBey() {
        System.out.println("bye, " + getName());
    }
}
