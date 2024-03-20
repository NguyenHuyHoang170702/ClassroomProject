package com.hoangdev.Classroom.controller;

import com.hoangdev.Classroom.models.User;
import com.hoangdev.Classroom.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;
    @GetMapping("/showAccount")
    public String accountInfo(Model model){
        User user =  userService.getCurrentAccount();
        model.addAttribute("user", user);
        model.addAttribute("role", user.getRoles());
        return "user/account_info";
    }
}
