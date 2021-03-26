package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class KhachHang {
    @Id
    private String maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private String email;
}
