package com.example.entity.service;


import com.example.annotation.service.CodeDuplicateService;
import com.example.entity.contract.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
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

    @CodeDuplicateService
    @Pattern(regexp = "(DV-)[0-9]{4}", message = "The format of the service code is DV-XXXX where X is a number from 0-9 !")
    private String serviceCode;
    private String serviceName;

    @NumberFormat
    @Min(value = 1, message = " Area must be greater than 0")
    private Integer serviceArea;
    @NumberFormat
    @Min(value = 1, message = "Cost must be greater than 0")
    private Double serviceCost;
    @NumberFormat
    @Min(value = 1, message = "People max must be greater than 0")
    private Integer serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @NumberFormat
    @Min(value = 1, message = "Pool area must be greater than 0")
    private Double poolArea;
    @NumberFormat
    @Min(value = 1, message = "floor must be greater than 0")
    private Integer numberOfFloors;

    @ManyToOne
    @JoinColumn(name = "serviceTypeId", referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rentTypeId", referencedColumnName = "rentTypeId")
    private RentType rentType;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Contract> contracts;

}
