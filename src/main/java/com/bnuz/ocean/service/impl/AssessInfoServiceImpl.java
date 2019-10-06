package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.AssessInfo;
import com.bnuz.ocean.repository.AssessInfoRepository;
import com.bnuz.ocean.service.AssessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessInfoServiceImpl implements AssessInfoService {

    @Autowired
    private AssessInfoRepository assessInfoRepository;

    @Override
    public List<AssessInfo> getAssessInfo(String type) {
        return assessInfoRepository.getAssessInfosByType(type);
    }
}
