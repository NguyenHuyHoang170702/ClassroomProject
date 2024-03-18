package com.hoangdev.Classroom.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "homeworks")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    private Classroom classroom;

    @ManyToMany(mappedBy = "homeworks")
    private Set<User> users;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private Homework parentHomework;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "parentHomework")
    @Getter
    @Setter
    private Set<Homework> homeworkSet = new HashSet<>();

    private String name;

    private String description;

    private Long size;

    private Integer score;

    private String homeworkCode;

    @Lob
    private byte [] content;

}
