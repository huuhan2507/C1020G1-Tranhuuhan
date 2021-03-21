package com.example.repository;

import com.example.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAll(Pageable pageable);

    @Query(value = "select * from contract c where date(now())-date(c.contract_end_date)<0 group by c.customer_id", nativeQuery = true)
    Page<Contract> findCustomerUseService(Pageable pageable);
}
