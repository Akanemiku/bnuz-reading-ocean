package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.repository.MissionStudentRepository;
import com.bnuz.ocean.service.MissionStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MissionStudentServiceImpl implements MissionStudentService {
    @Autowired
    private MissionStudentRepository missionStudentRepository;

    @Override
    @Transactional
    public void insert(Integer missionId, Integer studentId) {
        missionStudentRepository.insert(missionId,studentId);
    }
}
