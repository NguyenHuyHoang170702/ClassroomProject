package com.hoangdev.Classroom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClassroomController {
    @GetMapping("/test")
    public String text(){
        return "text";
    }

}
