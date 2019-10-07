package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.Student;
import com.bnuz.ocean.repository.StudentRepository;
import com.bnuz.ocean.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public String findStudentNameByStudentId(Integer studentId){
        return studentRepository.findStudentNameByStudentId(studentId);
    }
}
