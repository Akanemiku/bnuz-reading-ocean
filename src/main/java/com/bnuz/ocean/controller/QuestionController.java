package com.bnuz.ocean.controller;

import com.bnuz.ocean.VO.ResultVO;
import com.bnuz.ocean.entity.Question;
import com.bnuz.ocean.enums.ResultEnum;
import com.bnuz.ocean.exception.OceanException;
import com.bnuz.ocean.service.QuestionService;
import com.bnuz.ocean.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/list")
    public ResultVO listQuestion(@PageableDefault(size = 2)Pageable pageable){
        Page<Question> questionPage = null;
        try{
            questionPage = questionService.findQuestionList(pageable);
        }catch (OceanException e){
            return ResultVOUtil.error(ResultEnum.QUESTION_ERROR);
        }

        return ResultVOUtil.success(questionPage.getContent());
    }
}
