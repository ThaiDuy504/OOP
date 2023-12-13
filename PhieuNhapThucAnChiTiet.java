package Net;

import java.util.Scanner;

public class PhieuNhapThucAnChiTiet extends PhieuNhapChiTiet {
    private ThucAn thucAn;

    public PhieuNhapThucAnChiTiet() {

    }

    public PhieuNhapThucAnChiTiet(String maPhieuNhap, String ngayNhap) {
        super(maPhieuNhap, ngayNhap);
    }

    public PhieuNhapThucAnChiTiet(ThucAn thucAn) {
        this.thucAn = thucAn;
    }

    public ThucAn getThucAn() {
        return thucAn;
    }

    public void setThucAn(ThucAn thucAn) {
        this.thucAn = thucAn;
    }

    public void nhap() {
        System.out.println("Nhap thuc an:");
        thucAn.nhap();
    }

    public double getTongTien() {
        return thucAn.getDonGia() * thucAn.getSoluong();
    }

    public void xuat() {
        super.xuat();
        thucAn.xuat();
    }

    @Override
    public String toString() {
        return "[Ma phieu: " + getMaPhieuNhap() + ", Ngay nhap: " + getNgayNhap() + ",Thuc an : " + thucAn + "]";
    };

}
