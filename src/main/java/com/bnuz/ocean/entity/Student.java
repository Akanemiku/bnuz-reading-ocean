package com.bnuz.ocean.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_student_info")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String studentNo;

    private String studentInfo;

    private String studentScore;
}
