package com.bnuz.ocean.service;

import com.bnuz.ocean.entity.MissionStudent;

import java.util.List;

public interface MissionStudentService {
    void insert(Integer missionId, Integer studentId);

    void save(MissionStudent missionStudent);

    void deleteByMissionId(Integer missionId);

    List<MissionStudent> findAll(Integer missionId);
}
