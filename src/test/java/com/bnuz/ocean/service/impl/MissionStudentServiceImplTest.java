package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.MissionStudent;
import com.bnuz.ocean.entity.id.MissionStudentId;
import com.bnuz.ocean.service.MissionStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionStudentServiceImplTest {
    @Autowired
    private MissionStudentService missionStudentService;


    @Test
    public void insert() {
//        missionStudentService.insert(20, 6);
    }

    @Test
    public void save() {
//        missionStudentService.save(new MissionStudent(new MissionStudentId(20, 6)));
    }

    @Test
    public void deleteByMissionId() {
//        missionStudentService.deleteByMissionId(20);
    }


    @Test
    public void findAll() {
        List<MissionStudent> missionStudentList = missionStudentService.findAll(19);
        assertNotEquals(0, missionStudentList.size());
    }

    @Test
    public void findAllStudentIdByMissionId() {
        List<Integer> missionStudentList = missionStudentService.findAllStudentIdByMissionId(19);
        assertNotEquals(0, missionStudentList.size());
    }
}