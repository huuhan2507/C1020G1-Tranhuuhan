package com.example.service;


import com.example.entity.service.RentType;
import com.example.entity.service.Service;
import com.example.entity.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    Page<Service> findAllServicesByServiceType(ServiceType serviceType, Pageable pageable);

    List<Service> findAll();

    void save(Service service);

    List<RentType> findAllRentType();

    List<ServiceType> findAllServiceType();

    ServiceType findTypeById(Integer id);
}
