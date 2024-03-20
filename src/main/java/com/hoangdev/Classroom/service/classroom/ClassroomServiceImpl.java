package com.hoangdev.Classroom.service.classroom;

import com.hoangdev.Classroom.models.Classroom;
import com.hoangdev.Classroom.repository.ClassroomRepository;
import com.hoangdev.Classroom.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService{
    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<Classroom> getClassByUsername(String Username) {
        return classroomRepository.findByUserName(Username);
    }
}
