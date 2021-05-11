package com.example.service;

import com.example.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    void delete(Integer id);

    Contract findById(Integer id);

    Page<Contract> CustomerUserService(Pageable pageable);
}
