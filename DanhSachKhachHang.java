package Net;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

import Net.KhachHang;
import Net.QuyenHanKhachHang;

public class DanhSachKhachHang {
	KhachHang[] arr = new KhachHang[10000];
	transient int n;
	transient int count = 0;

	public DanhSachKhachHang() {
		n = 0;
		arr = new KhachHang[1];
	}

	public void luachon() {
		Scanner sc = new Scanner(System.in);
		int x;
		System.out.println("Nhập số lượng khách hàng cần nhập ban đầu: ");
		n = Integer.parseInt(sc.nextLine());
		arr = new KhachHang[n];
		boolean flag = true;
		outer: while (flag) {
			System.out.println("----------------Nhập lựa chọn-------------");
			System.out.println("1.Tìm kiếm Khách Hàng (Mã Khách Hàng). ");
			System.out.println("2.Thêm một Khách Hàng. ");
			System.out.println("3.Xoá một Khách Hàng. ");
			System.out.println("4.Xuất danh sách Khách Hàng.");
			System.out.println("5.Ghi file danh sách Khách Hàng. ");
			System.out.println("6.Đọc file danh sách Khách Hàng. ");
			System.out.println("7.Thoát khỏi chương trình.");
			x = Integer.parseInt(sc.nextLine());
			switch (x) {
				case 1:
					System.out.println("Nhập khách hàng cần tìm kiếm:");
					String maTimKiem = sc.nextLine();
					timkiem(maTimKiem);
					break;
				case 2:
					String choice;
					do {
						System.out.println("Thêm Khách Hàng ");
						ThemKhachHang();
						System.out.println("Bạn có muốn tiếp tục thêm hay không (y/n)?");
						choice = sc.nextLine();
						if (choice.equalsIgnoreCase("n")) {
							continue outer;
						}
					} while (true);
				case 3:
					System.out.println("Nhập mã khách hàng muốn xóa: ");
					String maKhachHang = sc.nextLine();
					XoaKhachHang(maKhachHang);
					break;
				case 4:
					System.out.println("Danh sách tất cả khách hàng");
					XuatDanhSachKH();
					break;
				case 5:
					ghifile();
					break;
				case 6:
					docfile();
					break;
				case 7:
					flag = false;
					break;
				default:
					System.out.println("Lựa chọn không hợp lệ");
					break;
			}
		}

	}

	public KhachHang timKiemTheoTaiKhoan(String ten, String matkhau) {
		for (KhachHang kh : arr) {
			if (kh == null)
				continue;
			TaiKhoan tk = kh.getTaiKhoan();
			if (tk.getTendangnhap().equals(ten) && tk.getMatkhau().equals(matkhau)) {
				return kh;
			}
		}
		return null;
	}

	public void timkiem(String maTimKiem) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				if (arr[i].getMaKhachHang().equalsIgnoreCase(maTimKiem)) {
					arr[i].xuat();
					return;
				}
			}
		}
		System.out.println("Không tìm thấy mã Khách Hàng trong danh sách !");
	}

	public void ThemKhachHang() {
		System.out.println("Nhâp thông tin Khách Hàng cần thêm :");
		KhachHang nv = new KhachHang();
		nv.nhap();
		nv.getTaiKhoan().setQuyenhan(new QuyenHanKhachHang());
		for (KhachHang kh : arr) {
			if (kh != null && kh.getMaKhachHang().equals(nv.getMaKhachHang())) {
				System.out.println("Ma khach hang da ton tai");
				return;
			}
		}
		if (n == arr.length)
			arr = Arrays.copyOf(arr, arr.length + 1);
		arr[n] = nv;
		n++;
	}

	public void XoaKhachHang(String maKhachHang) {
		int flag = 0;
		int index = -1;
		for (int i = 0; i < n; i++) {
			if (arr[i] != null) {
				if (arr[i].getMaKhachHang().equalsIgnoreCase(maKhachHang)) {
					index = i;
					flag = 1;
					break;
				}
			}
		}
		if (flag == 1) {
			for (int i = index; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			n--;
			arr = Arrays.copyOf(arr, arr.length - 1);
			System.out.println("Xoá thành công");
		} else {
			System.out.println("Không tìm thấy mã Khách Hàng cần xoá.");
		}
	}

	public void XuatDanhSachKH() {
		System.out.println("--------------Danh Sách Khách Hàng----------------- ");
		for (KhachHang khachHang : arr) {
			if (khachHang != null)
				khachHang.xuat();
		}
	}

	public void ghifile() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("KhachHang.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(arr);
			System.out.println("Ghi file thành công.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void docfile() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("KhachHang.dat");
			ois = new ObjectInputStream(fis);
			arr = (KhachHang[]) ois.readObject();
			System.out.println("doc file danh sach khach hang thanh cong");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					ois.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
