package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.AssessInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessInfoRepository extends JpaRepository<AssessInfo,Integer> {

    List<AssessInfo> getAssessInfosByType(String type);
}
