package com.bnuz.ocean.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_student_info")
public class Student {
    private Integer studentId;

    private String studentNo;

    private String studentName;

    private String studentSchool;

    private String studentGrade;

    private String studentClass;

    private String studentScore;
}
