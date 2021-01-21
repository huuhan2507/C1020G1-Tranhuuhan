package manager_product;

import commons.InputNumber;
import commons.ReadAndWrite;
import commons.ValidatePhone;
import models.MobilePhone;
import models.SmartPhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerPhone {
    ValidatePhone validatePhone = new ValidatePhone();
    Scanner input = new Scanner( System.in );
    ReadAndWrite readAndWrite = new ReadAndWrite();

    public void themMoiDienThoai() {
        int choose;
        do {
            System.out.println( "1. Them Moi Dien Thoai Chinh Hang" );
            System.out.println( "2. Them Moi Dien Thoai Xach Tay" );
            System.out.println( "3. Thoat" );
            System.out.println( "Hay chon chuc nang: " );
            choose = InputNumber.input();
            switch (choose) {
                case 1:
                    themMoiDienThoaiChinhHang();
                    break;
                case 2:
                    themMoiDienThoaiXachTay();
                    break;
                case 3:
                    System.out.println();
                    break;
                default:
                    System.err.println( "Muc ban chon khong co !" );
            }
        } while (choose != 3);

    }

    private void themMoiDienThoaiXachTay() {
        List<SmartPhone> smartPhoneList = readAndWrite.docDienThoaiChinhHang();
        List<MobilePhone> mobilePhoneList = readAndWrite.docDienThoaiXachTay();
        int count = smartPhoneList.size() + mobilePhoneList.size();
        int id = count + 1;
        String tenDienThoai;
        String giaBan;
        String soLuong;
        String nhaSanXuat;
        String quocGiaXachTay;
        String trangThai;
        System.out.println( "Nhap ten dien thoai: " );
        tenDienThoai = input.nextLine();
        do {
            System.out.println( "Nhap gia ban: " );
            giaBan = input.nextLine();
            if (validatePhone.validateGiaBan( giaBan )) {
                break;
            } else {
                System.err.println( "Gia Ban Khong Hop Le!" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Nhap so luong: " );
            soLuong = input.nextLine();
            if (validatePhone.validateGiaBan( soLuong )) {
                break;
            } else {
                System.err.println( "So luong khong hop le !" );
                System.out.println();
            }
        }while (true);
            System.out.println( "Nhap nha san xuat: " );
            nhaSanXuat = input.nextLine();
        do {
            System.out.println( "Nhap quoc gia xach tay(khac Viet Nam): " );
            quocGiaXachTay = input.nextLine();
            if (validatePhone.validateQuocGiaXachTay( quocGiaXachTay )) {
                break;
            } else {
                System.err.println( "Khong co quoc gia xach tay 'Viet Nam'" );
            }
        } while (true);
        do {
            System.out.println( "Nhap trang thai dien thoai: " );
            trangThai = input.nextLine();
            if (validatePhone.validateTrangThai( trangThai )) {
                break;
            } else {
                System.err.println( "Trang thai phai la : (Da sua chua hoac Chua sua chua)" );
            }
        } while (true);
        System.out.println( "THEM THANH CONG" );
        MobilePhone mobilePhone = new MobilePhone( id, tenDienThoai, giaBan, soLuong, nhaSanXuat, quocGiaXachTay, trangThai );
        readAndWrite.ghiDienThoaiXachTay( mobilePhone );
    }

    private void themMoiDienThoaiChinhHang() {
        List<SmartPhone> smartPhoneList = readAndWrite.docDienThoaiChinhHang();
        List<MobilePhone> mobilePhoneList = readAndWrite.docDienThoaiXachTay();
        int count = smartPhoneList.size() + mobilePhoneList.size();
        int id = count + 1;
        String tenDienThoai;
        String giaBan;
        String soLuong;
        String nhaSanXuat;
        String thoiGianBaoHanh;
        String phamViBaoHanh;
        System.out.println( "Nhap ten dien thoai: " );
        tenDienThoai = input.nextLine();
        do {
            System.out.println( "Nhap gia ban: " );
            giaBan = input.nextLine();
            if (validatePhone.validateGiaBan( giaBan )) {
                break;
            } else {
                System.err.println( "Gia Ban Khong Hop Le!" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Nhap so luong: " );
            soLuong = input.nextLine();
            if (validatePhone.validateGiaBan( soLuong )) {
                break;
            } else {
                System.err.println( "So luong khong hop le !" );
                System.out.println();
            }
        } while (true);
        System.out.println( "Nhap nha san xuat: " );
        nhaSanXuat = input.nextLine();
        do {
            System.out.println( "Nhap thoi gian bao hanh: " );
            thoiGianBaoHanh = input.nextLine();
            if (validatePhone.validateThoiGianBaoHanh( thoiGianBaoHanh )) {
                break;
            } else {
                System.err.println( "Thoi gian bao hanh phai lon hon 0 va nho hon 730 ngay" );
                System.out.println();
            }
        } while (true);
        do {
            System.out.println( "Nhap pham vi bao hanh: " );
            phamViBaoHanh = input.nextLine();
            if (validatePhone.validatePhamViBaoHanh( phamViBaoHanh )) {
                break;
            } else {
                System.err.println( "Pham vi bao hanh la 'Toan Quoc' hoac 'Quoc Te'" );
                System.out.println();
            }
        } while (true);
        System.out.println( "Them Thanh Cong!" );
        SmartPhone smartPhone = new SmartPhone( id, tenDienThoai, giaBan, soLuong, nhaSanXuat, thoiGianBaoHanh, phamViBaoHanh );
        readAndWrite.ghiDienThoaiChinhHang( smartPhone );
    }

    public void xemThongTinDienThoaiChinhHang(){
        List<SmartPhone> smartPhoneList = readAndWrite.docDienThoaiChinhHang();
        System.out.println("*-------------------------------------------------------------------------------------------*");
        System.out.printf("%-7s%-13s%-13s%-13s%-15s%-15s%-15s","ID","TEN","GIA BAN","SO LUONG","NHA SAN XUAT","TG BAO HANH","PV BAO HANH");
        System.out.println();
        System.out.println();
        for (SmartPhone element:smartPhoneList) {
            System.out.printf("%-7s%-13s%-13s%-13s%-15s%-15s%-15s",element.getId(),element.getTenDienThoai(),element.getGiaDienThoai(),
                    element.getSoLuong(),element.getNhaSanXuat(),element.getThoiGianBaoHanh(),element.getPhamViBaoHanh());
            System.out.println();
        }
        System.out.println("*-------------------------------------------------------------------------------------------*");
    }

    public void xemThongTinDienThoaiXachTay(){
        List<MobilePhone> mobilePhoneList = readAndWrite.docDienThoaiXachTay();
        System.out.println("*-------------------------------------------------------------------------------------------*");
        System.out.printf("%-7s%-13s%-13s%-13s%-15s%-15s%-15s","ID","TEN","GIA BAN","SO LUONG","NHA SAN XUAT","QUOC GIA","TRANG THAI");
        System.out.println();
        System.out.println();
        for (MobilePhone element:mobilePhoneList) {
            System.out.printf("%-7s%-13s%-13s%-13s%-15s%-15s%-15s",element.getId(),element.getTenDienThoai(),element.getGiaDienThoai(),
                    element.getSoLuong(),element.getNhaSanXuat(),element.getQuocGiaXachTay(),element.getTrangThai());
            System.out.println();
        }
        System.out.println("*-------------------------------------------------------------------------------------------*");
    }

    public void xemThongTinDienThoai(){
        int choose;
        do {
            System.out.println("1. Xem thong tin dien thoai chinh hang");
            System.out.println("2. Xem thong tin dien thoai xach tay");
            System.out.println("3. Thoat");
            choose = InputNumber.input();
            switch (choose){
                case 1:
                    xemThongTinDienThoaiChinhHang();
                    break;
                case 2:
                    xemThongTinDienThoaiXachTay();
                    break;
                case 3:
                    System.out.println();
                    break;
                default:
                    System.err.println("Khong co muc ma ban lua chon !");

            }
        }while (choose!=3);


    }

//    public void xoaDienThoai() {
//        int choose;
//        List<Object> objectList = readAndWrite.docDienThoai();
//        if (objectList.size() == 0) {
//            System.out.println( "Het du lieu de xoa" );
//            return;
//        }
//        do {
//            xemThongTinhDienThoai();
//            System.out.println( "Chon vi tri de xoa: " );
//            choose = InputNumber.input() - 1;
//        } while (choose < 0 || choose > objectList.size());
//        if (objectList.size() != 0) {
//            objectList.remove( choose );
//            readAndWrite.ghiDienThoaiLamMoi();
//            readAndWrite.ghiLaiDienThoai();
//        } else {
//            readAndWrite.ghiDienThoaiLamMoi();
//        }
//
//    }
}
