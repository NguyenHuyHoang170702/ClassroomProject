package com.hoangdev.Classroom.repository;

import com.hoangdev.Classroom.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer> {
}
