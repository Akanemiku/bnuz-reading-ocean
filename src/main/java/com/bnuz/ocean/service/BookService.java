package com.bnuz.ocean.service;

import com.bnuz.ocean.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    String findBookNameByBookId(Integer bookId);
}
