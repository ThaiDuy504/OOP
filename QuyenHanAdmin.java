package Net;

import java.util.Scanner;

public class QuyenHanAdmin extends QuyenHan implements IChucNangAdmin {
    public QuyenHanAdmin() {
        setLoaiQuyenHan("ADM");
    }

    public void xemChucNang(DanhSachKhachHang dsKhachHang, DanhSachNhanVien dsNhanVien) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---Menu---");
            System.out.println("1.Quan Ly Khach Hang");
            System.out.println("2.Quan Ly Nhan Vien");
            System.out.println("3.Thoat menu");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    quanLyKhachHang(dsKhachHang);
                    break;
                case 2:
                    quanLyNhanVien(dsNhanVien);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        }
    }

    public void quanLyKhachHang(DanhSachKhachHang dsKhachHang) {
        dsKhachHang.luachon();
    };

    public void quanLyNhanVien(DanhSachNhanVien dsNhanVien) {
        dsNhanVien.luachon();
    };

}
