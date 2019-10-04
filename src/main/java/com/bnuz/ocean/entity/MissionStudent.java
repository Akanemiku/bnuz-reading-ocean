package com.bnuz.ocean.entity;

import com.bnuz.ocean.entity.id.MissionStudentId;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "r_mission_student")
public class MissionStudent {
    @EmbeddedId
    private MissionStudentId missionStudentId;

    private Integer complete = 0;

    public MissionStudent(MissionStudentId missionStudentId) {
        this.missionStudentId = missionStudentId;
    }

    public MissionStudent(){}
}
