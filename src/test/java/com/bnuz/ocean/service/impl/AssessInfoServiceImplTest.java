package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.AssessInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssessInfoServiceImplTest {

    @Autowired
    private AssessInfoServiceImpl assessInfoServiceImpl;

    @Test
    public void getAssessInfo() {
        List<AssessInfo> assessInfoList = assessInfoServiceImpl.getAssessInfo("teacher_add_type");
        assertNotNull(assessInfoList);
    }
}