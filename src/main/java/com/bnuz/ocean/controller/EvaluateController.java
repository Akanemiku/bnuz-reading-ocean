package com.bnuz.ocean.controller;

import com.bnuz.ocean.DTO.EvaluateDTO;
import com.bnuz.ocean.VO.ResultVO;
import com.bnuz.ocean.entity.Evaluate;
import com.bnuz.ocean.enums.ResultEnum;
import com.bnuz.ocean.service.EvaluateService;
import com.bnuz.ocean.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/task")
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    @PostMapping("/assess")
    @ResponseBody
    public ResultVO assess(@RequestBody EvaluateDTO evaluateDTO){
        if (evaluateDTO!=null){
            evaluateService.save(evaluateDTO);
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.EVALUATE_INSERT_ERROR);
    }



}
