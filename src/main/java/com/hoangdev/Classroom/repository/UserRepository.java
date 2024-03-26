package com.hoangdev.Classroom.repository;

import com.hoangdev.Classroom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT user from User user where user.email = ?1")
    User findByEmail(String email);

    @Query("SELECT user from User user where  user.username =?1")
    User findByUsername(String username);

    @Query("SELECT distinct user from User user join user.roles role where role.roleName =:role")
    Set<User> findByRole(@Param("role") String role);

    @Query("select distinct user from User user " +
            "join user.roles role join user.classrooms classroom where role.roleName =:role and classroom.id =:classroomId")
    Set<User> findByRolesAndClassrooms(@Param("role") String role, @Param("classroomId") int classroomId);

    @Query("select distinct user from User user " +
            "join user.roles role join user.news news where role.roleName =:role and news.id =:newsId")
    Set<User> findByRolesAndNews(@Param("role") String role, @Param("newsId") long newsId);

    @Query("SELECT DISTINCT user FROM User user JOIN user.roles role JOIN user.comments comment WHERE role.roleName = :role AND comment.id = :commentId")
    Set<User> findByRoleAndComment(@Param("role") String role, @Param("commentId") Long commentId);

    @Modifying
    @Query("UPDATE User user SET user.password =:password where user.username =:username")
    void updatePasswordByEmail(@Param("password") String password, @Param("username") String username);

     User findByResetPassToken(String token);
}
