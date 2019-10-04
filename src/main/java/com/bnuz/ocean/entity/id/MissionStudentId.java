package com.bnuz.ocean.entity.id;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class MissionStudentId implements Serializable {

    private static final long serialVersionUID = 6766869758485282294L;

    private Integer missionId;

    private Integer studentId;

    public MissionStudentId(Integer missionId, Integer studentId) {
        this.missionId = missionId;
        this.studentId = studentId;
    }

    public MissionStudentId(){}
}
