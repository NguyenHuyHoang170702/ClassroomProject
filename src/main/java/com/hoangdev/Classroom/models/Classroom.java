package com.hoangdev.Classroom.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameClass;

    private String descriptionClass;

    private String codeClass;

    @ManyToMany(mappedBy = "classrooms")
    private Set<User> users;

    @OneToMany(mappedBy = "classroom")
    private Set<Homework> homeworks;

    @OneToMany(mappedBy = "classroom")
    private Set<News> news;


}
