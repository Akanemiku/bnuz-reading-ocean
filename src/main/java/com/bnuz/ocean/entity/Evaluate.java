package com.bnuz.ocean.entity;

import com.bnuz.ocean.entity.id.EvaluateId;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "r_evaluate_student_mission")
public class Evaluate {

    @EmbeddedId
    private EvaluateId evaluateId;

    @Column(name="evaluate_desc")
    private String assessPlus;

    @Column(name = "integral_score")
    private Integer integral;

    @Column(name = "assess")
    private String assess;

}
