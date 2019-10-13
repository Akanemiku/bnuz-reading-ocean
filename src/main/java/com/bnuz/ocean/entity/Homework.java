package com.bnuz.ocean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "r_homework_student")
@Data
@Entity
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "homework_id")
    private Integer postId;

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "book_id")
    private Integer bookId;

    @Transient
    private String bookName;

    @Column(name = "missionId")
    private Integer missionId;

    @Column(name = "homework_type")
    private String postType;

    @Column(name = "homework_content")
    private String postContent;

    @Column(name = "homework_title")
    private String postTitle;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_url")
    private String fileUrl;
}
