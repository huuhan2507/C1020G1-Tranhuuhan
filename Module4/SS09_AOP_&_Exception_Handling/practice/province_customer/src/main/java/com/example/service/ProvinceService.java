package com.example.service;
import com.example.entity.Province;
import java.util.Optional;

public interface ProvinceService {
    Iterable<Province> findAll();

    Optional<Province> findById(Long id);

    void save(Province province);

    void remove(Long id);
}
