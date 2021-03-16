package com.example.service;

import com.example.entity.contract.AttachService;
import com.example.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);

    List<AttachService> findAllAttachService();

    void save(ContractDetail contractDetail);
}
