package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Mission;
import com.bnuz.ocean.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission,Integer> {

    Page<Mission> findAllByTeacherNo(String teacherNo, Pageable pageable);

    Mission findAllByMissionId(Integer missionId);

//    @Query(nativeQuery = true,value = "delete from t_mission_info where mission_id=?1")
//    void delete(Integer missionId);

    void deleteByMissionId(Integer missionId);
}
