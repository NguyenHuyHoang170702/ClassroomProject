package com.hoangdev.Classroom.service.user;

import com.hoangdev.Classroom.models.Role;
import com.hoangdev.Classroom.models.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    void saveUserWithDefaultRole(User user);
    User findByUserName(String username);

    List<User> findAllUser();

    void save(User user);

    User findUserById(int id);

    List<Role> getRoles();

    User getCurrentAccount();

    Set<User> findByRoleAndClassroom(String roleName, int classId);

}
