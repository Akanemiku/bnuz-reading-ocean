package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.VO.AssessStudentVO;
import com.bnuz.ocean.service.EvaluateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EvaluateServiceImplTest {

    @Autowired
    private EvaluateService evaluateService;

    @Test
    public void findAllAssessStudentsByMissionId() {
        List<AssessStudentVO> assessStudentVOS = evaluateService.findAllAssessStudentsByMissionId("19");
        System.out.println(assessStudentVOS);
    }
}