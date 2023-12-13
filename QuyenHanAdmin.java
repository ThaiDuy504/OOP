package Net;

import java.util.Scanner;

import Net.DanhSachConNguoi;

public class QuyenHanAdmin extends QuyenHan implements IChucNangAdmin {
    public QuyenHanAdmin() {
        setLoaiQuyenHan("ADM");
    }

    public void xemChucNang(DanhSachConNguoi dsConNguoi) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---Menu---");
            System.out.println("1.Quan ly danh sach tai khoan");
            System.out.println("2.Thoat menu");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    dsConNguoi.luachon();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        }
    }

    public void quanLyTaiKhoan(DanhSachConNguoi dsConNguoi) {
        dsConNguoi.luachon();
    }

}
