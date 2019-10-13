package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query(nativeQuery = true,value = "select * from t_student_info")
    List<Student> findAll();

    @Query(nativeQuery = true,value = "select t_student_info.student_id,t_student_info.student_no,t_student_info.student_info,t_student_info.student_score from t_student_info,r_mission_student where t_student_info.student_id=r_mission_student.student_id and mission_id=:missionId")
    List<Student> findAllByMissionId(@Param("missionId") String missionId);

    @Query(nativeQuery = true,value = "select t_student_info.student_id,t_student_info.student_no,t_student_info.student_info,t_student_info.student_score from t_student_info,r_mission_student where t_student_info.student_id=r_mission_student.student_id and complete=1 and mission_id=:missionId")
    List<Student> findAllByMissionIdWhenFinishedTask(@Param("missionId") String missionId);

    @Query(nativeQuery = true,value = "select t_student_info.student_id,t_student_info.student_no,t_student_info.student_info,t_student_info.student_score from t_student_info,r_mission_student where t_student_info.student_id=r_mission_student.student_id and complete=0 and mission_id=:missionId")
    List<Student> findAllByMissionIdWhenNotFinishedTask(@Param("missionId") String missionId);

    @Query(nativeQuery = true,value = "select t_student_info.student_id,t_student_info.student_no,t_student_info.student_info,t_student_info.student_score from t_student_info,r_evaluate_student_mission where t_student_info.student_id=r_evaluate_student_mission.student_id and mission_id=:missionId")
    List<Student> findAllByMissionIdWhenIsAssessed(@Param("missionId") String missionId);

    @Query(nativeQuery = true,value = "select t_student_info.student_id,t_student_info.student_no,t_student_info.student_info,t_student_info.student_score from t_student_info,r_mission_student,r_evaluate_student_mission where t_student_info.student_id=r_mission_student.student_id and complete=1 and r_mission_student.mission_id=:missionId and r_evaluate_student_mission.student_id=t_student_info.student_id")
    List<Student> findAllByMissionIdWhenFinishedTaskAndAssess(@Param("missionId") String missionId);

    Student findStudentByStudentId(@Param("studentId") Integer studentId);
}
