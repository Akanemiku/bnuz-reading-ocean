package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Evaluate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EvaluateRepositoryTest {

    @Autowired
    EvaluateRepository evaluateRepository;

    @Test
    public void findAllByMissionId() {
        List<Evaluate> evaluateList = evaluateRepository.findAllByMissionId("19");
        System.out.println(evaluateList);
    }
}