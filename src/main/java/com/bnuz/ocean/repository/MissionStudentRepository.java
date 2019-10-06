package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.MissionStudent;
import com.bnuz.ocean.entity.id.MissionStudentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MissionStudentRepository extends JpaRepository<MissionStudent, MissionStudentId> {
    @Modifying
    @Query(nativeQuery = true, value = "insert into r_mission_student(mission_id, student_id) VALUES (?1,?2)")
    void insert(Integer missionId, Integer studentId);

    @Query(nativeQuery = true, value = "select * from r_mission_student where mission_id=?1")
    List<MissionStudent> findAll(Integer missionId);

    @Modifying
    @Query(nativeQuery = true, value = "delete from r_mission_student where mission_id = ?1")
    void deleteByMissionId(Integer missionId);

    @Query(nativeQuery = true, value = "select student_id from r_mission_student where mission_id=?1")
    List<Integer> findAllStudentIdByMissionId(Integer missionId);
}
