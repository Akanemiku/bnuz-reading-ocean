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

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
//    private Integer bookId;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
//    private Integer studentId;



    private Integer questionStat;

    private Date createTime;

    private String questionDes;

    public void setCreateTime(Date createTime) {
        this.createTime = (Date)createTime.clone();
    }
}
