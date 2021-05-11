package models;

public abstract class Phone {
    int id;
   private String tenDienThoai;
   private String giaDienThoai;
   private String soLuong;
   private String nhaSanXuat;

    public Phone(int id, String tenDienThoai, String giaDienThoai, String soLuong, String nhaSanXuat) {
        this.id = id;
        this.tenDienThoai = tenDienThoai;
        this.giaDienThoai = giaDienThoai;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public String getGiaDienThoai() {
        return giaDienThoai;
    }

    public void setGiaDienThoai(String giaDienThoai) {
        this.giaDienThoai = giaDienThoai;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return id + "," + tenDienThoai + "," +
                giaDienThoai + "," +
                soLuong + "," +
                nhaSanXuat;
    }

    public abstract String xemThongTinDienThoai();

}
