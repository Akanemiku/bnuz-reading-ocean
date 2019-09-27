package com.bnuz.ocean.entity;

import com.bnuz.ocean.entity.id.StudentMissionId;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "r_evalue_student_mission")
public class StudentMission {
    @EmbeddedId
    private StudentMissionId studentMissionId;

    private String evaluateDesc;

    private Integer basicScore;

    private Integer additionalScore;

}
