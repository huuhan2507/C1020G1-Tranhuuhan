package com.example.entity.customer;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerTypeId;
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    @JsonBackReference
    private Set<Customer> customers;


}
