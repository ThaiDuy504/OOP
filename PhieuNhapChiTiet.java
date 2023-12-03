package Net;

import java.util.Scanner;

public class PhieuNhapChiTiet {
	private String maPhieuNhap;
	private String ngayNhap;
	private ThucAn thucAn;
	private int soluong;
	private Scanner sc = new Scanner(System.in);

	public PhieuNhapChiTiet() {

	}

	public PhieuNhapChiTiet(String maPhieuNhap, String ngayNhap) {
		this.maPhieuNhap = maPhieuNhap;
		this.ngayNhap = ngayNhap;
		thucAn = new ThucAn();
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

	public ThucAn getThucAn() {
		return thucAn;
	}

	public void setThucAn(ThucAn thucAn) {
		this.thucAn = thucAn;
	}

	public double getDonGia() {
		return thucAn.getDonGia() * soluong;
	}

	public void nhap() {
		thucAn.nhap();
		System.out.println("Nhap so luong: ");
		soluong = sc.nextInt();
	}

	public void xuat() {
		System.out.println("Thong tin phieu nhap chi tiet");
		System.out.println("Ma phieu nhap: " + maPhieuNhap);
		System.out.println("Ngay nhap: " + ngayNhap);
		System.out.println("Thuc An : " + thucAn.toString());
		System.out.println("So luong: " + soluong);
	}

	@Override
	public String toString() {
		return "[Ma phieu nhap: " + maPhieuNhap + ", Ngay nhap: " + ngayNhap + ",Thuc An: " + thucAn.toString()
				+ ", So luong: " + soluong + "]";
	}
}