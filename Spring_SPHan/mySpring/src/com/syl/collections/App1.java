package com.syl.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.Map;

public class App1 {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/syl/collections/beans.xml");
//        Department department = (Department) applicationContext.getBean("department");
//        System.out.println(department.getName());
//        System.out.println("************Array 注值*****************");
//        for (String name: department.getEmpName()){
//            System.out.println(name);
//        }
//
//        System.out.println("************List 注值 && bean之间相互调用*****************");
//        for(Employees employee: department.getEmployeesList()){
//            System.out.println(employee.getName() + ": " + employee.getId());
//        }
//        System.out.println("************Set 注值 && bean之间相互调用*****************");
//        for(Employees employee: department.getEmpSet()){
//            System.out.println(employee.getName());
//        }
//        System.out.println("************Map 注值 && bean之间相互调用*****************");
//        Map<String, Employees> map = department.getEmpMap();
//        for(String i : map.keySet()){
//            System.out.println(map.get(i).getId() + ": " + map.get(i).getName());
//        }
//        System.out.println("************Map 注值 && 使用Entry获取*****************");
//        for(Map.Entry<String,Employees> employeesEntry: department.getEmpMap().entrySet()){
//            System.out.println(employeesEntry.getKey() +" " + employeesEntry.getValue().getName());
//        }
//        System.out.println("************Map 注值 && 使用Iterator*****************");
//        Iterator iterator = department.getEmpMap().values().iterator();
//        while (iterator.hasNext()){
//            Employees employees = (Employees) iterator.next();
//            System.out.println(employees.getId()+": "+employees.getName());
//        }
        Father father = (Father) applicationContext.getBean("father");
        Son son = (Son) applicationContext.getBean("son");

        father.getMessage1();
        father.getMessage2();

        son.getMessage1();
        son.getMessage2();
        son.getMessage3();

    }
}
