package com.example.service;

import com.example.model.SmartPhone;

import java.util.List;

public interface SmartPhoneService {
    List<SmartPhone> findAll();

    SmartPhone findById(Integer id);

    SmartPhone save(SmartPhone smartPhone);

    SmartPhone deleteById(Integer id);
}
