package com.syl.controller;


import com.syl.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.callback.LanguageCallback;

@Controller
public class ParamController {

    /**
     * 在springMVC获取客户端传递的数据的方式：
     * 1. 在处理请求的方法中，加入相对应的形参，保证形参的参数名和传递的数据的参数名保持一致，就可以自动赋值
     * 2. 使用 @RequestParam 可以解决：
     *      1. value: 将请求传递来的参数和当前形参弄成一个mapping
     *      2. required：该参数是不是必须的，默认下为true
     *      3. defaultValue: 若请求传递来的参数值为 null, 我们用它来设定一个值，常用于分页和模糊查询
     *
     */
//
//    @RequestMapping(value = "/param", method = RequestMethod.POST)
//    public String testParam(@RequestParam(value = "name", required = false, defaultValue = "admin") String userName, String Password, String Age){
//        System.out.println("username: "+ userName+", Password: "+ Password + ", Age: " + Age);
//        return "success";
//    }

    @RequestMapping(value = "/param", method = RequestMethod.POST)
    public String testSFoward(String name, String Password,String age, String state, String county){
        System.out.println("name: " + name);
        System.out.println("pwd: " + Password);
        System.out.println("age: " + age );
        System.out.println("state: " + state);
        System.out.println("county: " + county);

        return "success";
    }


    /***
     *  @RequestHeader: 在处理请求的方法上，获取请求头信息，用法和@RequestParam相同
     *
     */

//        @RequestMapping(value = "/param", method = RequestMethod.POST)
//        public String testRHeader(@RequestHeader(value = "Accept-Language") String language){
//            System.out.println("Accept-Language: " + language);
//            return "success";
//        }

        /***
     *  CookieValue: 在处理请求的方法上，获取请求的Cookie信息，用法和@RequestParam相同
     *
     */

//        @RequestMapping(value = "/param", method = RequestMethod.POST)
//        public String testCValue(@CookieValue(value = "JSESSIONID") String JsessionId){
//            System.out.println("JSESSIONID: " + JsessionId);
//            return "success";
//        }


    /**
     * 使用POJO实体类对象来获取客户端数据，要求实体类对象中的属性名一定要和页面中表单元素的name属性一致，但是非大小写敏感，而且支持级联关系(也就是用 . 标识)
     */


//        @RequestMapping(value = "/param", method = RequestMethod.POST)
//        public String testCValue(@ModelAttribute(value = "User") User user){
//            System.out.println(user.toString());
//            return "success";
//        }



    /**
     * View: 处理模型数据，实现页面跳转 (转发，重定向)
     * View类型：
     *      InternalResourceView：转发视图
     *      JstView：转发视图
     *      RedirectView：重定向视图
     *
     */


//        @RequestMapping(value = "/param", method = RequestMethod.POST)
//        public ModelAndView testMAV(){
//            ModelAndView mav = new ModelAndView();
//            mav.addObject("username","root"); //修改Request作用域属性的值
//            mav.setViewName("success"); // 设置视图名称，实现页面跳转
//            return mav;
//        }




}
