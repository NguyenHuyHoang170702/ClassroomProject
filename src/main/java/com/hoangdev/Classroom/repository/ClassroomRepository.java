package com.hoangdev.Classroom.repository;



import com.hoangdev.Classroom.models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}
