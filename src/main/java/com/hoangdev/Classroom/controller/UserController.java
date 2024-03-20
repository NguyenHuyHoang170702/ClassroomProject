package com.hoangdev.Classroom.controller;


import com.hoangdev.Classroom.models.Role;
import com.hoangdev.Classroom.models.User;
import com.hoangdev.Classroom.service.role.RoleService;
import com.hoangdev.Classroom.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showUser(Model model){
        var lstUser = userService.findAllUser();
        model.addAttribute("users", lstUser);
        return "admin/showUser";
    }

    @GetMapping("/add-user")
    public String showFrmUser(Model model){
        model.addAttribute("user", new User());
        List<Role> listRoles= userService.getRoles();
        model.addAttribute("listRoles", listRoles);
        return "admin/frm_user";
    }

    @PostMapping("/save")
    public String saveUser(User user){
        userService.save(user);
        return "redirect:/user/users";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable int id, Model model){
        User user = userService.findUserById(id);
        List<Role> listRoles= userService.getRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "admin/frm_user";
    }

}
