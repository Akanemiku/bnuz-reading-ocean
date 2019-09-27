package com.bnuz.ocean.entity.id;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class StudentMissionId {
    private Integer evaluateId;
    private Integer studentId;
    private Integer missionId;
}
