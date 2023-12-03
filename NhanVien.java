package Net;

import java.io.Serializable;
import java.util.Scanner;

import Net.TaiKhoan;
import Net.checkLoi;

public abstract class NhanVien extends ConNguoi implements Serializable {
	protected String maNhanVien;
	protected double heSoLuong;
	private transient Scanner sc = new Scanner(System.in);

	public NhanVien(String maNhanVien, String hoTen, String diaChi, String soDienThoai, String ngaySinh,
			TaiKhoan taiKhoan,
			double heSoLuong) {
		super(hoTen, diaChi, soDienThoai, ngaySinh, taiKhoan);
		// TODO Auto-generated constructor stub
		this.maNhanVien = maNhanVien;
		this.heSoLuong = heSoLuong;
	}

	public NhanVien() {
		super();
		maNhanVien = " ";
		heSoLuong = 0;
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
				System.out.println("Dinh dang ma nhan vien: NV__. Vi du : NV01");
			}
			System.out.print("Moi nhap lai: ");
		}
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong() {
		while (true) {
			try {
				heSoLuong = Double.parseDouble(sc.nextLine());
				if (heSoLuong >= 0) {
					break;
				} else {
					System.out.print("He so luong khong hop le ! Moi nhap lai: ");
				}
			} catch (NumberFormatException exception) {
				System.out.print(" He so luong khong dung dinh dang ! Moi nhap lai: ");
			}
		}
	}

	public abstract String TinhLuong();

	public void nhap() {
		System.out.println("-------------Nhap nhan vien-----------");
		System.out.println("Nhap ma nhan vien :");
		setMaNhanVien();
		super.nhap();
		System.out.println("Nhap he so luong:");
		setHeSoLuong();
	}

	public void xuat() {
		System.out.println("---------Xuat thong tin nhan vien-------");
		System.out.println("Ma nhan vien :" + maNhanVien);
		super.xuat();
		System.out.println("He so luong:" + heSoLuong);
	}
}
