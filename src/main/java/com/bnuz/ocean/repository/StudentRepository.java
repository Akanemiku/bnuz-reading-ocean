package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(nativeQuery = true,value = "select * from t_student_info")
    List<Student> findAll();
}
