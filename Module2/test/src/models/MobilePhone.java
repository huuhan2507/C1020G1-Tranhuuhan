package models;

public class MobilePhone extends Phone {
     private String quocGiaXachTay;
    private String trangThai;

    public MobilePhone(int id, String tenDienThoai, String giaDienThoai, String soLuong, String nhaSanXuat, String quocGiaXachTay, String trangThai) {
        super( id, tenDienThoai, giaDienThoai, soLuong, nhaSanXuat );
        this.quocGiaXachTay = quocGiaXachTay;
        this.trangThai = trangThai;
    }

    public String getQuocGiaXachTay() {
        return quocGiaXachTay;
    }

    public void setQuocGiaXachTay(String quocGiaXachTay) {
        this.quocGiaXachTay = quocGiaXachTay;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return super.toString()+","+ quocGiaXachTay + "," + trangThai;
    }

    @Override
    public String xemThongTinDienThoai() {
        return toString();
    }
}
