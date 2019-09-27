package com.bnuz.ocean.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_teacher_info")
public class Teacher {
    private Integer teacherId;

    private String teacherName;

    private String teacherPassword;

    private String teacherSchool;

    private String teacherEmail;


}
