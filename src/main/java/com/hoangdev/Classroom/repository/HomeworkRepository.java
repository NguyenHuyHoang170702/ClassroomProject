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

    @Query("select distinct homework from Homework homework join  homework.classroom classroom join homework.users user where classroom.id=:classroomId and user.username =:username")
    public List<Homework> getHomeworkByClassroomIdAndUserName(@Param("classroomId") int classroomId
            ,@Param("username") String username);

    @Query("select distinct homework from Homework homework join homework.classroom classroom join homework.users user join user.roles role where role.roleName ='ROLE_TEACHER' and classroom.id =:classroomId")
    public List<Homework> getHomeworkByTeacher(@Param("classroomId") int classroomId);
}
