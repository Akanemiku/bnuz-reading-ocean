package com.bnuz.ocean.controller;

import com.bnuz.ocean.entity.ExcelInfo;
import com.bnuz.ocean.service.ExcelInfoService;
import com.bnuz.ocean.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private ExcelInfoService excelInfoService;

    @GetMapping("/export/{missionId}")
    public void exportLecture(HttpServletResponse response, @PathVariable("missionId") String missionId){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateTime = dateFormat.format(date);
        List<ExcelInfo> excelInfoList = excelInfoService.getExcelInfo(missionId);
        ExcelUtil.exportExcel(excelInfoList, "老师积分统计表" ,"老师积分统计表", ExcelInfo.class, "任务详情表"+dateTime+".xls", response);
    }
}
