package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.Book;
import com.bnuz.ocean.repository.BookRepository;
import com.bnuz.ocean.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
