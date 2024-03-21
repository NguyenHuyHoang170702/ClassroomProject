package com.hoangdev.Classroom.service.classroom;

import com.hoangdev.Classroom.models.Classroom;
import com.hoangdev.Classroom.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService{
    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public List<Classroom> getClassByUsername(String Username) {
        return classroomRepository.findByUserName(Username);
    }

    @Override
    public void saveClass(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    @Override
    public Page<Classroom> getClassByUsernamePaginate(String Username, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1,pageSize);
        return classroomRepository.findByUserNamePaginate(Username, pageable);
    }

    @Override
    public Classroom findClass(int id) {
        return classroomRepository.findById(id).get();
    }

}
