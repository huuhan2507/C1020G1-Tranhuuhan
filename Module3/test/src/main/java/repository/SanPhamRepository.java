package repository;

import bean.SanPham;

import java.util.List;

public interface SanPhamRepository {
    List<SanPham> hienThiSanPham();

    void themSanPham(SanPham sanPham);

    List<SanPham> hienThiSanPhamTheoNgay(String date);

    List<SanPham> hienThiTopSanPham(int top );
}
