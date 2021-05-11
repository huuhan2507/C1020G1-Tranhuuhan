package com.example.entity.contract;


import com.example.entity.customer.Customer;
import com.example.entity.employee.Employee;
import com.example.entity.service.Service;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
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

    @NumberFormat
    @Min( value = 1,message = "Deposit must be greater than 0")
    private Double contractDeposit;
    @NumberFormat
    @Min( value = 1,message = "Total Money must be greater than 0")
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

    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetails;
}
