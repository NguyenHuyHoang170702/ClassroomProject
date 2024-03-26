package com.hoangdev.Classroom.service.comment;

import com.hoangdev.Classroom.models.Comment;
import com.hoangdev.Classroom.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getByNewsId(Long id) {
        return commentRepository.findByNewsId(id);
    }

    @Override
    public Page<Comment> findByNewsPaginated(Long newsId, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return commentRepository.findByNewsIdPagination(newsId,pageable);
    }
}
