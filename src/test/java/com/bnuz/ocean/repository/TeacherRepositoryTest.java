package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository repository;

    @Test
    public void findAllByTeacherName(){
        Teacher teacher = repository.findAllByTeacherName("程努华");
        System.out.println(teacher.toString());
    }

}