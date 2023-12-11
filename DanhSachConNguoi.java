package Net;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

import Net.NhanVien;
import Net.QuyenHanNhanVien;

public class DanhSachConNguoi {
	ConNguoi[] arr = new ConNguoi[1000];
	int n;
	int count = 0;

	public DanhSachConNguoi() {
		n = 0;
		arr = new ConNguoi[1];
	}

	public void luachon() {
		Scanner sc = new Scanner(System.in);
		int x;
		System.out.println("Nhap so luong ban dau: ");
		n = Integer.parseInt(sc.nextLine());
		arr = new ConNguoi[n];
		boolean flag = true;
		outer: while (flag) {
			System.out.println("----------------Nhập lựa chọn-------------");
			System.out.println("1.Nhap nhan vien (phuc vu).");
			System.out.println("2.Nhap nhan vien (quan li). ");
			System.out.println("3.Nhap khach hang. ");
			System.out.println("4.Tim kiem (Theo ma). ");
			System.out.println("5.Them mot nguoi . ");
			System.out.println("6.Xoa mot nguoi(Theo ma). ");
			System.out.println("7.Xuat danh sach nhan vien.");
			System.out.println("8.Xuat danh sach khach hang.");
			System.out.println("9.Xuat danh sach luong cua tung nhan vien.");
			System.out.println("10.Ghi file danh sach nguoi. ");
			System.out.println("11.Doc file danh sach nguoi. ");
			System.out.println("12.Thoat chuong trinh.");
			x = Integer.parseInt(sc.nextLine());
			switch (x) {
				case 1:
					System.out.println("Nhap nhan vien (Phuc vu) " + "(" + (count + 1) + "/" + n + ")");
					arr[count] = new PhucVu();
					arr[count].nhap();
					arr[count].getTaiKhoan().setQuyenhan(new QuyenHanNhanVien());
					count++;
					break;
				case 2:
					System.out.println("Nhap nhan vien (Quan li) " + "(" + (count + 1) + "/" + n + ")");
					arr[count] = new QuanLi();
					arr[count].nhap();
					arr[count].getTaiKhoan().setQuyenhan(new QuyenHanNhanVien());
					count++;
					break;
				case 3:
					System.out.println("Nhap khach hang " + "(" + (count + 1) + "/" + n + ")");
					arr[count] = new KhachHang();
					KhachHang kh = (KhachHang)arr[count];
					kh.nhap();
					arr[count].getTaiKhoan().setQuyenhan(new QuyenHanKhachHang());
					count++;
					break;
				case 4:
					System.out.println("Nhap ma can tim kiem:");
					String maTimKiem = sc.nextLine();
					timkiem(maTimKiem);
					break;
				case 5:
					String choice;
					do {
						System.out.println("Nhap lua chon cua ban ");
						System.out.println("1. Them nhan vien (Phuc vu)");
						System.out.println("2. Thêm nhan vien (Quan li)");
						System.out.println("3. Them khach hang ");
						int c = Integer.parseInt(sc.nextLine());

						switch (c) {
							case 1:
								ThemNvPhucvu();
								break;
							case 2:
								ThemNvQuanli();
								break;
							case 3:
								Themkhachhang();
								break;
							default:
								System.out.println("Lua chon khong hop le");
								break;
						}
						System.out.println("Ban co muon tiep tuc them hay khong (y/n)?");
						choice = sc.nextLine();
						if (choice.equalsIgnoreCase("n")) {
							continue outer;
						}
					} while (true);
				case 6:
					System.out.println("Nhap ma can xoa:");
					String ma = sc.nextLine();
					XoaMotNguoi(ma);
					break;
				case 7:
					System.out.println("Danh sách tất cả nhân viên");
					XuatDanhSachNV();
					break;
				case 8:
					System.out.println("Danh sách tất cả khach hang");
					XuatDanhSachKhachHang();
					break;
				case 9:
					Tinhluong();
					break;
				case 10:
					ghifile();
					break;
				case 11:
					docfile();
					break;
				case 12:
					flag = false;
					break;
				default:
					System.out.println("Lựa chọn không hợp lệ");
					break;
			}
		}
	}

