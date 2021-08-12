package com.syl.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account/*")
public class UserAccountController {
    @RequestMapping
    public String login(){
         return "login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup/process")
    public String proccessSignup(ModelMap model,
                                 @RequestParam("username") String username,
                                 @RequestParam("emailaddress") String emailAddress,
                                 @RequestParam("password") String password){
        model.addAttribute("login", true);
        model.addAttribute("username",username);

        return "index";
    }

    @GetMapping("/forgotpassword")
    public String forgetpassword(){
        return "forgetpassword";
    }

}
