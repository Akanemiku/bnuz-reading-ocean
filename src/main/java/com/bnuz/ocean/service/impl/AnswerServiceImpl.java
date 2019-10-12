package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.Answer;
import com.bnuz.ocean.repository.AnswerRepository;
import com.bnuz.ocean.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<Answer> findAllByQuestionId(Integer questionId) {
        return answerRepository.findAllByQuestionId(questionId);
    }

    @Override
    @Transactional
    public int insertAnswer(Integer questionId, String answerAns, Date date, Integer teacherId) {
        return answerRepository.insertAnswer(questionId, answerAns, date, teacherId);
    }
}
