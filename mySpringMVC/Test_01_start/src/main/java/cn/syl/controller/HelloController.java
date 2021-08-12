package cn.syl.controller;

//控制器类

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    /**
     * // @RequestMapping 中的path路径加不加 / 都可以运行, 直接在括号内加入响应page就行了
     * @return
     */
    @RequestMapping(path = "hello")
    public String sayHello(){
        System.out.println("hello SpringMVC");
        return "success";
    }

    @RequestMapping(path = "/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("This is testRequestMapping");
        return "success";
    }

    @RequestMapping("heya")
    public String testHeya(){
        System.out.println("This is test for no path mentioned in () ");
        return "success";
    }

    @RequestMapping("getNamePass")
    public String testUserPass(String username, String password){
        System.out.println(username +" : " + password);
        return "success";
    }
}
