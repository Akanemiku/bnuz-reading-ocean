package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework,Integer> {

    List<Homework> findAllByStudentIdAndMissionId(@Param("studentId") Integer studentId, @Param("missionId") Integer missionId);

}
