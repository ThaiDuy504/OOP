package Net;

import java.util.Scanner;
import java.util.ArrayList;

public class ROOM {
    Scanner sc = new Scanner(System.in);
    private String maPhong;
    private String trangThai = "HoatDong";
    private danhSachThietBi dsThietBi = new danhSachThietBi();

    public ROOM() {
    }

    public ROOM(String maPhong, String trangThai, danhSachThietBi dsThietBi) {
        this.maPhong = maPhong;
        this.trangThai = trangThai;
        this.dsThietBi = dsThietBi;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong() {
        String maPhong;
        while (true) {
            System.out.print("Nhap ma phong: ");
            maPhong = sc.nextLine();
            if (!checkLoi.checkMaPhong(maPhong)) {
                System.out.println("Nhap ma phong sai cu phap PHG + 3 ky tu so tro len");
            } else
                break;

        }
        setMaPhong(maPhong);
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public danhSachThietBi getDsThietBi() {
        return dsThietBi;
    }

    public void setDsThietBi(danhSachThietBi dsThietBi) {
        this.dsThietBi = dsThietBi;
    }

    public void setBaoTri() {
        if (trangThai.equals("BaoTri")) {
            System.out.println("Phong da trong trang thai bao tri san");
            return;
        }
        setTrangThai("BaoTri");
    }

    public void setHoatDong() {
        if (trangThai.equals("HoatDong")) {
            System.out.println("Phong da trong trang thai hoat dong san");
            return;
        }
        setTrangThai("HoatDong");
    }

    public void nhap() {
        setMaPhong();
    }

    public void xuat() {
        System.out.println("Ma phong: " + maPhong);
        System.out.println("Ting trang phong: " + trangThai);
    }

    public void menu() {
        while (true) {
            System.out.println("--Menu--");
            System.out.println("1.Xem thong tin phong");
            System.out.println("2.Quan ly cac thiet bi trong phong");
            System.out.println("3.Thoat menu");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    xuat();
                    break;
                case 2:
                    dsThietBi.luachon(maPhong);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "[Ma phong: " + maPhong + ", Trang Thai: " + trangThai + "]";
    }

    public static void main(String args[]) {
        ROOM r = new ROOM();
        r.nhap();
        r.menu();
    }
}
