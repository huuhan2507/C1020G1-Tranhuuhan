package service.impl;

import bean.SanPham;
import repository.SanPhamRepository;
import repository.impl.SanPhamRepositoryImpl;
import service.SanPhamService;

import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {
    SanPhamRepository sanPhamRepository = new SanPhamRepositoryImpl();
    @Override
    public List<SanPham> hienThiSanPham() {
       return sanPhamRepository.hienThiSanPham();
    }

    @Override
    public void themSanPham(SanPham sanPham) {
        sanPhamRepository.themSanPham( sanPham );
    }

    @Override
    public List<SanPham> hienThiSanPhamTheoNgay(String date) {
       return sanPhamRepository.hienThiSanPhamTheoNgay( date );
    }

    @Override
    public List<SanPham> hienThiTopSanPham(int top) {
        return sanPhamRepository.hienThiTopSanPham( top );
    }
}
