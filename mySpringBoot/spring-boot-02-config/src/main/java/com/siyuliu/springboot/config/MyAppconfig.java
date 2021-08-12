package com.siyuliu.springboot.config;

import com.siyuliu.springboot.service.HellowService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *  @Configuration: 当前类是一个配置类，用于代替原来的Spring 配置文件
 *
 */

@Configuration
public class MyAppconfig {
//    将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
    @Bean
    public HellowService hellowService02(){
        System.out.println("We use @Configuration");
        return new HellowService();
    }
}
