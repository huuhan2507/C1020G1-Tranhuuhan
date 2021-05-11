package com.example.repository;

import com.example.entity.LoaiDichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiDichVuRepository extends JpaRepository<LoaiDichVu,Integer> {
}
