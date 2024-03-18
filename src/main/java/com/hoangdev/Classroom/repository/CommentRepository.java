package com.hoangdev.Classroom.repository;


import com.hoangdev.Classroom.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
