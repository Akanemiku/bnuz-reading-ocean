package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Answer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Action;
import java.util.List;

import static org.junit.Assert.*;

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
        assertEquals(6, answerList.size());
    }

    @Test
    public void insertAnswer() {
    }

    @Test
    public void findTeacherIdByAnswerId() {
    }

    @Test
    public void deleteByAnswerId() {
    }
}