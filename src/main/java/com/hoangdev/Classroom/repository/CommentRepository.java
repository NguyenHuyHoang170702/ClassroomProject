package com.hoangdev.Classroom.repository;


import com.hoangdev.Classroom.models.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT comment FROM Comment comment WHERE comment.id = ?1")
    Optional<Comment> findByCommentId(Long id);
    @Query("SELECT comment FROM Comment comment JOIN comment.news news WHERE news.id = comment.news.id AND news.id = :newsId")
    List<Comment> findByNewsId(@Param("newsId") Long newsId);
    @Query("SELECT DISTINCT comment FROM Comment comment JOIN comment.news news  WHERE news.id = :newsId")
    Page<Comment> findByNewsIdPagination(@Param("newsId") Long newsId, Pageable pageable);

}
