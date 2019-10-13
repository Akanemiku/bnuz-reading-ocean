package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.Answer;
import com.bnuz.ocean.service.AnswerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerServiceImplTest {

    @Autowired
    private AnswerService answerService;

    @Test
    public void findAllByQuestionId() {
        List<Answer> answerList = answerService.findAllByQuestionId(6);
        for(Answer a: answerList){
            System.out.println(a);
        }
        assertEquals(6, answerList.size());
    }

    @Test
    public void insertAnswer() {
        Integer questionId = 6;
        String answerAns = "66666666";
        Date date = new Date();
        Integer teacherId = 1;
        int effectedNum = answerService.insertAnswer(questionId, answerAns, date, teacherId);
        assertEquals(1, effectedNum);
    }

    @Test
    public void findTeacherIdByAnswerId() {
        int teacherId = answerService.findTeacherIdByAnswerId(3);
        assertEquals(2, teacherId);
    }

    @Test
    public void deleteByAnswerId() {
        int effectedNum = answerService.deleteByAnswerId(28);
        assertEquals(1, effectedNum);
    }
}