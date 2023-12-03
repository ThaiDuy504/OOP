package Net;

import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PhieuNhapThucAn {
	private NhaPhanPhoi nhaPhanPhoi;
	private String maNhanVien;
	private String maPhieuNhap;
	private String ngayNhap;
	private double donGia;
	private String tinhTrang = "xuat";
	private static int phieuNhapID = 0;
	Scanner sc = new Scanner(System.in);

	public PhieuNhapThucAn() {
		maPhieuNhap = "PNHAP" + (phieuNhapID++);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ngayNhap = sdf.format(d);
		donGia = 0;
	}

	public NhaPhanPhoi getNhaPhanPhoi() {
		return nhaPhanPhoi;
	}

	public void setNhaPhanPhoi(NhaPhanPhoi nhaPhanPhoi) {
		this.nhaPhanPhoi = nhaPhanPhoi;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien() {
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

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public static int getPhieuNhapID() {
		return phieuNhapID;
	}

	public static void setPhieuNhapID(int phieuNhapID) {
		PhieuNhapThucAn.phieuNhapID = phieuNhapID;
	}

	public void huyPhieuNhap() {
		tinhTrang = "Da Huy";
	}

	public void nhap() {
		nhaPhanPhoi.nhap();
		setMaNhanVien();
	}

	public void xuat() {
		System.out.println("Phieu nhap chi tiet");
		System.out.println("Ma phieu nhap: " + maPhieuNhap);
		nhaPhanPhoi.xuat();
		System.out.println("Ma nhan vien: " + maNhanVien);
		System.out.println("Ngay xuat: " + ngayNhap);
		System.out.println("Don gia: " + donGia);
		System.out.println("Trang thai: " + tinhTrang);
	}

	@Override
	public String toString() {
		return "[Ma phieu nhap: " + maPhieuNhap + ",Nha phan phoi : " + nhaPhanPhoi + ", Ma nhan vien: " + maNhanVien
				+ "Ngay Xuat: " + ngayNhap
				+ ", Don gia: " + donGia + ", Trang Thai: " + tinhTrang + "]";
	}

}
