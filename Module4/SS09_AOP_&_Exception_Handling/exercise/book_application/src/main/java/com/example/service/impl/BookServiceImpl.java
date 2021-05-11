package com.example.service.impl;

import com.example.entity.Book;
import com.example.entity.BookCode;
import com.example.repository.BookCodeRepository;
import com.example.repository.BookRepository;
import com.example.service.BookService;
import com.example.service.exception.ErrorBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookCodeRepository bookCodeRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll( pageable );
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findBookById( id );
    }

    public boolean checkAmountBook(Book book) {
        return book.getAmount() != 0;
    }

    @Override
    public void giveBookBack(Integer code) throws ErrorBookException {
        BookCode bookCode = bookCodeRepository.findBookCodeByCode( code );
        if (bookCode != null) {
            Book book = findById( bookCode.getBookId() );
            book.setAmount( book.getAmount() + 1 );
            bookRepository.save( book );
            bookCodeRepository.delete( bookCode );
        } else {
            throw new ErrorBookException();
        }
    }

    @Override
    public void bookingBook(Book book) throws ErrorBookException {
        if (checkAmountBook( book )) {
            book.setAmount( book.getAmount() - 1 );
            bookRepository.save( book );
        } else {
            throw new ErrorBookException();
        }
    }

    @Override
    public Book findBookByBookCode(Integer code) throws ErrorBookException {
        BookCode bookCode = bookCodeRepository.findBookCodeByCode( code );
        if (bookCode!=null){
            return  bookRepository.findBookById( bookCode.getBookId() );
        }else {
            throw new ErrorBookException();
        }

    }


}
