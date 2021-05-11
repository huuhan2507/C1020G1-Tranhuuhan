package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import java.util.Set;

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

    @OneToMany(mappedBy = "khachHang")
    @JsonBackReference
    private Set<GiaoDich> giaoDichSet;
}
