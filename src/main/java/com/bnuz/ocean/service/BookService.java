package com.bnuz.ocean.service;

import com.bnuz.ocean.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    /**
     * 通过bookId找书名
     * @param bookId
     * @return
     */
    String findBookNameByBookId(Integer bookId);

    /**
     * 通过任务Id找到书
     * @param missionId
     * @return
     */
    List<Book> findBooksByMissionId(String missionId);

    /**
     * 通过bookId找到书
     * @param bookId
     * @return
     */
    Book findBookByBookId(Integer bookId);
}
