package Net;

import java.util.Scanner;

import Net.DanhSachThucAn;

public class BillChiTiet {
	private String maBill;
	private String ngayXuat;
	private ThucAn thucAn = new ThucAn();
	Scanner sc = new Scanner(System.in);

	public BillChiTiet() {
		maBill = "";
		ngayXuat = "";
		thucAn = new ThucAn();
	}

	public BillChiTiet(String maBill, String ngayXuat) {
		this.maBill = maBill;
		this.ngayXuat = ngayXuat;
		thucAn = new ThucAn();
	}

	public BillChiTiet(String maBill, String ngayXuat, ThucAn thucAn) {
		this.maBill = maBill;
		this.ngayXuat = ngayXuat;
		this.thucAn = thucAn;
	}

	public String getMaBill() {
		return maBill;
	}

	public void setMaBill(String maBill) {
		this.maBill = maBill;
	}

	public String getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(String ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public void setThucAn(ThucAn thucAn) {
		this.thucAn = thucAn;
	}

	public double getDonGia() {
		return thucAn.getSoluong() * thucAn.getDonGia();
	}

	public void nhap() {
		System.out.println("Nhap thuc an: ");
		thucAn.nhap();
	}

	public void xuat() {
		System.out.println("Mã bill : " + getMaBill());
		System.out.println("Ngày xuất: " + getNgayXuat());
		System.out.println("Thuc an :" + thucAn);
		System.out.println("Đơn giá: " + getDonGia());
		System.out.println("----------------------------");
	}

	@Override
	public String toString() {
		return "BillChiTiet [maBill=" + maBill + ", ngayXuat=" + ngayXuat + ",Thuc an: " + thucAn + ", donGia="
				+ getDonGia() + "]";
	}

}
