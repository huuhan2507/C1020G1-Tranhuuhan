package controller;

import commons.InputNumber;
import commons.ReadAndWrite;
import manager_product.ManagerPhone;

public class MainController {
    public void mucThongTinChung(){
        ManagerPhone managerPhone = new ManagerPhone();
        ReadAndWrite readAndWrite = new ReadAndWrite();
        int luaChon;
        do {
            System.out.println("---CHUONG TRINH QUAN LY DIEN THOAI---");
            System.out.println("Chon chuc nang theo so(de tiep tuc): ");
            System.out.println("1. Them moi");
            System.out.println("2. Xoa");
            System.out.println("3. Xem danh sach dien thoai");
            System.out.println("4. Tim kiem");
            System.out.println("5. Thoat");
            System.out.println("Chon chuc nang: ");
            luaChon= InputNumber.input();
            switch (luaChon){
                case 1:
                    managerPhone.themMoiDienThoai();
                    readAndWrite.ghiDienThoai();
                    break;
                case 2:
//                    managerPhone.xoaDienThoai();
                    break;
                case 3:
                    managerPhone.xemThongTinDienThoai();
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("HEN GAP LAI!");
                    break;
                default:
                    System.err.println("Muc Lua Chon Khong Co !");
                    System.out.println();

            }
        }while (luaChon!=5);

    }

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.mucThongTinChung();
    }
}
