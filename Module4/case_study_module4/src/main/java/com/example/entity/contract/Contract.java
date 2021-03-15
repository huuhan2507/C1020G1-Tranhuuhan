package com.example.entity.contract;


import com.example.entity.customer.Customer;
import com.example.entity.employee.Employee;
import com.example.entity.service.Service;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;

    @Column(columnDefinition = "DATE")
    private String contractStartDate;
    @Column(columnDefinition = "DATE")
    private String contractEndDate;
    private Double contractDeposit;
    private Double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "serviceId", referencedColumnName = "serviceId")
    private Service service;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;
}
