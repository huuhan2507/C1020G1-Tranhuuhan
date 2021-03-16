package com.example.entity.customer;

import com.example.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerCode;
    private String customerName;
    @Column(columnDefinition = "DATE")
    private String customerBirthday;
    private String customerGender;
    private String customerCardId;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "customerTypeId", referencedColumnName = "customerTypeId")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;

}
