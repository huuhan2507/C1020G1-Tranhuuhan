package repository.impl;

import bean.SanPham;
import repository.SanPhamRepository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepositoryImpl implements SanPhamRepository {
    public static final String THEM_SAN_PHAM = "call them_san_pham(?,?,?,?)";
    public static final String DACH_SACH_SAN_PHAM = "select * from san_pham";
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<SanPham> hienThiSanPham() {
        List<SanPham> danhSachSanPham = new ArrayList<>(  );
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement( DACH_SACH_SAN_PHAM );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                SanPham sanPham = new SanPham(  );
                sanPham.setIdSanPham( resultSet.getInt( 1 ) );
                sanPham.setTenSanPham(resultSet.getString( 2 ));
                sanPham.setGiaSanPham( resultSet.getDouble( 3 ) );
                sanPham.setMucGiamGia(resultSet.getInt( 4 ));
                sanPham.setTonKho( resultSet.getInt( 5 ) );
                danhSachSanPham.add( sanPham );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachSanPham;
    }

    @Override
    public void themSanPham(SanPham sanPham) {
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall( THEM_SAN_PHAM );
            callableStatement.setString( 1,sanPham.getTenSanPham() );
            callableStatement.setString( 2,String.valueOf( sanPham.getGiaSanPham() ) );
            callableStatement.setString( 3,String.valueOf( sanPham.getMucGiamGia() ) );
            callableStatement.setString( 3,String.valueOf( sanPham.getTonKho() ) );
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SanPham> hienThiSanPhamTheoNgay(String date) {
        return null;
    }

    @Override
    public List<SanPham> hienThiTopSanPham(int top) {
        return null;
    }
}
