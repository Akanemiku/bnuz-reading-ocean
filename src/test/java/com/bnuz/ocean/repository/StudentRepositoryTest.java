package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void findAllByMissionIdWhenFinishedTask() {
        List<Student> students = studentRepository.findAllByMissionIdWhenFinishedTask("19");
        System.out.println(students);
    }

    @Test
    public void findAllByMissionIdWhenNotFinishedTask() {
        List<Student> students = studentRepository.findAllByMissionIdWhenNotFinishedTask("19");
        System.out.println(students);
    }

    @Test
    public void findAllByMissionIdWhenIsAssessed() {
        List<Student> students = studentRepository.findAllByMissionIdWhenIsAssessed("c2256792-32f1-4333-9001-2ae6ffbc248b");
        System.out.println(students);
    }

    @Test
    public void findAllByMissionId() {
        List<Student> students = studentRepository.findAllByMissionId("19");
        System.out.println(students);
    }

}