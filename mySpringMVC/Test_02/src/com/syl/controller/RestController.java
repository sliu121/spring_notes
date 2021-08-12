package com.syl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {

    @RequestMapping(value = "/testREST/{id}", method = RequestMethod.GET)
    public String getUesrById(
            @PathVariable("id")Integer id
    ){
        System.out.println("GET uesrId is:" + id);
        return "success";
    }

    @RequestMapping(value = "/testREST",method = RequestMethod.POST)
    public String insertUser(){
        System.out.println("POST");
        return "success";
    }

    /***
     * 项目是运行在 Tomcat 8 及以上，
     * 会发现发出的 PUT 请求和 DELETE 请求可以被控制其接收到，
     * 但是返回页面时（forward）会报HTTP 405 的错误提示：
     * “消息 JSP 只允许 GET、POST 或 HEAD。Jasper 还允许OPTIONS”。
     *
     * 解决方法：
     *  1. 使用Tomcat 8 一下版本
     *  2. 使用 @RestController 或者 @Controller + @ResponseBody, 但是这样无法实现页面跳转
     *  3. 使用重定向 redirect 方式跳转到另一个控制器方法，用这个控制器方法跳转页面
     *  4. 给Tomcat添加启动参数，让Tomcat允许写操作
     * @return
     */
    @RequestMapping(value = "/testREST",method = RequestMethod.PUT)
    public String UpdateUser(){
        System.out.println("PUT");
        return "redirect:/success";
    }
    @RequestMapping(value = "/testREST",method = RequestMethod.DELETE)
    public String DeleteUser(){
        System.out.println("Delete");
        return "redirect:/success";
    }

    @RequestMapping(value = "/success")
    public String success(){
        return "success";
    }

    /**
     * 使用AJAX测试请求方式
     */
    @RequestMapping(value = "testAjax_Delete", method = RequestMethod.DELETE)
    public void testAjax_Delete(Integer id){
        System.out.println("test Ajax, Id: " + id);
    }

}
