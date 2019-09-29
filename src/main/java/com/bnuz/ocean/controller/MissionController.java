package com.bnuz.ocean.controller;

import com.bnuz.ocean.VO.MissionVO;
import com.bnuz.ocean.VO.ResultVO;
import com.bnuz.ocean.service.MissionService;
import com.bnuz.ocean.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mission")
public class MissionController {

    @Autowired
    private MissionService missionService;

    @GetMapping("/list")
    public ResultVO list(@RequestParam("teacherNo") String teacherNo,
                         @PageableDefault(size = 2) Pageable pageable, Model model) {

        Page<MissionVO> missionVOPage = missionService.findList(teacherNo,pageable);
        return ResultVOUtil.success(missionVOPage.getContent());
    }
}
