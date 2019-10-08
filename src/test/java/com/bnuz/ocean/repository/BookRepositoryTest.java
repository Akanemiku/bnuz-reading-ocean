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
    private BookRepository repository;
    @Test
    public void findAll(){
        List<Book> bookList = repository.findAll();
        assertNotEquals(0,bookList.size());
    }
    @Test
    public void findBookNameByBookId(){
        String book = repository.findBookNameByBookId(1);
        assertNotEquals(0,book.length());
    }
}