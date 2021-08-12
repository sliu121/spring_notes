package com.test;

import com.service.ByeService;
import com.service.UserService;
import com.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String args[]){
        // 我们先使用传统方法来调用UserService的sayHello()
//        UserService userService = new UserService();
//        userService.setName("Siyu Liu");
//        userService.sayHello();

/**
 *         我们现在用Spring的方法来做
 *         1. import spring package (最小配置spring.jar 该包把常用的jar都包括，同时我们引入一个日志包 common-logging.jar)
 *         2. 创建spring 的一个核心文件 applicationContext.xml [hibernate: hibernate.cfg.xml, struts: struts-config.xml],
 *            该文件一般放置在src文件下
 *         3. 新建一个applicationContext.xml 并对内容进行修改
 *         4. 开始测试：
  */
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        UserService userService = (UserService) applicationContext.getBean("userService");
//        userService.sayHello();
//
////        一个xml文件支持多个bean的存在
//        ByeService byeService = (ByeService) applicationContext.getBean("byeService");
//        byeService.sayBye();

//        优化 1: 把ApplicationContext做成一个单例类型
        ((UserService) ApplicationContextUtil.getApplicationContext()
                .getBean("userService"))
                .sayHello();


    }
}
