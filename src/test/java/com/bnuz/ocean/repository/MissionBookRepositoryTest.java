package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.MissionBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionBookRepositoryTest {
    @Autowired
    private MissionBookRepository repository;

    @Test
    public void insert(){
//        repository.insert(1,2);
    }
    @Test
    public void findAll(){
        List<MissionBook> missionBookList = repository.findAll(16);
        assertNotEquals(0,missionBookList);
    }
    @Test
    public void deleteByMissionId(){
//        repository.deleteByMissionId(16);
    }
    @Test
    public void findAllBookIdByMissionId(){
        List<Integer> integerList = repository.findAllBookIdByMissionId(16);
    }

}