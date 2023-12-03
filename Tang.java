package Net;

import java.util.Scanner;

public class Tang {
    private String maTang;
    private String trangThai = "HoatDong";
    danhSachPhong dsPhong = new danhSachPhong();
    Scanner sc = new Scanner(System.in);

    public Tang() {
        maTang = "";
        danhSachPhong dsPhong = new danhSachPhong();
    }

    public Tang(String maTang, String trangThai, danhSachPhong dsPhong) {
        this.maTang = maTang;
        this.trangThai = trangThai;
        this.dsPhong = dsPhong;
    }

    public String getMaTang() {
        return maTang;
    }

    public void setMaTang() {
        String maTang;
        while (true) {
            System.out.print("Nhap ma tang: ");
            maTang = sc.nextLine();
            if (!checkLoi.checkMaTang(maTang)) {
                System.out.println("Nhap ma tang sai cu phap TG + 3 ky tu so tro len");
            } else
                break;
        }
        setMaTang(maTang);
    }

    public void setMaTang(String maTang) {
        this.maTang = maTang;
    }

    public danhSachPhong getDsPhong() {
        return dsPhong;
    }

    public void setDsPhong(danhSachPhong dsPhong) {
        this.dsPhong = dsPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setBaoTri() {
        if (trangThai.equals("BaoTri")) {
            System.out.println("Tang da trong trang thai bao tri san");
            return;
        }
        setTrangThai("BaoTri");
    }

    public void setHoatDong() {
        if (trangThai.equals("HoatDong")) {
            System.out.println("Tang da trong trang thai hoat dong san");
            return;
        }
        setTrangThai("HoatDong");
    }

    public void nhap() {
        setMaTang();
    }

    public void xuat() {
        System.out.println("Ma tang: " + maTang);
        System.out.println("Tinh trang tang: " + trangThai);
    }

    public void menu() {
        while (true) {
            System.out.println("--Menu--");
            System.out.println("1.Xem thong tin tang");
            System.out.println("2.Quan ly cac phong trong tang");
            System.out.println("3.Thoat menu");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    xuat();
                    break;
                case 2:
                    dsPhong.luachon(maTang);
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
        return "[Ma tang: " + maTang + ", Trang Thai: " + trangThai + "]";
    }

    public static void main(String args[]) {
        Tang t = new Tang();
        t.nhap();
        t.menu();
    }
}
