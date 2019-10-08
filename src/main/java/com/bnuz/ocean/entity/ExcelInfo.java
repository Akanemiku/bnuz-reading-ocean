package com.bnuz.ocean.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

@Data
public class ExcelInfo {

    @Excel(name = "任务名",needMerge = true)
    private String missionName;

    @Excel(name = "任务描述",needMerge = true)
    private String missionDesc;

    @Excel(name = "开始时间",needMerge = true)
    private Date beginTime;

    @Excel(name = "结束时间",needMerge = true)
    private Date endTime;

    @Excel(name = "是否完成")
    private String isCompleted;

    @Excel(name = "学生姓名")
    private String studentName;

}
