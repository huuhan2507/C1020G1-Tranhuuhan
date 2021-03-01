package com.example.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String blogger;

    @Column(name = "date_writer",columnDefinition = "DATE")
    private String date;

    private String content;
}
