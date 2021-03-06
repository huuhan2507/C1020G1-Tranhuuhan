package com.example.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    public static final Integer amountBooing = new Book().getAmount();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;
    private String name;
    private Integer amount;

}
