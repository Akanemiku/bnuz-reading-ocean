package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.Mission;
import com.bnuz.ocean.repository.*;
import com.bnuz.ocean.service.MissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImplTest {
    @Autowired
    private MissionService missionService;

    @Test
    public void findList() {
        Page<Mission> thisPage = missionService.findList("233", new PageRequest(1, 5));
        assertNotNull(thisPage);
    }

    @Test
    public void save() {
//        Mission mission = missionService.save(new Mission());
//        assertNotNull(mission);
    }

    @Test
    public void findAllByMissionId() {
        Mission mission = missionService.findAllByMissionId(19);
        assertNotNull(mission);
    }


    @Test
    public void deleteByMissionId() {
//        missionService.deleteByMissionId(19);
    }

    @Test
    public void fetchStudents() {
//        List<String> fetchStudents = missionService.fetchStudents(19);
//        assertNull(fetchStudents);
    }

    @Test
    public void fetchBooks() {
//        List<String> bookNameList = missionService.fetchBooks(17);
//        assertNotNull(bookNameList);
    }
}