package com.hoangdev.Classroom.repository;

import com.hoangdev.Classroom.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {
        @Query("select role from Role role where role.roleName =?1")
        Role findByRoleName(String name);
}
