package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.StudentMission;
import com.bnuz.ocean.entity.id.StudentMissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluateRepository extends JpaRepository<StudentMission,StudentMissionId> {
}
