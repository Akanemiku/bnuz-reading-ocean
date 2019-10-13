package com.bnuz.ocean.service;

import com.bnuz.ocean.entity.Homework;

import java.util.List;

public interface HomeworkService {

    /**
     * 通过学生id和任务id查找作业
     * @param studentId
     * @param missionId
     * @return
     */
    List<Homework> findAllByStudentIdAndMissionId(Integer studentId,Integer missionId);
}
