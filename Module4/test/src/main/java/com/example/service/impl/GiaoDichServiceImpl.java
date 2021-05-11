package com.example.service.impl;

import com.example.entity.GiaoDich;
import com.example.entity.KhachHang;
import com.example.entity.LoaiDichVu;
import com.example.repository.GiaoDichRepository;
import com.example.repository.KhachHangRepository;
import com.example.repository.LoaiDichVuRepository;
import com.example.service.GiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GiaoDichServiceImpl implements GiaoDichService {
    @Autowired
    private GiaoDichRepository giaoDichRepository;
    @Autowired
    private LoaiDichVuRepository loaiDichVuRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<GiaoDich> findAll() {
        return giaoDichRepository.findAll();
    }

    @Override
    public void deleteByCode(String code) {
        giaoDichRepository.deleteById( code );
    }

    @Override
    public void save(GiaoDich giaoDich) {
        giaoDichRepository.save( giaoDich );
    }

    @Override
    public List<LoaiDichVu> findLoaiDichVuAll() {
        return loaiDichVuRepository.findAll();
    }

    @Override
    public List<KhachHang> findKhachHangAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public GiaoDich findByCode(String code) {
        return giaoDichRepository.findById( code ).orElse( null );
    }
}
