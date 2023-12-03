package Net;

import java.util.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Bill {
	private String maBill;
	private String maKhachHang;
	private String maNhanVien;
	private String ngayLap = "";
	private int soGioChoi;
	private int donGiaMoiGio;
	private double tongTienThucAn;
	private String trangThai = "Xuat";
	private static int billID;
	Scanner sc = new Scanner(System.in);

	public Bill() {
		maBill = "Bill" + billID;
		billID++;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ngayLap = sdf.format(date);
		soGioChoi = 0;
		tongTienThucAn = 0;
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

	public void setMaNhanVien() {
		System.out.println("nhap ma nhan vien");
		while (true) {
			maNhanVien = sc.nextLine();
			maNhanVien = maNhanVien.toUpperCase();
			if (checkLoi.checkMaNhanvien(maNhanVien)) {
				break;
			} else {
				System.out.println("Định dạng mã Nhan viên: NV__. Ví dụ: NV01");
			}
			System.out.print("Mời nhập lại: ");
		}
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

	public int getDonGiaMoiGio() {
		return donGiaMoiGio;
	}

	public void setDonGiaMoiGio(int donGiaMoiGio) {
		this.donGiaMoiGio = donGiaMoiGio;
	}

	public double getTongTienThucAn() {
		return tongTienThucAn;
	}

	public void setTongTienThucAn(double tongTienThucAn) {
		this.tongTienThucAn = tongTienThucAn;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public double tinhTien() {
		return tongTienThucAn + soGioChoi * donGiaMoiGio;
	}

	public void huyBill() {
		setTrangThai("Da Huy");
	}

	public void nhap() {
		Scanner scan = new Scanner(System.in);
		setMaNhanVien();
		System.out.print("Nhap ma khach hang: ");
		maKhachHang = sc.nextLine();
		System.out.print("Nhap so gio choi:");
		soGioChoi = sc.nextInt();
		System.out.print("Nhap don gia moi gio choi:");
		donGiaMoiGio = sc.nextInt();
	}

	public void xuat() {
		System.out.println("Ma Bill: " + maBill);
		System.out.println("Ma nhan vien : " + maNhanVien);
		System.out.println("Ma khach hang: " + maKhachHang);
		System.out.println("Ngay xuat: " + ngayLap);
		System.out.println("So gio choi: " + soGioChoi);
		System.out.println("Don gia: " + tinhTien());
		System.out.println("Trang thai: " + trangThai);
	}

	@Override
	public String toString() {
		return "Bill [maBill= " + maBill + ", Ngay xuat= " + ngayLap + ", Nhan vien xuat bill= " + maNhanVien
				+ ", maKhachHang = " + maKhachHang
				+ ", soGioChoi= " + soGioChoi
				+ ",Tong tien = " + tinhTien() + ", Trang Thai: " + trangThai + "]";
	}

}
