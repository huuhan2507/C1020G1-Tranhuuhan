package com.example.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class BookCode {
    @Id
    private Integer code;

    private Integer bookId;

}
