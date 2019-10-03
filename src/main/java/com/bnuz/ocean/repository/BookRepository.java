package com.bnuz.ocean.repository;

import com.bnuz.ocean.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query(nativeQuery = true,value = "select * from t_book_info")
    List<Book> findAll();
}

