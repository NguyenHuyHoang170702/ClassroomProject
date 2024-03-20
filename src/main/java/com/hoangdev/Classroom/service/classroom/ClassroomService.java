package com.hoangdev.Classroom.service.classroom;

import com.hoangdev.Classroom.models.Classroom;

import java.util.List;

public interface ClassroomService {
    List<Classroom> getClassByUsername(String username);
}
