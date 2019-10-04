package com.bnuz.ocean.service;

import com.bnuz.ocean.VO.MissionVO;
import com.bnuz.ocean.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MissionService {
    Page<Mission> findList(String teacherNo, Pageable pageable);

    Mission save(Mission mission);

    Mission findAllByMissionId(Integer missionId);

    void deleteByMissionId(Integer missionId);
}
