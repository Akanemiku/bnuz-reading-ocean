package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.VO.AssessStudentVO;
import com.bnuz.ocean.entity.Evaluate;
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
        assertNotNull(assessStudentVOS);
    }

    @Test
    public void findAllByMissionId() {
        List<Evaluate> evaluateList = evaluateService.findAllByMissionId("19");
        assertNotNull(evaluateList);
    }

    @Test
    public void save() {
    }

    @Test
    public void convertToEvaluateList() {
    }
}