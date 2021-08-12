package com.syl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    /**
     * @RequestMapping: 设置请求映射，把请求和控制层中的方法设置映射关系
     * 当请求路径和 @RequestMapping的 value属性值一致时，则该注解所标注的方法即为处理请求的方法
     *
     * method: 用来设置请求方式，只有客户端发送请求的方式和method的值一致，才能处理请求
     * 请求方法：GET->查询, POST->添加,  PUT->修改, DELETE->删除
     *
     * params: 用来设置客户端传到服务器的数据，支持表达式，通过参数来约束请求
     *         params={
     *              "username" -> 必须有该参数
     *              "！username" -> 不能有该参数
     *              "username = admin" -> 参数的值必须是 admin
     *              "username != admin" -> 参数的值不可以是 admin
     *         }
     *
     * headers: 用来设置请求头信息，所发送的请求的header必须要和此处设置的header保持一致
     *
     * @return
     */

    @RequestMapping(value = "/test",
            method = RequestMethod.POST
//            params = {"username","age != 12"}
//            headers = {"..."}
            )
    public String testPOST(){
        System.out.println("Success: POST");
        return "success";
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String testGet(){
        System.out.println("Success: GET");
        return "success";
    }

    /***
     * springMVC 支持使用ant标识来标识路径层级：
     *      *：标识一个层级
     *      **：零个或多个层级
     *      ？：标识层级的单个符，
     *
     * 通过使用占位符服务器可以获取传递参数：
     *      原本的数据接收：localhost:8080/test?id=123&username=admin
     *      现在的数据接收：localhost:8080/test/123/admin
     * @param id
     * @param username
     * @return
     */
    @RequestMapping("/**/testREST/{id}/{username}")
    public String testPath(
            @PathVariable("id")Integer id,
            @PathVariable("username")String username
    ){
        System.out.println(id + ": " + username);
        return "success";
    }

}
