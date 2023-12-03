package Net;

import java.util.Date;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Net.TaiKhoan;

public class ConNguoi implements Serializable {

	protected String hoTen;
	protected String diaChi;
	protected String soDienThoai;
	protected String ngaySinh;
	protected TaiKhoan taiKhoan;
	private transient Scanner sc = new Scanner(System.in);

	public ConNguoi(String hoTen, String diaChi, String ngaySinh, String soDienThoai, TaiKhoan taiKhoan) {
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.taiKhoan = taiKhoan;
	}

	public ConNguoi() {
		hoTen = " ";
		diaChi = " ";
		soDienThoai = " ";
		ngaySinh = " ";
		taiKhoan = new TaiKhoan();
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen() {
		while (true) {
			hoTen = sc.nextLine();
			if (hoTen.matches("[\\pL\\pMn*\\s*]+")) {
				hoTen = hoTen.trim();
				hoTen = hoTen.replaceAll("\\s+", " ");
				hoTen = hoTen.toLowerCase();
				String[] Chuoi = hoTen.split(" ");
				hoTen = "";
				for (int i = 0; i < Chuoi.length; i++) {
					hoTen += String.valueOf(Chuoi[i].charAt(0)).toUpperCase() + Chuoi[i].substring(1);
					if (i < Chuoi.length - 1) {
						hoTen += " ";
					}
				}
				break;
			} else {
				System.out.print("Tên không hợp lệ! Mời nhập lại: ");
			}
		}
	}

	public String getDiaChi() {
		return diaChi;
	}

	// .
	public void setDiaChi() {
		while (true) {
			diaChi = sc.nextLine();
			if (diaChi.matches("^[a-zA-Z0-9\\s,'.-]+$")) {
				break;
			} else {
				System.out.print("Địa chỉ không hợp lệ! Mời nhập lại: ");
			}
		}
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai() {
		while (true) {
			soDienThoai = sc.nextLine();
			if (soDienThoai.matches("\\d{10}") && !soDienThoai.matches(".*[a-zA-Z].*")) {
				break;
			} else {
				System.out.print("Số điện thoại không hợp lệ! Mời nhập lại: ");
			}
		}
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		while (true) {
			String input = sc.nextLine();
			try {
				Date date = sdf.parse(input);
				ngaySinh = sdf.format(date);
				break;
			} catch (ParseException e) {
				System.out.print("Ngày sinh không hợp lệ! Mời nhập lại (dd/MM/yyyy): ");
			}
		}
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public void nhap() {
		System.out.println("Nhập họ tên :");
		setHoTen();
		System.out.println("Nhập địa chỉ :");
		setDiaChi();
		System.out.println("Nhập số điện thoại :");
		setSoDienThoai();
		System.out.println("Nhập ngày sinh :");
		setNgaySinh();
		taiKhoan.nhap();
	}

	public void xuat() {
		System.out.println("Họ và tên sinh viên :" + hoTen);
		System.out.println("Địa chỉ :" + diaChi);
		System.out.println("Số điện thoại :" + soDienThoai);
		System.out.println("Ngày sinh :" + ngaySinh);
		taiKhoan.xuat();
	}

	@Override
	public String toString() {
		return "ConNguoi [ Họ tên :" + hoTen + ", Địa chỉ :" + diaChi + ",Số điện thoại :" + soDienThoai
				+ ", Ngày sinh :"
				+ ngaySinh + ", Tai khoan : " + taiKhoan + "]";
	}

}
