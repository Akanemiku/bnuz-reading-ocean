package com.bnuz.ocean.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_book_info")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String bookName;

    private Integer bookCate;

    private String bookImg;
}
