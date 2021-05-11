package com.example.service.impl;

import com.example.model.SmartPhone;
import com.example.repository.SmartPhoneRepository;
import com.example.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartPhoneServiceImpl implements SmartPhoneService {
    @Autowired
    private SmartPhoneRepository smartPhoneRepository;
    @Override
    public List<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        return smartPhoneRepository.findById( id ).orElse( null );
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
       return smartPhoneRepository.save( smartPhone );
    }

    @Override
    public SmartPhone deleteById(Integer id) {
        smartPhoneRepository.deleteById( id );
        return null;
    }
}
