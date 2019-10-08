package com.bnuz.ocean.service;

import com.bnuz.ocean.entity.ExcelInfo;

import java.util.List;

public interface ExcelInfoService {

    /**
     * 通过missionId获取excelInfo
     * @param missionId
     * @return
     */
    List<ExcelInfo> getExcelInfo(String missionId);
}
