package Net;

import java.util.Scanner;

public class BillChiTiet {
	private String maBill;
	private String ngayXuat;
	private int soluong;
	private ThucAn thucAn = new ThucAn();
	Scanner sc = new Scanner(System.in);

	public BillChiTiet() {
		maBill = "";
		ngayXuat = "";
		soluong = 0;
		thucAn = new ThucAn();
	}

	public BillChiTiet(String maBill, String ngayXuat) {
		this.maBill = maBill;
		this.ngayXuat = ngayXuat;
		thucAn = new ThucAn();
		soluong = 0;
	}

	public BillChiTiet(String maBill, String ngayXuat, int soluong, ThucAn thucAn) {
		this.maBill = maBill;
		this.ngayXuat = ngayXuat;
		this.soluong = soluong;
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

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public ThucAn getThucAn() {
		return thucAn;
	}

	public void setThucAn(ThucAn thucAn) {
		this.thucAn = thucAn;
	}

	public double getDonGia() {
		return soluong * thucAn.getDonGia();
	}

	public void nhap() {
		System.out.println("Nhap thuc an: ");
		thucAn.nhap();
		System.out.println("Nhap so luong: ");
		sc.nextInt();
	}

	public void xuat() {
		System.out.println("Mã bill : " + getMaBill());
		System.out.println("Ngày xuất: " + getNgayXuat());
		System.out.println("Đơn giá: " + getDonGia());
		System.out.println("----------------------------");
	}

	@Override
	public String toString() {
		return "BillChiTiet [maBill=" + maBill + ", ngayXuat=" + ngayXuat + ", donGia=" + getDonGia() + "]";
	}

}
