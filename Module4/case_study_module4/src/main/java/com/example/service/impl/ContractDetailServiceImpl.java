package com.example.service.impl;

import com.example.entity.contract.AttachService;
import com.example.entity.contract.ContractDetail;
import com.example.repository.AttachServiceRepository;
import com.example.repository.ContractDetailRepository;
import com.example.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll( pageable );
    }

    @Override
    public List<AttachService> findAllAttachService() {
        return attachServiceRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save( contractDetail );
    }

    @Override
    public void delete(Integer id) {
        contractDetailRepository.deleteById( id );
    }

    @Override
    public ContractDetail findById(Integer id) {
        return contractDetailRepository.findById( id ).orElse( null );
    }
}
