package com.bnuz.ocean.entity.id;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class StudentMissionId implements Serializable {

    private static final long serialVersionUID = 1666092033040580791L;

    private Integer evaluateId;

    private Integer studentId;

    private Integer missionId;
}
