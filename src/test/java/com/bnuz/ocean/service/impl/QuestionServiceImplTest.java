package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.Question;
import com.bnuz.ocean.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceImplTest {
    @Autowired
    private QuestionService questionService;


    @Test
    public void findAll() {
        Sort sort =  new Sort(Sort.Direction.DESC, "createTime");   // 排序方式，这里是以“questionId”为标准进行降序
        Pageable pageable = new PageRequest(0, 2, sort);    // （当前页， 每页记录数， 排序方式）
        Page<Question> questionList = questionService.findAll(pageable);
        for (Question q : questionList) {
            System.out.println(q);
        }
    }
}