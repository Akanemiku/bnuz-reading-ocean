package com.bnuz.ocean.service;

import com.bnuz.ocean.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {

    Page<Question> findQuestionList(Pageable pageable);

}
