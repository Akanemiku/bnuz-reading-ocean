package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.MissionStudent;
import com.bnuz.ocean.repository.MissionStudentRepository;
import com.bnuz.ocean.service.MissionStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MissionStudentServiceImpl implements MissionStudentService {
    @Autowired
    private MissionStudentRepository missionStudentRepository;

    @Override
    @Transactional
    public void insert(Integer missionId, Integer studentId) {
        missionStudentRepository.insert(missionId,studentId);
    }

    @Override
    @Transactional
    public void save(MissionStudent missionStudent) {
        missionStudentRepository.save(missionStudent);
    }

    @Override
    @Transactional
    public void deleteByMissionId(Integer missionId) {
        missionStudentRepository.deleteByMissionId(missionId);
    }

    @Override
    public List<MissionStudent> findAll(Integer missionId) {
        return missionStudentRepository.findAll(missionId);
    }
}
