package com.hoangdev.Classroom.repository;

import com.hoangdev.Classroom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
