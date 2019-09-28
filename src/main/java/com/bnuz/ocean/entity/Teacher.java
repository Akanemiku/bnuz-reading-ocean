package com.bnuz.ocean.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_teacher_info")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    private String teacherName;

    private String teacherPassword;

    private String teacherSchool;

    private String teacherEmail;


}
