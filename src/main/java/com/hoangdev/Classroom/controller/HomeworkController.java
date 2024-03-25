package com.hoangdev.Classroom.controller;


import com.hoangdev.Classroom.service.homework.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @GetMapping("/index")
    public String getHomework(@RequestParam("classroomId") int classroomId, Model model){
        var homeworkList  = homeworkService.findHomeworkByClassId(classroomId);
        model.addAttribute("homeworkList", homeworkList);
        return "/user/homework-list";
    }

    @GetMapping("/getStudentHomework")
    public String getStudentHomework(@RequestParam("classId") int classroomId, @RequestParam("parentId") int parentId,Model model){
        var homeworkList  = homeworkService.findHomeworkByIdAndParentHomeworkId(classroomId, parentId);
        model.addAttribute("homeworkList", homeworkList);
        return "/user/homework-list";
    }

    @GetMapping("/detail-homework")
    public String detailHomework(){
        return "user/detail_homework";
    }

    @PostMapping("/add-grade")
    public String addGradeForStudent(@RequestParam("homeworkId") int homeworkId,
                                     @RequestParam("score") int score,@RequestParam("classroomId") int classroomId,
                                     Model mode){
        var exitHomework = homeworkService.findHomeworkById(homeworkId);
        exitHomework.ifPresent(homework -> {
           homework.setScore(score);
          homeworkService.saveHomework(homework);
       });
        return "redirect:/homework/index?classroomId="+classroomId;
    }



}
