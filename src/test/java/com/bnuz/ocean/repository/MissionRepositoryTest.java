package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Mission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionRepositoryTest {

    @Autowired
    private MissionRepository repository;

    @Test
    public void findAllByMissionId() {
        Mission mission = repository.findAllByMissionId(20);
        assertNotNull(mission);
    }

    @Test
    public void findAllByTeacherNo(){
        Pageable pageable = new PageRequest(1,5);
        Page<Mission> missionPage = repository.findAllByTeacherNo("233",pageable);
        assertNotNull(missionPage);
    }

    @Test
    public void deleteByMissionId(){
        repository.deleteByMissionId(27);
    }




}