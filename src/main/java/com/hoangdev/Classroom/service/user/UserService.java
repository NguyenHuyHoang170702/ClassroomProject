package com.hoangdev.Classroom.service.user;

import com.hoangdev.Classroom.models.User;

public interface UserService {
    void saveUserWithDefaultRole(User user);
    User findByUserName(String username);
}
