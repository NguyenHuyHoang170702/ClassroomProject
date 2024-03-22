package com.hoangdev.Classroom.service.homework;

import com.hoangdev.Classroom.models.Classroom;
import com.hoangdev.Classroom.models.Homework;

import java.util.List;
import java.util.Optional;

public interface HomeworkService {
    List<Homework> findHomeworkByClassId(int classId);
    Optional<Homework> findHomeworkById(int id);
    void saveHomework(Homework homework);

    List<Homework> getByClassIdAndUsername(int classId, String username);

    List<Homework> getByTeacher(int classId);
}
