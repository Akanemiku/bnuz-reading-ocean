package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.VO.StudentVO;
import com.bnuz.ocean.entity.Student;
import com.bnuz.ocean.repository.StudentRepository;
import com.bnuz.ocean.service.StudentService;
import com.bnuz.ocean.utils.ConverterUtil;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllByMissionIdWhenFinishTask(String missionId) {
        return studentRepository.findAllByMissionIdWhenFinishedTask(missionId);
    }

    @Override
    public List<Student> findAllByMissionIdWhenFinishTaskAndNotAssess(String missionId) {
        List<Student> studentList = studentRepository.findAllByMissionIdWhenFinishedTaskAndAssess(missionId);
        List<Student> studentList1 = studentRepository.findAllByMissionIdWhenFinishedTask(missionId);
        List<Student> studentList2 = ListUtils.subtract(studentList1, studentList);
        return studentList2;
    }

    @Override
    public List<Student> findAllByMissionIdWhenNotFinishTask(String missionId) {
        return studentRepository.findAllByMissionIdWhenNotFinishedTask(missionId);
    }

    @Override
    public List<Student> findAllStudentsByMissionId(String missionId) {
        return studentRepository.findAllByMissionId(missionId);
    }

    @Override
    public List<Student> findAllByMissionIdWhenIsAssessed(String missionId) {
        return studentRepository.findAllByMissionIdWhenIsAssessed(missionId);
    }

    @Override
    public List<StudentVO> findAllStudentVOSByMissionId(String missionId) {
        List<Student> studentList = findAllStudentsByMissionId(missionId);
        List<StudentVO> studentVOList = ConverterUtil.convertStudentToStudentVO(studentList);
        return studentVOList;
    }

    @Override
    public List<StudentVO> findAllStudentVOSByMissionIdWhenIsAssessed(String missionId) {
        List<Student> studentList = findAllByMissionIdWhenIsAssessed(missionId);
        List<StudentVO> studentVOList = ConverterUtil.convertStudentToStudentVO(studentList);
        return studentVOList;
    }

    @Override
    public List<StudentVO> findAllStudentVOSByMissionIdWhenFinishTask(String missionId) {
        List<Student> studentList = findAllByMissionIdWhenFinishTask(missionId);
        List<StudentVO> studentVOList = ConverterUtil.convertStudentToStudentVO(studentList);
        return studentVOList;
    }

    @Override
    public List<StudentVO> findAllStudentVOSByMissionIdWhenNotFinishTask(String missionId) {
        List<Student> studentList = findAllByMissionIdWhenNotFinishTask(missionId);
        List<StudentVO> studentVOList = ConverterUtil.convertStudentToStudentVO(studentList);
        return studentVOList;
    }

    @Override
    public List<StudentVO> findAllStudentVOSByMissionIdWhenFinishTaskAndNotAssess(String missionId) {
        List<Student> studentList = findAllByMissionIdWhenFinishTaskAndNotAssess(missionId);
        List<StudentVO> studentVOList = ConverterUtil.convertStudentToStudentVO(studentList);
        return studentVOList;
    }

}
