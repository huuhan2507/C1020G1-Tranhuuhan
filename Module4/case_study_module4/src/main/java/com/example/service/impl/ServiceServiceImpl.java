package com.example.service.impl;

import com.example.entity.service.RentType;
import com.example.entity.service.ServiceType;
import com.example.repository.RentTypeRepository;
import com.example.repository.ServiceRepository;
import com.example.repository.ServiceTypeRepository;
import com.example.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public Page<com.example.entity.service.Service> findAllServicesByServiceType(ServiceType serviceType, Pageable pageable) {
        return serviceRepository.findServiceByServiceType( serviceType, pageable );
    }

    @Override
    public List<com.example.entity.service.Service> findAll() {
        return serviceRepository.findAll();
    }


    @Override
    public void save(com.example.entity.service.Service service) {
        serviceRepository.save( service );
    }

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType findTypeById(Integer id) {
        return serviceTypeRepository.findById( id ).orElse( null );
    }

    @Override
    public void deleteById(Integer id) {
        serviceRepository.deleteById( id );
    }

    @Override
    public boolean checkServiceCode(String code) {
        return serviceRepository.findServiceByServiceCode( code )==null;
    }

    @Override
    public com.example.entity.service.Service findById(Integer id) {
        return serviceRepository.findById( id ).orElse( null);
    }
}
