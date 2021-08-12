package com.syl.inter;

import com.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/syl/inter/beans.xml");
        /*** 1. 不用接口
         * **/
//        UpperLetter upperLetter = (UpperLetter) applicationContext.getBean("upperLetter");
//        System.out.println(upperLetter.getString());
//        System.out.println(upperLetter.Change());

        /** 2. 使用接口访问bean
         * **/
        ChangeLetter changeLetter = (ChangeLetter) applicationContext.getBean("lowerLetter");
        System.out.println(changeLetter.Change());

    }
}
