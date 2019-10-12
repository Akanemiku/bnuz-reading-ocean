package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.service.AnswerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerServiceImplTest {

    @Autowired
    private AnswerService answerService;

    @Test
    public void findAllByQuestionId() {
    }

    @Test
    public void insertAnswer() {
        Integer questionId = 4;
        String answerAns = "写的非常好，继续加油哦！";
        Date date = new Date();
        Integer teacherId = 1;
        int effectedNum = answerService.insertAnswer(questionId, answerAns, date, teacherId);
        assertEquals(1, effectedNum);
    }
}