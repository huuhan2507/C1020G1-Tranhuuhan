package com.example.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String image;
    private String description;
    private Integer price;
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Cart cart;
}
