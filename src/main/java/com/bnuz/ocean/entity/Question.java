package com.bnuz.ocean.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_question_info")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;

    private Integer bookId;

    private Integer studentId;

    private Integer questionStat;

    private Date createTime;
}
