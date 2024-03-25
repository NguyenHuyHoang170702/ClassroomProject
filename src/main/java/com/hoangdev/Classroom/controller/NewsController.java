package com.hoangdev.Classroom.controller;


import com.hoangdev.Classroom.dto.NewsDto;
import com.hoangdev.Classroom.models.News;
import com.hoangdev.Classroom.service.classroom.ClassroomService;
import com.hoangdev.Classroom.service.news.NewsService;
import com.hoangdev.Classroom.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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
    public String getNewsInClass(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam int classId, Model model){
        int pageSize = 4;
        List<NewsDto> newsDtoList = new ArrayList<>();
        Page<News> newsPage = newsService.findPaginated(classId, pageNum,pageSize);
        List<News> lstNew = newsPage.getContent();
        lstNew.forEach(news ->{
            var teacherList = userService.findByRoleAndNews("ROLE_TEACHER", news.getId());
            var studentList = userService.findByRoleAndNews("ROLE_STUDENT", news.getId());
            newsDtoList.add(new NewsDto(
                    news.getId(),
                    news.getTitle(),
                    news.getContent(),
                    news.getTimestamp(),
                    teacherList,
                    studentList));
        });
        model.addAttribute("classroomId", classId);
        model.addAttribute("newsDtoList", newsDtoList);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalsPage", newsPage.getTotalPages());
        model.addAttribute("totalItems", newsPage.getTotalElements());


        return "user/news";

    }
}
