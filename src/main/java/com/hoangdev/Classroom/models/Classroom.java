package com.hoangdev.Classroom.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
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

    @Column(unique = true)
    private String codeClass;

    @ManyToMany(mappedBy = "classrooms")
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "classroom")
    private Set<Homework> homeworks = new HashSet<>();

    @OneToMany(mappedBy = "classroom")
    private Set<News> news = new HashSet<>();

    public void deleteNews(News news){
        this.news.remove(news);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom aClassroom = (Classroom) o;
        return id == aClassroom.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "nameClass='" + nameClass + '\'' +
                ", descriptionClass='" + descriptionClass + '\'' +
                ", codeClass='" + codeClass + '\'' +
                '}';
    }
}
