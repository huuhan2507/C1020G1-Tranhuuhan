package com.example.repository;

import com.example.entity.service.Service;
import com.example.entity.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {
    Page<Service> findServiceByServiceType(ServiceType serviceType, Pageable pageable);

    Service findServiceByServiceCode(String code);
}
