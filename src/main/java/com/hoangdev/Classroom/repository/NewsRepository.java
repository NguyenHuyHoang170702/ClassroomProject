package com.hoangdev.Classroom.repository;

import com.hoangdev.Classroom.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    @Query("select distinct news from News news join news.classroom classroom where classroom.id =:classId")
    List<News> findNewsByClassroomId(@Param("classId") int classId);
}
