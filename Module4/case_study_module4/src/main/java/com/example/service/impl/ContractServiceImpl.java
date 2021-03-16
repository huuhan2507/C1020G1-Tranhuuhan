package com.example.service.impl;

import com.example.entity.contract.Contract;
import com.example.repository.ContractRepository;
import com.example.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll( pageable );
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save( contract );
    }
}
