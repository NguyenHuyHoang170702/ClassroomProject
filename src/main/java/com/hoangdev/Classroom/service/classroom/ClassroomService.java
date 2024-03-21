package com.hoangdev.Classroom.service.classroom;

import com.hoangdev.Classroom.models.Classroom;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ClassroomService {
    List<Classroom> getClassByUsername(String username);
    void saveClass(Classroom classroom);

    Page<Classroom> getClassByUsernamePaginate(String username, int pageNum, int pageSize);

    Classroom findClass(int id);

    Classroom findByCodeClassId(String keyword);
}
