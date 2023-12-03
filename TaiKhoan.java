package Net;

import java.util.Scanner;

import Net.checkLoi;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TaiKhoan {
    private String tendangnhap;
    private String matkhau;
    private String ngaytao;
    private String tinhtrang;
    private QuyenHan quyenhan;
    private Scanner sc = new Scanner(System.in);

    public TaiKhoan() {
        tendangnhap = "";
        matkhau = "";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ngaytao = sdf.format(date);
        tinhtrang = "OPEN";
        quyenhan = null;
    }

    public TaiKhoan(String tendangnhap, String matkhau, String ngaytao, String tinhtrang, QuyenHan quyenhan) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.ngaytao = ngaytao;
        this.tinhtrang = tinhtrang;
        this.quyenhan = quyenhan;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public QuyenHan getQuyenhan() {
        return quyenhan;
    }

    public void setQuyenhan(QuyenHan quyenhan) {
        this.quyenhan = quyenhan;
    }

    public void nhapMatKhau(String matkhaucu) {
        String matkhau;
        while (true) {
            matkhau = sc.nextLine();
            if (matkhau.equals(matkhaucu) || !(checkLoi.checkmatKhau(matkhau))) {
                System.out.println("Mat giong mat khau cuu hoac chua ky tu dac biet hoac khac 8 ky tu");
            } else {
                setMatkhau(matkhau);
                return;
            }
        }
    }

    public void nhap() {
        System.out.print("Nhap ten dang nhap: ");
        tendangnhap = sc.nextLine();
        System.out.print("Nhap mat khau: ");
        nhapMatKhau("");
    }

    public void xuat() {
        System.out.println("Tai khoan: " + tendangnhap);
        System.out.println("Mat khau: " + matkhau);
        System.out.println("Ngay tao tai khoan: " + ngaytao);
        System.out.println("Quyen han" + quyenhan.getLoaiQuyenHan());
        System.out.println("Tinh trang tai khoan: " + tinhtrang);
    }

    public void suaMatKhau() {
        System.out.println("Nhap mat khau moi: ");
        nhapMatKhau(matkhau);
    }

    @Override
    public String toString() {
        return "[Ten dang nhap: " + tendangnhap + ",MatKhau: " + matkhau + ", Ngay tao: " + ngaytao + ", QuyenHan: "
                + quyenhan.getLoaiQuyenHan() + ", Tinh Trang Tai Khoan: " + tinhtrang + "]";
    }
}