package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Homework;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HomeworkRepositoryTest {

    @Autowired
    HomeworkRepository homeworkRepository;

    @Test
    public void findAllByStudentIdAndMissionId() {
        List<Homework> homeworkList = homeworkRepository.findAllByStudentIdAndMissionId(4, 25);
        assertNotNull(homeworkList);
    }
}