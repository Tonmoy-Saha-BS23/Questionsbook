package com.bs23.Questionsbook.controller;

import com.bs23.Questionsbook.entity.User;
import com.bs23.Questionsbook.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Tag(name = "User")
@Controller
public class HomeController {
    private UserService userService;
    private Logger logger = Logger.getLogger(getClass().toString());
    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homepage(){
        return "home";
    }
    @GetMapping("/loginForm")
    public String showLoginForm(){
        return "login-form";
    }

    @GetMapping("/signUp")
    public String showSignUpForm(Model theModel){
        logger.info("Going to signupPage");
        User user = new User();
        logger.info("user object is created");
        theModel.addAttribute("data", user);
        logger.info("attribute is set");
        return "signup";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("data") User user){
        logger.info("One user is being created");
        userService.create(user);
        return "redirect:/loginForm";
    }

}
