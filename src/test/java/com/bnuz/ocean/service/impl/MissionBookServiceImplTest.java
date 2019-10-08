package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.MissionBook;
import com.bnuz.ocean.entity.id.MissionBookId;
import com.bnuz.ocean.service.MissionBookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionBookServiceImplTest {

    @Autowired
    private MissionBookService missionBookService;

    @Test
    public void insert() {
//        missionBookService.insert(20, 6);
    }

    @Test
    public void save() {
//        missionBookService.save(new MissionBook(new MissionBookId(20, 6)));
    }

    @Test
    public void findAll() {
        List<MissionBook> missionBookList = missionBookService.findAll(19);
        assertNotEquals(0, missionBookList.size());
    }


    @Test
    public void deleteByMissionId() {
//        missionBookService.deleteByMissionId(20);
    }

    @Test
    public void findAllBookIdByMissionId() {
        List<Integer> missionBookList = missionBookService.findAllBookIdByMissionId(19);
        assertNotEquals(0, missionBookList.size());
    }
}