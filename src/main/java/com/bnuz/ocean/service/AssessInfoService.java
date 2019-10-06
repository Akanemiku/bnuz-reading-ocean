package com.bnuz.ocean.service;


import com.bnuz.ocean.entity.AssessInfo;

import java.util.List;

public interface AssessInfoService {

    /**
     * 通过类型获取评价信息
     * @param type
     * @return
     */
    public List<AssessInfo> getAssessInfo(String type);
}
