package com.bnuz.ocean.converter;

import com.bnuz.ocean.VO.MissionVO;
import com.bnuz.ocean.entity.Mission;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Mission2MissionVOConverter {
    public static MissionVO convert(Mission mission) {
        MissionVO missionVO = new MissionVO();
        BeanUtils.copyProperties(mission, missionVO);
        return missionVO;
    }

    public static List<MissionVO> convert(List<Mission> missionList){
        return missionList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
