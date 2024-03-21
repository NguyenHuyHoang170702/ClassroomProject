package com.hoangdev.Classroom.service.user;

import com.hoangdev.Classroom.models.Role;
import com.hoangdev.Classroom.models.User;
import com.hoangdev.Classroom.repository.RoleRepository;
import com.hoangdev.Classroom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserServiceImpl implements UserService {

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

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        user.setStatus(true);
        userRepository.save(user);
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public User getCurrentAccount() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username);
    }

    @Override
    public Set<User> findByRoleAndClassroom(String roleName, int classId) {
        return userRepository.findByRolesAndClassrooms(roleName, classId);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
