package models;

public class SmartPhone extends Phone {
   private String thoiGianBaoHanh;
   private String phamViBaoHanh;

    public SmartPhone(int id, String tenDienThoai, String giaDienThoai, String soLuong, String nhaSanXuat, String thoiGianBaoHanh, String phamViBaoHanh) {
        super( id, tenDienThoai, giaDienThoai, soLuong, nhaSanXuat );
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public String getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String xemThongTinDienThoai() {
        return getId()+","+getTenDienThoai()+","+getSoLuong()+","+getNhaSanXuat()+","+getThoiGianBaoHanh()+","+getPhamViBaoHanh();
    }

    @Override
    public String toString() {
        return  super.toString()+"," + thoiGianBaoHanh + "," + phamViBaoHanh;
    }
}
