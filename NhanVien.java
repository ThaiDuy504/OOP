package Net;

import java.io.Serializable;
import java.util.Scanner;

public abstract class NhanVien extends ConNguoi implements Serializable {
	protected String maNhanVien;
	protected double heSoLuong;
	private transient Scanner sc = new Scanner(System.in);

	public NhanVien(String maNhanVien, String hoTen, String diaChi, String soDienThoai, String ngaySinh,
			double heSoLuong) {
		super(hoTen, diaChi, soDienThoai, ngaySinh);
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
			if (maNhanVien.matches("NV" + "[0-9]{1,2}")) {
				break;
			} else {
				System.out.println("Định dạng mã Nhan viên: NV__. Ví dụ: NV01");
			}
			System.out.print("Mời nhập lại: ");
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
					System.out.print("Hệ số lương không hợp lệ ! Mời nhập lại: ");
				}
			} catch (NumberFormatException exception) {
				System.out.print(" Hệ số lương không đúng định dạng ! Mời nhập lại: ");
			}
		}
	}

	public abstract String TinhLuong();

	public void nhap() {
		System.out.println("-------------Nhập nhân viên-----------");
		System.out.println("Nhập mã nhân viên :");
		setMaNhanVien();
		super.nhap();
		System.out.println("Nhập hệ số lương :");
		setHeSoLuong();
	}

	public void xuat() {
		System.out.println("---------Xuất thông tin nhân viên-------");
		System.out.println("Mã nhân viên :" + maNhanVien);
		super.xuat();
		System.out.println("Hệ số lương :" + heSoLuong);
	}
}
