package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Evaluate;
import com.bnuz.ocean.entity.id.EvaluateId;
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
public class EvaluateRepositoryTest {

    @Autowired
    EvaluateRepository evaluateRepository;

    @Test
    public void findAllByMissionId() {
        List<Evaluate> evaluateList = evaluateRepository.findAllByMissionId("19");
        assertNotNull(evaluateList);
    }

    @Test
    @Transactional
    @Modifying
    public void insert() {
        evaluateRepository.insert(new Evaluate(new EvaluateId("1", "2"), "继续加油", 1, "优"));
    }
}