package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query(nativeQuery = true,value = "select * from t_book_info")
    List<Book> findAll();

    @Query(nativeQuery = true,value = "select book_name from t_book_info where book_id=?1")
    String findBookNameByBookId(Integer bookId);

    Book findBooksByBookId(@Param("bookId") Integer bookId);
}

