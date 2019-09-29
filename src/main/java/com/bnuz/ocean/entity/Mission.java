package com.bnuz.ocean.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_mission_info")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer missionId;

    private String teacherNo;

    private String missionTitle;

    private Integer missionCate;

    private String missionDesc;

    private Date beginTime;

    private Date endTime;
}
