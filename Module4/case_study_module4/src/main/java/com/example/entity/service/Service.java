package com.example.entity.service;


import com.example.entity.contract.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;

    @Pattern( regexp = "(DV-)[0-9]{4}", message = "The format of the service code is DV-XXXX where X is a number from 0-9 !")
    private String serviceCode;
    private String serviceName;
    private Integer serviceArea;
    private Double serviceCost;
    private Integer serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;

    @ManyToOne
    @JoinColumn(name = "serviceTypeId", referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rentTypeId", referencedColumnName = "rentTypeId")
    private RentType rentType;

    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
    private Set<Contract> contracts;

}
