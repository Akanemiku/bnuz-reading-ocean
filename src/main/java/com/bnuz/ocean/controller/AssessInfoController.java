package com.bnuz.ocean.controller;

import com.bnuz.ocean.VO.ResultVO;
import com.bnuz.ocean.entity.AssessInfo;
import com.bnuz.ocean.enums.ResultEnum;
import com.bnuz.ocean.service.AssessInfoService;
import com.bnuz.ocean.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/assess")
public class AssessInfoController {

    @Autowired
    private AssessInfoService assessInfoService;

    @ResponseBody
    @GetMapping("/info")
    public ResultVO getAssessInfo(@RequestParam("type") String type){
        List<AssessInfo> assessInfo = assessInfoService.getAssessInfo(type);
        if (assessInfo!=null){
            return ResultVOUtil.success(assessInfoService.getAssessInfo(type));
        }
        return ResultVOUtil.error(ResultEnum.ASSESS_INFO_NULL_ERROR);
    }
}
