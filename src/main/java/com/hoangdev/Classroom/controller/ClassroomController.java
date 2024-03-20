package com.hoangdev.Classroom.controller;

import com.hoangdev.Classroom.service.classroom.ClassroomService;
import com.hoangdev.Classroom.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String getClassroom(Model model){
        var classOfUser = classroomService.getClassByUsername(userService.getCurrentAccount().getUsername());
        model.addAttribute("lstClass", classOfUser);
        return "user/classroomOfUser";
    }



}
