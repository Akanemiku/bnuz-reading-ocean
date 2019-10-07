package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Evaluate;
import com.bnuz.ocean.entity.id.EvaluateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateRepository extends JpaRepository<Evaluate, EvaluateId> {

    @Modifying
    @Query(nativeQuery = true,value = "insert into r_evaluate_student_mission(student_id, mission_id, evaluate_desc, integral_score, assess) values (:#{#evaluate.evaluateId.studentId},:#{#evaluate.evaluateId.missionId},:#{#evaluate.assessPlus},:#{#evaluate.integral},:#{#evaluate.assess})")
    void insert(@Param("evaluate") Evaluate evaluate);

    @Query(nativeQuery = true,value = "select student_id,mission_id,evaluate_desc,integral_score,assess from r_evaluate_student_mission where mission_id=:missionId")
    List<Evaluate> findAllByMissionId(String missionId);
}
