package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findAll() {
    }

    @Test
    public void findBookNameByBookId() {
    }

    @Test
    public void findBooksByBookId() {
        Book book = bookRepository.findBooksByBookId(1);
        System.out.println(book);
    }
}