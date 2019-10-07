package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.VO.StudentVO;
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
    private StudentServiceImpl service;

    @Test
    public void findAllStudentVOSByMissionId() {
        List<StudentVO> studentVOList = service.findAllStudentVOSByMissionId("19");
        System.out.println(studentVOList);
    }

    @Test
    public void findAllStudentVOSByMissionIdWhenFinishTaskAndNotAssess(){
        List<StudentVO> studentVOList = service.findAllStudentVOSByMissionIdWhenFinishTaskAndNotAssess("19");
        System.out.println(studentVOList);
    }
}