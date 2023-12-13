package Net;

import java.util.Scanner;

public abstract class PhieuNhapChiTiet {
	private String maPhieuNhap;
	private String ngayNhap;
	private Scanner sc = new Scanner(System.in);

	public PhieuNhapChiTiet() {

	}

	public PhieuNhapChiTiet(String maPhieuNhap, String ngayNhap) {
		this.maPhieuNhap = maPhieuNhap;
		this.ngayNhap = ngayNhap;
	}

	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}

	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public abstract double getTongTien();

	public abstract void nhap();

	public void xuat() {
		System.out.println("Thong tin phieu nhap chi tiet");
		System.out.println("Ma phieu nhap: " + maPhieuNhap);
		System.out.println("Ngay nhap: " + ngayNhap);
	}
}