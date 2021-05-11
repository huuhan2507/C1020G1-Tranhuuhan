package com.example.repository;

import com.example.entity.BookCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCodeRepository extends JpaRepository<BookCode,Integer> {
    BookCode findBookCodeByCode(Integer code);
}
