package com.bnuz.ocean.service;

import com.bnuz.ocean.VO.StudentVO;
import com.bnuz.ocean.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    /**
     * 通过任务id查找完成此任务的学生
     * @param missionId
     * @return
     */
    List<Student> findAllByMissionIdWhenFinishTask(String missionId);

    /**
     * 通过任务id查找完成此任务并且还未被评价的学生
     * @param missionId
     * @return
     */
    List<Student> findAllByMissionIdWhenFinishTaskAndNotAssess(String missionId);

    /**
     * 通过任务id查找未完成此任务的学生
     * @param missionId
     * @return
     */
    List<Student> findAllByMissionIdWhenNotFinishTask(String missionId);

    /**
     * 通过任务id查找此任务的所有学生
     * @param missionId
     * @return
     */
    List<Student> findAllStudentsByMissionId(String missionId);

    /**
     * 通过任务id查找已经被评价的学生
     * @param missionId
     * @return
     */
    List<Student> findAllByMissionIdWhenIsAssessed(String missionId);

    /**
     * 通过任务id查找studentVO
     * @param missionId
     * @return
     */
    List<StudentVO> findAllStudentVOSByMissionId(String missionId);

    /**
     * 通过任务id查找已经被评价的studentVO
     * @param missionId
     * @return
     */
    List<StudentVO> findAllStudentVOSByMissionIdWhenIsAssessed(String missionId);

    /**
     * 通过任务id查找完成此任务的studentVO
     * @param missionId
     * @return
     */
    List<StudentVO> findAllStudentVOSByMissionIdWhenFinishTask(String missionId);

    /**
     * 通过任务id查找未完成此任务的studentVO
     * @param missionId
     * @return
     */
    List<StudentVO> findAllStudentVOSByMissionIdWhenNotFinishTask(String missionId);

    /**
     * 通过任务id查找完成此任务的但是还没有被评价的studentVO
     * @param missionId
     * @return
     */
    List<StudentVO> findAllStudentVOSByMissionIdWhenFinishTaskAndNotAssess(String missionId);
}
