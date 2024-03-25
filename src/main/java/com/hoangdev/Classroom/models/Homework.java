package com.hoangdev.Classroom.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
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

    @ManyToMany()
    @JoinTable(name = "homework_user",
            joinColumns = @JoinColumn(name = "homework_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<User> users = new HashSet<>();

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

    public void addUser(User user){
        this.users.add(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return Objects.equals(id, homework.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Homework{" +
                "classroom=" + classroom +
                ", parentHomework=" + parentHomework +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", score=" + score +
                ", homeworkCode='" + homeworkCode + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
