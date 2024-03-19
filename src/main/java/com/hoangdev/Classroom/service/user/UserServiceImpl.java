package com.hoangdev.Classroom.service.user;

import com.hoangdev.Classroom.models.Role;
import com.hoangdev.Classroom.models.User;
import com.hoangdev.Classroom.repository.RoleRepository;
import com.hoangdev.Classroom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveUserWithDefaultRole(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        user.setStatus(true);
        Role roleStudent = roleRepository.findByRoleName("ROLE_STUDENT");
        user.addRole(roleStudent);
        userRepository.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
