package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void testfindAll(){
        List<Question>  questionList = questionRepository.findAll();
        System.out.println(questionList.toString());
    }

}