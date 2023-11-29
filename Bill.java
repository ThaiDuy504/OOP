package Net;

import java.util.*;
import java.time.LocalDate;

public class Bill {
	private String maBill;
	private String maKhachHang;
	private String maNhanVien;
	private String ngayLap = "";
	private int soGioChoi;
	private int tongTien;
	private String trangThai = "Xuat";
	private static int billID;
	Scanner sc = new Scanner(System.in);

	public Bill() {
		maBill = "Bill" + billID;
		billID++;
		ngayLap = " ";
	}

	public String getMaBill() {
		return maBill;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getNgayLap() {
		return ngayLap;
	}

	public int getSoGioChoi() {
		return soGioChoi;
	}

	public void setSoGioChoi(int soGioChoi) {
		this.soGioChoi = soGioChoi;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public void huyBill() {
		setTrangThai("Da Huy");
	}

	@Override
	public String toString() {
		return "Bill [maBill= " + maBill + ", Ngay xuat= " + ngayLap + ", Nhan vien xuat bill= " + maNhanVien
				+ ", maKhachHang = " + maKhachHang
				+ ", soGioChoi= " + soGioChoi
				+ ",Tong tien = " + tongTien + ", Trang Thai: " + trangThai + "]";
	}

	public static void main(String args[]) {
		Bill b = new Bill();
		System.out.println(b);
	}
}
