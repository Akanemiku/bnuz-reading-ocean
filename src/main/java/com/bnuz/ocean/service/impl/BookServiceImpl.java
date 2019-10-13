package com.bnuz.ocean.service.impl;

import com.bnuz.ocean.entity.Book;
import com.bnuz.ocean.entity.Homework;
import com.bnuz.ocean.repository.BookRepository;
import com.bnuz.ocean.service.BookService;
import com.bnuz.ocean.service.MissionBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private MissionBookService missionBookService;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public String findBookNameByBookId(Integer bookId){
        return bookRepository.findBookNameByBookId(bookId);
    }

    @Override
    public List<Book> findBooksByMissionId(String missionId) {
        List<Integer> bookIdList = missionBookService.findAllBookIdByMissionId(Integer.valueOf(missionId));
        List<Book> bookList = new ArrayList<>();
        for (Integer bookId :
                bookIdList) {
            Book book = findBookByBookId(bookId);
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public Book findBookByBookId(Integer bookId) {
        return bookRepository.findBooksByBookId(bookId);
    }
}
