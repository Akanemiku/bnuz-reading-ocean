package com.bnuz.ocean.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "t_answer_info")
public class Answer {
    private Integer answerId;

    private Integer questionId;

    private Integer teacherId;

    private String answerAns;

    private Date createTime;
}
