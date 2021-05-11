package com.example.service;

import com.example.entity.Book;
import com.example.service.exception.ErrorBookException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface BookService {
    Page<Book> findAll (Pageable pageable);

    Book findById(Integer id);

    void giveBookBack(Integer id) throws ErrorBookException;

    void bookingBook(Book book) throws ErrorBookException;

    Book findBookByBookCode(Integer code) throws ErrorBookException;
}
