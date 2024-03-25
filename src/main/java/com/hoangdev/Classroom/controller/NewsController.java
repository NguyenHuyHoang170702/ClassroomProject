package com.hoangdev.Classroom.controller;


import com.hoangdev.Classroom.service.classroom.ClassroomService;
import com.hoangdev.Classroom.service.news.NewsService;
import com.hoangdev.Classroom.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private UserService userService;


    @GetMapping("/index")
    public String getNewsInClass(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam int ClassId){
        return "user/news";

    }
}
