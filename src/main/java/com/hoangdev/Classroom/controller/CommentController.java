package com.hoangdev.Classroom.controller;

import com.hoangdev.Classroom.models.Comment;
import com.hoangdev.Classroom.service.classroom.ClassroomService;
import com.hoangdev.Classroom.service.comment.CommentService;
import com.hoangdev.Classroom.service.news.NewsService;
import com.hoangdev.Classroom.service.user.UserService;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private NewsService newsService;


    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/{newsId}")
    public String addCmt(@PathVariable("newsId") Long newsId, Model model) {
        model.addAttribute("newsId", newsId);
        model.addAttribute("comment", new Comment());
        return "user/detailNews";
    }

    @PostMapping()
    public String postAddComment(@RequestParam(value = "newsId") Long newsId, @NotNull Comment comment) {
        comment.setTimestamp(new Date());
        comment.setNews(newsService.getNewsByNewsId(newsId));
        comment.setUser(userService.getCurrentAccount());
        commentService.addComment(comment);
        return "redirect:/news/detail-news?newsId=" + newsId;
    }

}
