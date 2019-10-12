package com.bnuz.ocean.service;

import com.bnuz.ocean.entity.Answer;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface AnswerService {

    List<Answer> findAllByQuestionId(Integer questionId);

    int insertAnswer(Integer questionId, String answerAns, Date date, Integer teacherId);

}
