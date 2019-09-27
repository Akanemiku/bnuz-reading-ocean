package com.bnuz.ocean.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "t_mission_info")
public class Mission {
    private Integer missionId;

    private String missionTitle;

    private Integer missionCate;

    private String missionDesc;

    private Date beginTime;

    private Date endTime;
}
