package com.bnuz.ocean.converter;

import com.bnuz.ocean.DTO.MissionDTO;
import com.bnuz.ocean.entity.Mission;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MissionDTO2Mission {
    public static Mission convert(MissionDTO missionDTO) throws ParseException {
        Mission mission = new Mission();
        mission.setMissionTitle(missionDTO.getTitle());
        mission.setTeacherNo(missionDTO.getTeacherNo());
        mission.setMissionCate(missionDTO.getCate());
        mission.setMissionDesc(missionDTO.getDesc());
        String time = missionDTO.getBeginTime()+" 00:00:00";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse(time);
        mission.setBeginTime(date);
        time = missionDTO.getEndTime()+" 23:59:59";
        date = df.parse(time);
        mission.setEndTime(date);
        return mission;
    }
}
