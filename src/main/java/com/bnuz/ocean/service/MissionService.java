package com.bnuz.ocean.service;

import com.bnuz.ocean.VO.MissionVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MissionService {
    Page<MissionVO> findList(String teacherNo, Pageable pageable);
}
