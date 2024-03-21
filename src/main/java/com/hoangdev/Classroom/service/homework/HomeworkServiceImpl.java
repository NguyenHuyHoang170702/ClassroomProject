package com.hoangdev.Classroom.service.homework;

import com.hoangdev.Classroom.models.Classroom;
import com.hoangdev.Classroom.models.Homework;
import com.hoangdev.Classroom.repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeworkServiceImpl implements HomeworkService{

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Override
    public List<Homework> findHomeworkByClassId(int classId) {
        return homeworkRepository.findByClassroomId(classId);
    }

    @Override
    public Optional<Homework> findHomeworkById(int id) {
        return homeworkRepository.findById(id);
    }

    @Override
    public void saveHomework(Homework homework) {
        homeworkRepository.save(homework);
    }
}
