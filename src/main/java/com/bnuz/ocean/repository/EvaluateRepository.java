package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Evaluate;
import com.bnuz.ocean.entity.id.EvaluateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluateRepository extends JpaRepository<Evaluate, EvaluateId> {

    @Modifying
    @Query(nativeQuery = true,value = "insert into r_evaluate_student_mission(student_id, mission_id, evalue_desc, integral_score, assess) values (:#{#evaluate.evaluateId.studentId},:#{#evaluate.evaluateId.missionId},:#{#evaluate.assessPlus},:#{#evaluate.integral},:#{#evaluate.assess})")
    void insert(@Param("evaluate") Evaluate evaluate);
}
