package com.hoangdev.Classroom.repository;

import com.hoangdev.Classroom.models.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    @Query("select distinct news from News news join news.classroom classroom where classroom.id =:classId")
    List<News> findNewsByClassroomId(@Param("classId") int classId);
    @Query("SELECT news FROM News news WHERE news.id = ?1")
    List<News> findByNewsId(@Param("newsId") Long newsId);

    @Query("SELECT DISTINCT news FROM News news JOIN news.users user  WHERE user.username = :userName")
    List<News> findByUserName(@Param("userName") String userName);

    @Query("SELECT news FROM News news JOIN news.classroom classroom WHERE classroom.id = news.classroom.id AND classroom.id = :classroomId")
    List<News> findByClassId(@Param("classroomId") Long classroomId);
    @Query("SELECT DISTINCT news FROM News news JOIN news.classroom classroom  WHERE classroom.id = :classroomId")
    Page<News> findByClassroomIdPagination(@Param("classroomId") int classroomId, Pageable pageable);
}
