package com.bnuz.ocean.entity.id;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class EvaluateId implements Serializable {

    private String studentId;

    private String missionId;
}
