package com.hoangdev.Classroom.dto;

import com.hoangdev.Classroom.models.User;
import lombok.*;

import java.io.Serializable;
import java.util.Set;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomDto implements Serializable {
    public int id;
    public String nameClass;
    public String decriptionClass;
    public String codeClass;
    public Set<User> teachers;
    public Set<User> students;
    public int quantityStudent;


}
