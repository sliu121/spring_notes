package com.syl.ioc;

// java 对象都有一个默认的无参构造函数
public class Student {
    String name;

    public Student(){
        System.out.println("Class Student has been impled");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
