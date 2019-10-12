package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Answer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerRepositoryTest {

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    public void findAllByQuestionId() {
        List<Answer> answerList = answerRepository.findAllByQuestionId(6);
        for(Answer a: answerList){
            System.out.println(a);
        }
        assertNotEquals(1, answerList.size());

    }

    @Test
    public void insertAnswer() {

    }
}