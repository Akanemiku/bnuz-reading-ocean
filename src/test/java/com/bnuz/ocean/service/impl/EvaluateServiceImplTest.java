package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.DTO.EvaluateDTO;
import com.bnuz.ocean.VO.AssessStudentVO;
import com.bnuz.ocean.entity.Evaluate;
import com.bnuz.ocean.service.EvaluateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EvaluateServiceImplTest {

    @Autowired
    private EvaluateService evaluateService;

    @Test
    public void findAllAssessStudentsByMissionId() {
        List<AssessStudentVO> assessStudentVOS = evaluateService.findAllAssessStudentsByMissionId("25");
        assertNotNull(assessStudentVOS);
    }

    @Test
    public void findAllAssessStudentsByMissionId2() {
        List<AssessStudentVO> assessStudentVOS = evaluateService.findAllAssessStudentsByMissionId("16");
        assertNotNull(assessStudentVOS);
    }

    @Test
    public void findAllByMissionId() {
        List<Evaluate> evaluateList = evaluateService.findAllByMissionId("25");
        assertNotNull(evaluateList);
    }

    @Test
    @Transactional
    public void save() {
        evaluateService.save(new EvaluateDTO("16","继续加油",10,"良","1"));
    }

    @Test
    public void convertToEvaluateList() {
        List<Evaluate> evaluateList = evaluateService.ConvertToEvaluateList(new EvaluateDTO("16", "继续加油", 10, "良", "1"));
        assertNotNull(evaluateList);
    }
}