package com.bs23.Questionsbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homepage(){
        return "home";
    }
    @GetMapping("/loginForm")
    public String showLoginForm(){
        return "login-form";
    }
}
