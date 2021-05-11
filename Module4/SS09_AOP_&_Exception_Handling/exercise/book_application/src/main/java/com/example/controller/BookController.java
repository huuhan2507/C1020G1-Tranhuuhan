package com.example.controller;


import com.example.aspect.Logger;
import com.example.entity.Book;
import com.example.entity.BookCode;
import com.example.service.BookCodeService;
import com.example.service.BookService;
import com.example.service.exception.ErrorBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;


@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    BookCodeService bookCodeService;

    @GetMapping("/")
    public String goHome(Pageable pageable, Model model) {
        model.addAttribute( "bookList", bookService.findAll( pageable ) );
        return "/home";
    }

    @GetMapping("/booking/{id}")
    public String formBooking(@PathVariable Integer id, Model model) {
        model.addAttribute( "book", bookService.findById( id ) );
        return "/booking";
    }

    @PostMapping("/booking")
    public String bookingBook(@ModelAttribute Book book , RedirectAttributes redirectAttributes) throws ErrorBookException {
        Random random = new Random();
        Integer rand = random.nextInt( 99999 - 10000 ) + 10000;
        BookCode bookCode = new BookCode();
        bookCode.setCode( rand );
        bookCode.setBookId( book.getId() );
        bookCodeService.save( bookCode );
        bookService.bookingBook( book );
        redirectAttributes.addFlashAttribute( "code",rand );
        Logger.bookName = book.getName();
        return "redirect:/";
    }

    @GetMapping("/giveback")
    public String giveBackBookForm(){
        return "/givebookback";
    }

    @PostMapping("/givebookback")
    public String giveBookBack(@RequestParam Integer code) throws ErrorBookException {
        Logger.bookName = bookService.findBookByBookCode( code ).getName();
        bookService.giveBookBack( code );
        return "redirect:/";
    }
}
