package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.VO.MissionVO;
import com.bnuz.ocean.converter.Mission2MissionVOConverter;
import com.bnuz.ocean.entity.Mission;
import com.bnuz.ocean.repository.MissionRepository;
import com.bnuz.ocean.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionServiceImpl implements MissionService {

    @Autowired
    private MissionRepository missionRepository;

    @Override
    public Page<MissionVO> findList(String teacherNo, Pageable pageable) {
        Page<Mission> missionPage = missionRepository.findAllByTeacherNo(teacherNo, pageable);
        List<MissionVO> missionVOList = Mission2MissionVOConverter.convert(missionPage.getContent());
        Page<MissionVO> missionVOPage = new PageImpl<>(missionVOList, pageable, missionPage.getTotalElements());
        return missionVOPage;
    }
}
