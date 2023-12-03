package Net;

import java.io.Serializable;

import Net.TaiKhoan;

public class QuanLi extends NhanVien implements Serializable {

	public QuanLi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuanLi(String maNhanVien, String hoTen, String diaChi, String soDienThoai, String ngaySinh,
			TaiKhoan taiKhoan,
			double heSoLuong) {
		super(maNhanVien, hoTen, diaChi, soDienThoai, ngaySinh, taiKhoan, heSoLuong);
		// TODO Auto-generated constructor stub
	}

	public double luong() {
		return heSoLuong * 3000000;
	}

	@Override
	public String TinhLuong() {
		return " Mã nhân viên :" + maNhanVien + " , Họ tên :" + hoTen + " , Lương :" + luong();
	}
}
