package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.service.MissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImplTest {
    @Autowired
    private MissionService missionService;

    @Test
    public void fetchBooks() {
        List<String> list = missionService.fetchBooks(17);
        System.out.println(list.toString());
    }
}