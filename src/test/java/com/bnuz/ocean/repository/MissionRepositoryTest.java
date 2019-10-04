package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Mission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionRepositoryTest {
    @Autowired
    private MissionRepository repository;
    @Test
    public void findAllByMissionId(){
        Mission mission = repository.findAllByMissionId(11);
        System.out.println(mission.toString());
    }

}