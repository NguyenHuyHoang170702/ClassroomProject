package com.hoangdev.Classroom.controller;

import com.hoangdev.Classroom.dto.ClassroomDto;
import com.hoangdev.Classroom.models.Classroom;
import com.hoangdev.Classroom.service.classroom.ClassroomService;
import com.hoangdev.Classroom.service.user.UserService;
import com.hoangdev.Classroom.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getClassroom(Model model){
        var classOfUser = classroomService.getClassByUsername(userService.getCurrentAccount().getUsername());
        model.addAttribute("lstClass", classOfUser);
        return "user/classroomOfUser";
    }

    @GetMapping("/index")
    public String listClassroomPaginate(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model){
        int pageSize = 6;
        List<ClassroomDto> classroomDtoList = new ArrayList<>();
        Page<Classroom> page = classroomService
                .getClassByUsernamePaginate(userService.getCurrentAccount().getUsername(),pageNum,pageSize);
        List<Classroom> classroomListView = page.getContent();

        classroomListView.forEach(classroom -> {
            var teacherList = userService.findByRoleAndClassroom("ROLE_TEACHER",classroom.getId());
            var studentList = userService.findByRoleAndClassroom("ROLE_STUDENT", classroom.getId());

            classroomDtoList.add(new ClassroomDto(
                    classroom.getId(),
                    classroom.getNameClass(),
                    classroom.getDescriptionClass(),
                    classroom.getCodeClass(),
                    teacherList,
                    studentList,
                    studentList.size()));
        });

        model.addAttribute("classroomDtoList", classroomDtoList);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalsPage", page.getTotalPages());
        model.addAttribute("totalsItems", page.getTotalElements());
        model.addAttribute("newClassroom", new Classroom());
        return "user/classroomOfUser";
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String CreateNewClass(Classroom classroom){
        var currentUser = userService.getCurrentAccount();
        classroom.setCodeClass(Helper.getRandomNumberString());
        currentUser.addClass(classroom);
        userService.save(currentUser);
        return "redirect:/classroom/index";
    }

    @PostMapping("/join")
    public String joinClassByCode(@RequestParam String keyword,Classroom classroom){
        var currentUser = userService.getCurrentAccount();
        classroom = classroomService.findByCodeClassId(keyword);
        currentUser.getClassrooms().add(classroom);
        userService.addUser(currentUser);
        return "redirect:/classroom/detail/"+classroom.getId();
    }


    // chua xong
    @GetMapping("/detail/{id}")
    public String detailClass(@PathVariable int id, Model model){
        var exitClass = classroomService.findClass(id);
        if(exitClass != null){
            model.addAttribute("classroom", exitClass);
        }
        return "/user/detail_class";
    }






}