	public ConNguoi timKiemTheoTaiKhoan(String ten, String matkhau) {
		for (ConNguoi nv : arr) {
			if (nv == null)
				continue;
			TaiKhoan tk = nv.getTaiKhoan();
			if (tk.getTendangnhap().equals(ten) && tk.getMatkhau().equals(matkhau)) {
				return nv;
			}
		}
		return null;
	}

	public void timkiem(String maTimKiem) {
		int flag = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				if (arr[i] instanceof KhachHang && ((KhachHang)arr[i]).getMaKhachHang().equalsIgnoreCase(maTimKiem)) {
					KhachHang kh = (KhachHang) arr[i];
					kh.xuat();
					flag = 1;
					break;
				}else if (arr[i] instanceof QuanLi && ((QuanLi)arr[i]).getMaNhanVien().equalsIgnoreCase(maTimKiem)) {
					QuanLi kh = (QuanLi) arr[i];
					kh.xuat();
					flag = 1;
					break;
				}else if (arr[i] instanceof PhucVu && ((PhucVu)arr[i]).getMaNhanVien().equalsIgnoreCase(maTimKiem)) {
					PhucVu kh = (PhucVu) arr[i];
					kh.xuat();
					flag = 1;
					break;
				}
			}
		}
		if(flag == -1){
			System.out.println("Khong tim thay ma !!!");
		}
	}

	public void ThemNvPhucvu() {
		System.out.println("Nhâp thông tin nhân viên cần thêm :");
		NhanVien nv = new PhucVu();
		nv.nhap();
		nv.getTaiKhoan().setQuyenhan(new QuyenHanNhanVien());
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[n] = nv;
		n++;
	}

	public void ThemNvQuanli() {
		System.out.println("Nhâp thông tin nhân viên cần thêm :");
		NhanVien nv = new QuanLi();
		nv.nhap();
		nv.getTaiKhoan().setQuyenhan(new QuyenHanNhanVien());
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[n] = nv;
		n++;
	}

	public void Themkhachhang() {
		System.out.println("Nhâp thông tin khach hang cần thêm :");
		KhachHang kh = new KhachHang();
		kh.nhap();
		kh.getTaiKhoan().setQuyenhan(new QuyenHanNhanVien());
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[n] = kh;
		n++;
	}

	public void XoaMotNguoi(String maNhap) {
		int flag = 0;
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				if (arr[i] instanceof NhanVien && ((NhanVien) arr[i]).getMaNhanVien().equalsIgnoreCase(maNhap)) {
					index = i;
					flag = 1;
					break;
				} else if (arr[i] instanceof KhachHang && ((KhachHang) arr[i]).getMaKhachHang().equalsIgnoreCase(maNhap)) {
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
			System.out.println("Không tìm thấy mã cần xoá !!!");
		}
	}

	public void XuatDanhSachNV() {
		System.out.println("--------------Danh sach nhan vien (Phục vụ)----------------- ");
		for (ConNguoi nhanVien : arr) {
			if (nhanVien instanceof QuanLi) {
				nhanVien.xuat();
			}
		}
		System.out.println("--------------Danh sach nhan vien (Quản lí)------------------ ");
		for (ConNguoi nhanVien : arr) {
			if (nhanVien instanceof PhucVu) {
				nhanVien.xuat();
			}
		}
	}

	public void XuatDanhSachKhachHang(){
		System.out.println("---------Danh sach khach hang la------------");
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != null){
				if(arr[i] instanceof KhachHang){
					((KhachHang)arr[i]).xuat();
				}
			}
		}
	}

	public void Tinhluong() {
		System.out.println("---------Danh sach luong cua tung nhan vien------");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				if (arr[i] instanceof PhucVu || arr[i] instanceof QuanLi) {
					NhanVien sv = (NhanVien) arr[i];
					System.out.println(sv.TinhLuong());
				}
			}
		}
	}

	public void ghifile() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("Nhanvien.txt");
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
			fis = new FileInputStream("Nhanvien.txt");
			ois = new ObjectInputStream(fis);
			arr = (ConNguoi[]) ois.readObject();
			System.out.println("Đọc thành công danh sach nhan vien.");

		} catch (FileNotFoundException e) {
			System.out.println("Khong tìm thấy file !!");
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
