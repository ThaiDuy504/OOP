package Net;

import java.util.Scanner;

import Net.ConNguoi;
import Net.DanhSachKhachHang;
import Net.DanhSachNhanVien;
import Net.TongHopDauVao;
import Net.danhSachBill;

public abstract class QuyenHan {
    private String loaiQuyenHan;

    public QuyenHan() {
        loaiQuyenHan = "";
    }

    public QuyenHan(String loaiQuyenHan) {
        this.loaiQuyenHan = loaiQuyenHan;
    }

    public String getLoaiQuyenHan() {
        return loaiQuyenHan;
    }

    public void setLoaiQuyenHan(String loaiQuyenHan) {
        this.loaiQuyenHan = loaiQuyenHan;
    }

    public void xemChucNang(ConNguoi conNguoi) {
    }

     public void xemChucNang(DanhSachConNguoi danhSachConNguoi) {
    }

    public void xemChucNang(TongHopDauVao tongHopDauVao) {
    }
}
