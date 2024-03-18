package com.hoangdev.Classroom.repository;

import com.hoangdev.Classroom.models.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkRepository extends JpaRepository<Homework, Integer> {
}
