package Net;

import java.util.Scanner;

import Net.checkLoi;

public class ThucAn {
	private String MaThucAn;
	private String TenThucAn;
	private String TheLoai;
	private double DonGia;
	private int soluong;
	Scanner sc = new Scanner(System.in);

	public ThucAn() {
	}

	public ThucAn(String MaThucAn, String TenThucAn, String TheLoai, double DonGia, int soluong) {
		this.MaThucAn = MaThucAn;
		this.TenThucAn = TenThucAn;
		this.TheLoai = TheLoai;
		this.DonGia = DonGia;
		this.soluong = soluong;
	}

	public String getMaThucAn() {
		return MaThucAn;
	}

	public void setMaThucAn() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Nhap ma thuc an: ");
			String mathucan = sc.nextLine();
			mathucan = mathucan.toUpperCase();
			if (!checkLoi.checkMaThucAn(mathucan)) {
				System.out.println("Ma thuc an phai theo dinh dang TA + 3 ky tu so tro len");
			} else {
				setMaThucAn(mathucan);
				return;
			}
		}
	}

	public void setMaThucAn(String maThucAn) {
		this.MaThucAn = maThucAn;
	}

	public void setTenThucAn() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Nhap ten thuc an: ");
			String tenthucAn = sc.nextLine();
			if (!checkLoi.checkTen(tenthucAn)) {
				System.out.println("Ten thuc an khong duoc chua ky tu dac biet va ky tu so");
			} else {
				setTenThucAn(tenthucAn);
				return;
			}
		}
	}

	public String getTenThucAn() {
		return TenThucAn;
	}

	public void setTenThucAn(String tenThucAn) {
		this.TenThucAn = tenThucAn;
	}

	public String getTheLoai() {
		return TheLoai;
	}

	public void setTheLoai(String theLoai) {
		this.TheLoai = theLoai;
	}

	public double getDonGia() {
		return DonGia;
	}

	public void setDonGia(double donGia) {
		this.DonGia = Math.max(0, donGia);
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong() {
		int soluong;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so luong: ");
		soluong = sc.nextInt();
		while (soluong <= 0) {
			System.out.println("Nhap sai so luong vui long nhap lai: ");
			soluong = sc.nextInt();
		}
		setSoluong(soluong);
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public void nhap() {
		setMaThucAn();
		System.out.print("Nhập tên thức ăn: ");
		setTenThucAn();
		System.out.print("Nhập loại thức ăn: ");
		setTheLoai(sc.nextLine());
		System.out.print("Nhập đơn giá: ");
		setDonGia(sc.nextDouble());
		setSoluong();
	}

	public void nhap(String identify) {
		System.out.print("Nhập tên thức ăn: ");
		setTenThucAn();
		System.out.print("Nhập loại thức ăn: ");
		setTheLoai(sc.nextLine());
		System.out.print("Nhập đơn giá: ");
		setDonGia(sc.nextDouble());
		setSoluong();
	}

	public void xuat() {
		System.out.println("Mã thức ăn: " + MaThucAn);
		System.out.println("Tên thức ăn: " + TenThucAn);
		System.out.println("Loại thức ăn: " + TheLoai);
		System.out.println("Đơn giá: " + DonGia);
		System.out.println("So luong: " + soluong);
		System.out.println("----------------------------");
	}

	@Override
	public String toString() {
		return "ThucAn [MaThucAn=" + MaThucAn + ", TenThucAn=" + TenThucAn + ", TheLoai=" + TheLoai + ", DonGia="
				+ DonGia + ", so luong =" + soluong + "]";
	}

}
