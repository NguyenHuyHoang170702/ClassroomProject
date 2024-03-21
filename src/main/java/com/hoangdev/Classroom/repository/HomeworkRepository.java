package com.hoangdev.Classroom.repository;

import com.hoangdev.Classroom.models.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Integer> {

    @Query("select distinct homework from Homework homework where homework.classroom.id =:classId")
    public List<Homework> findByClassroomId(@Param("classId") int classId);
}
