package com.hoangdev.Classroom.dto;

import com.hoangdev.Classroom.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
public class CommentDto implements Serializable {
    public Long id;
    public String content;
    public Date timestamp;
    public Set<User> teachers;
    public Set<User> students;
    public int qualityComment;
}
