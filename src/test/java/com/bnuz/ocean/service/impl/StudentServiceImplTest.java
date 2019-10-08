package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.VO.StudentVO;
import com.bnuz.ocean.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    private StudentServiceImpl studentService;

    @Test
    public void findAll() {
        List<Student> studentList = studentService.findAll();
        assertNotEquals(0, studentList.size());
    }

    @Test
    public void findAllByMissionIdWhenFinishTask() {
        List<Student> studentList = studentService.findAllByMissionIdWhenFinishTask("19");
        System.out.println(studentList.toString());
        assertNotEquals(0, studentList.size());
    }

    @Test
    public void findAllByMissionIdWhenFinishTaskAndNotAssess() {
        List<Student> studentList = studentService.findAllByMissionIdWhenFinishTaskAndNotAssess("19");
        assertNotEquals(0, studentList.size());
    }


    @Test
    public void findAllByMissionIdWhenNotFinishTask() {
        List<Student> studentList = studentService.findAllByMissionIdWhenNotFinishTask("19");
        assertNotNull(studentList);
    }

    @Test
    public void findAllStudentsByMissionId() {
        List<Student> studentList = studentService.findAllStudentsByMissionId("19");
        assertNotEquals(0, studentList.size());
    }

    @Test
    public void findAllByMissionIdWhenIsAssessed() {
        List<Student> studentList = studentService.findAllByMissionIdWhenIsAssessed("19");
        assertNotEquals(0, studentList.size());
    }


    @Test
    public void findAllStudentVOSByMissionId() {
        List<StudentVO> studentVOList = studentService.findAllStudentVOSByMissionId("19");
        assertNotEquals(0, studentVOList.size());
    }

    @Test
    public void findAllStudentVOSByMissionIdWhenIsAssessed() {
        List<StudentVO> studentVOList = studentService.findAllStudentVOSByMissionIdWhenIsAssessed("19");
        assertNotEquals(0, studentVOList.size());
    }

    @Test
    public void findAllStudentVOSByMissionIdWhenFinishTask() {
        List<StudentVO> studentVOList = studentService.findAllStudentVOSByMissionIdWhenFinishTask("19");
        assertNotEquals(0, studentVOList.size());
    }


    @Test
    public void findAllStudentVOSByMissionIdWhenNotFinishTask() {
        List<StudentVO> studentVOList = studentService.findAllStudentVOSByMissionIdWhenNotFinishTask("19");
        assertNotNull(studentVOList);
    }

    @Test
    public void findAllStudentVOSByMissionIdWhenFinishTaskAndNotAssess() {
        List<StudentVO> studentVOList = studentService.findAllStudentVOSByMissionIdWhenFinishTaskAndNotAssess("19");
        assertNotEquals(0, studentVOList.size());
    }

}