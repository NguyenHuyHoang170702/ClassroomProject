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
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,name = "rolename")
    private String roleName;
    @Column(name = "description")
    private String roleDescription;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public void addUser(User user) {
        this.users.add(user);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
