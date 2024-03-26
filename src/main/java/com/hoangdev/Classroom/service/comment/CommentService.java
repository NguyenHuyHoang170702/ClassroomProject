package com.hoangdev.Classroom.service.comment;

import com.hoangdev.Classroom.models.Comment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    List<Comment> getByNewsId(Long id);
    Page<Comment> findByNewsPaginated(Long newsId, int pageId, int pageSize);
}
