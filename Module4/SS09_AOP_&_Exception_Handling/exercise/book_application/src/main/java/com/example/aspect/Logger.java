package com.example.aspect;

import com.example.controller.BookController;
import com.example.entity.Book;
import com.example.service.exception.ErrorBookException;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Aspect
public class Logger {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger( BookController.class );
    public static String bookName;
    @ExceptionHandler(ErrorBookException.class)
    public String errorBook() {
        return "/error";
    }

    @After("execution(* com.example.controller.BookController.giveBookBack(..))")
    public void actionGiveBookBack(){
        System.out.println("Give Book Back !");
        System.out.println("Book: " + bookName);
        System.out.println("Time: " + LocalDateTime.now());
        LOGGER.info( "action: Give Book Back" );
        LOGGER.info( "Book: "+bookName );
        LOGGER.info( "Time: " + LocalDateTime.now() );
    }

    @After( "execution(* com.example.controller.BookController.bookingBook(..))")
    public void actionBorrowBook(){
        System.out.println("Borrow Book !");
        System.out.println("Book: " + bookName);
        System.out.println("Time: " + LocalDateTime.now());
        LOGGER.info( "action: Borrow Book" );
        LOGGER.info( "Book: "+bookName );
        LOGGER.info( "Time: " + LocalDateTime.now() );
    }

}
