package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.Book;
import com.bnuz.ocean.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    public void findAll() {
        List<Book> bookList = bookService.findAll();
        assertNotEquals(0, bookList.size());
    }

    @Test
    public void findBookNameByBookId() {
        String bookName = bookService.findBookNameByBookId(7);
        assertNotNull(bookName);
    }

    @Test
    public void findBooksByMissionId() {
        List<Book> bookList = bookService.findBooksByMissionId("19");
        assertNotNull(bookList);
    }

    @Test
    public void findBookByBookId() {
        Book book = bookService.findBookByBookId(7);
        assertNotNull(book);
    }
}
