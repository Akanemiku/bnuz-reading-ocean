package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.Homework;
import com.bnuz.ocean.repository.HomeworkRepository;
import com.bnuz.ocean.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Override
    public List<Homework> findAllByStudentIdAndMissionId(Integer studentId, Integer missionId) {
        return homeworkRepository.findAllByStudentIdAndMissionId(studentId,missionId);
    }
}
