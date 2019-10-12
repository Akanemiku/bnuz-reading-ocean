package com.bnuz.ocean.service;

import com.bnuz.ocean.entity.Question;
import com.bnuz.ocean.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface QuestionService {

    public Page<Question> findAll(Pageable pageable);

}
