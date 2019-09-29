package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.Question;
import com.bnuz.ocean.repository.QuestionRepository;
import com.bnuz.ocean.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Page<Question> findQuestionList(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }
}
