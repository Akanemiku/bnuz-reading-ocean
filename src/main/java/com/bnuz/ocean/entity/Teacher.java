package com.bnuz.ocean.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_teacher_info")
public class Teacher implements Serializable {
    private static final long serialVersionUID = 5239542437156771292L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    private String teacherName;

    private String teacherPassword;

    private String teacherSchool;

    private String teacherEmail;


}
