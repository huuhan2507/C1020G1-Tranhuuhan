package com.example.entity.contract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractDetailId;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "contractId", referencedColumnName = "contractId")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attachServiceId", referencedColumnName = "attachServiceId")
    private AttachService attachService;
}