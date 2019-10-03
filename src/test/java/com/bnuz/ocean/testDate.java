package com.bnuz.ocean;

import com.bnuz.ocean.DTO.MissionDTO;
import com.bnuz.ocean.converter.MissionDTO2Mission;
import com.bnuz.ocean.entity.Mission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testDate {
    @Test
    public void test() throws ParseException {
        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setTitle("123");
        missionDTO.setTeacherNo("233");
        missionDTO.setCate(1);
        missionDTO.setDesc("123123");
        missionDTO.setBeginTime("1999-9-9");
        missionDTO.setEndTime("2019-9-9");
        Mission mission = MissionDTO2Mission.convert(missionDTO);
        System.out.println(mission.toString());
    }
}
