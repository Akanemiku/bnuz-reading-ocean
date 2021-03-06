package com.bnuz.ocean.repository;

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
public class AssessInfoRepositoryTest {

    @Autowired
    private AssessInfoRepository assessInfoRepository;

    @Test
    public void getAssessInfosByType() {
        List<AssessInfo> assessInfoList = assessInfoRepository.getAssessInfosByType("teacher_add_type");
        assertNotNull(assessInfoList);
    }
}