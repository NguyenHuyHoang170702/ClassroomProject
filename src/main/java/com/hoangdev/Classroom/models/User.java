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

@Table(name = "users")
@Entity
public class User {
    @Id
    @Column(nullable = false)
    private String username;
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "status")
    private boolean status;

    // User vs Role
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles =new HashSet<>();

    //User vs Classroom
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_classroom",
            joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    )
    private Set<Classroom> classrooms;



    @ManyToMany()
    @JoinTable(name = "user_homework",
            joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(name = "homework_id", referencedColumnName = "id"))
    private Set<Homework> homeworks;

    @ManyToMany (mappedBy = "users")
    private Set<News> news;

    public void addClass(Classroom cls) {
        this.classrooms.add(cls);
    }

    public void removeClass(Classroom cls) {
        this.classrooms.remove(cls);
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }


}
