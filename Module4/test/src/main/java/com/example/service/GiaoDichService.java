package com.example.service;

import com.example.entity.GiaoDich;
import com.example.entity.KhachHang;
import com.example.entity.LoaiDichVu;

import java.util.List;

public interface GiaoDichService {
    List<GiaoDich> findAll();

    void deleteByCode(String code);

    void save(GiaoDich giaoDich);

    List<LoaiDichVu> findLoaiDichVuAll();

    List<KhachHang> findKhachHangAll();

    GiaoDich findByCode(String code);

}
