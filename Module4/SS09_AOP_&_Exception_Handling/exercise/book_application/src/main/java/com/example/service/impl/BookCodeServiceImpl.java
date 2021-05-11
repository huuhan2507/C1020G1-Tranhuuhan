package com.example.service.impl;

import com.example.entity.BookCode;
import com.example.repository.BookCodeRepository;
import com.example.service.BookCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCodeServiceImpl implements BookCodeService {
    @Autowired
    BookCodeRepository bookCodeRepository;

    @Override
    public void save(BookCode bookCode) {
        bookCodeRepository.save( bookCode );
    }

}
