package Net;

import java.util.Scanner;

import Net.TaiKhoan;
import Net.checkLoi;

public class KhachHang extends ConNguoi {
    private String maKhachHang;
    private double diemTichLuy;
    Scanner sc = new Scanner(System.in);

    public KhachHang() {
        super();
        maKhachHang = "";
        diemTichLuy = 0;
    }

    public KhachHang(String hoTen, String diaChi, String soDienThoai, String ngaySinh, TaiKhoan taiKhoan,
            String maKhachHang, int diemTichLuy) {
        super(hoTen, diaChi, soDienThoai, ngaySinh, taiKhoan);
        this.maKhachHang = maKhachHang;
        this.diemTichLuy = diemTichLuy;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang() {
        checkLoi chk = new checkLoi();
        while (true) {
            maKhachHang = sc.nextLine();
            maKhachHang = maKhachHang.toUpperCase();
            if (chk.checkMaKhachHang(maKhachHang)) {
                break;
            } else {
                System.out.println(" Mã Khách Hàng: KH__. Ví dụ: KH01");
            }
            System.out.print("Mời nhập lại: ");
        }
    }

    public double getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(double diemTichLuy) {
        while (true) {
            if (diemTichLuy >= 0.0) {
                this.diemTichLuy = diemTichLuy;
                return;
            } else {
                System.out.print("Điểm Tích Lũy không đúng! Mời Nhập Lại: ");
                diemTichLuy = sc.nextDouble();
            }
        }
    }

    public void CongDiemTichLuy(double diem) {
        diemTichLuy += diem;
    }

    public double TinhDiemTichLuy() {
        return diemTichLuy;
    }

    public void nhap() {
        System.out.println("-----------Nhập Thông Tin Khách Hàng-----------");
        System.out.println("Nhập mã khách hàng :");
        setMaKhachHang();
        super.nhap();
        System.out.println("Nhập điểm tích lũy :");
        setDiemTichLuy(sc.nextDouble());
    }

    public void xuat() {
        System.out.println("-------Xuất Thông Tin Khách Hàng -------");
        System.out.println("Mã Khách Hàng :" + maKhachHang);
        super.xuat();
        System.out.println("Điểm Tích Lũy :" + diemTichLuy);
    }

}
