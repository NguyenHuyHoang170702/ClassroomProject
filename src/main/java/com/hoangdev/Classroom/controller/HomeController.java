package com.hoangdev.Classroom.controller;


import com.hoangdev.Classroom.models.User;
import com.hoangdev.Classroom.service.user.UserService;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String Index(){
        return "index";
    }

    @GetMapping("/index")
    public String Index1(){
        return "success";
    }

    @GetMapping("/success1")
    public String success1(){
        return "success";
    }
    @GetMapping("login-register")
    public String RegisterAndLogin( Model model){
        model.addAttribute("user", new User());
        return "login-register";
    }
    @PostMapping("process_register")
    public String Register(@NotNull User user){
        userService.saveUserWithDefaultRole(user);
        return "redirect:/login-register";
    }


}
