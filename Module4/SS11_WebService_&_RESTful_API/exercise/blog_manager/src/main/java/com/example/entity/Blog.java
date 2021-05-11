package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String blogger;

    @Column(name = "date_writer",columnDefinition = "DATE")
    private String date;
    private String content;


    @JsonManagedReference
    @ManyToOne
    @JoinColumn( name = "category", referencedColumnName = "id")
    private Category category;


}
