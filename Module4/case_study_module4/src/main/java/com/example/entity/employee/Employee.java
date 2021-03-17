package com.example.entity.employee;

import com.example.entity.contract.Contract;
import com.example.entity.login.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeName;

    @Column(columnDefinition = "DATE")
    private String employeeBirthday;
    private String employeeCardId;
    private Double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "positionId", referencedColumnName = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "divisionId", referencedColumnName = "divisionId")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "educationDegree", referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    @ManyToOne
    @JoinColumn(name = "userName", referencedColumnName = "userName")
    private User user;
}
