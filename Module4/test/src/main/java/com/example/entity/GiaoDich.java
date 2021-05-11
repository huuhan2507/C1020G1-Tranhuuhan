package com.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class GiaoDich {
    @Id
    @Pattern( regexp = "(MGD-)[0-9]{4}", message = "Mã khách hàng phải theo format MGV-XXXX với X là số 0-9")
    private String maGiaoDich;
    private String ngayGiaoDich;
    @NumberFormat
    @Min( 500000 )
    private Double donGia;
    @NumberFormat
    @Min( 20 )
    private Double dienTich;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "loaiDichVuId",referencedColumnName = "id")
    private LoaiDichVu loaiDichVu;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "maKhachHang",referencedColumnName = "maKhachHang")
    private KhachHang khachHang;

}
