package com.bnuz.ocean.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_book_info")
public class Book {
    private Integer bookId;

    private String bookName;

    private Integer bookCate;

    private String bookImg;
}
