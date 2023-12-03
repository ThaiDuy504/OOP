package Net;

import java.util.Scanner;

public class QuyenHanKhachHang extends QuyenHan implements IChucNangKhachHang {

    public QuyenHanKhachHang() {
        setLoaiQuyenHan("KH");
    }

    public void xemChucNang(ConNguoi conNguoi) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--Menu--");
            System.out.println("1.Xem thong tin tai khoan");
            System.out.println("2.Sua mat khau");
            System.out.println("3.Thoat menu");
            switch (sc.nextInt()) {
                case 1:
                    xemthongtin(conNguoi);
                    break;
                case 2:
                    suaMatKhau(conNguoi);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("lua chon khong hop le");
                    break;
            }
        }
    }

    public void xemthongtin(ConNguoi conNguoi) {
        KhachHang kh = (KhachHang) conNguoi;
        kh.xuat();
    };

    public void suaMatKhau(ConNguoi conNguoi) {
        KhachHang kh = (KhachHang) conNguoi;
        String matkhaucuu = kh.getTaiKhoan().getMatkhau();
        Scanner sc = new Scanner(System.in);
        kh.getTaiKhoan().nhapMatKhau(matkhaucuu);
    };
}