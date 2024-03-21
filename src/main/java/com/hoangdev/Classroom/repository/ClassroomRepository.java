package com.hoangdev.Classroom.repository;



import com.hoangdev.Classroom.models.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

    @Query("SELECT DISTINCT classroom FROM Classroom classroom JOIN classroom.users user  WHERE user.username = :userName")
    List<Classroom> findByUserName(@Param("userName") String userName);

    @Query("SELECT DISTINCT classroom FROM Classroom classroom JOIN classroom.users user  WHERE user.username = :userName")
    Page<Classroom> findByUserNamePaginate(@Param("userName") String userName, Pageable pageable);
}
