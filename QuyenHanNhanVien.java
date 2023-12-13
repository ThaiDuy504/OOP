package Net;

import java.net.ConnectException;
import java.util.Scanner;

import Net.ConNguoi;
import Net.DanhSachThucAn;
import Net.NhanVien;
import Net.PhucVu;
import Net.QuanLi;
import Net.TongHopDauVao;
import Net.danhSachBill;
import Net.danhSachBillChiTiet;
import Net.danhSachPhieuNhap;
import Net.danhSachPhieuNhapChiTiet;
import Net.danhSachThietBi;

public class QuyenHanNhanVien extends QuyenHan implements IChucNangNhanVien {
    Scanner sc = new Scanner(System.in);

    public QuyenHanNhanVien() {
        setLoaiQuyenHan("NV");
    }

    public void xemChucNang(TongHopDauVao tongHopDauVao) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--Menu--");
            System.out.println("1.Xem thong tin tai khoan");
            System.out.println("2.Sua mat khau");
            System.out.println("3.xem luong");
            System.out.println("4.quan ly Bill");
            System.out.println("5.quan ly Bill chi tiet");
            System.out.println("6.quan ly Phieu Nhap");
            System.out.println("7.quan ly Phieu Nhap chi tiet");
            System.out.println("8.quan ly thuc an");
            System.out.println("9.quan ly co so ha tang");
            System.out.println("10.Thoat menu");
            switch (sc.nextInt()) {
                case 1:
                    xemthongtin(tongHopDauVao.getConNguoi());
                    break;
                case 2:
                    suaMatKhau(tongHopDauVao.getConNguoi());
                    break;
                case 3:
                    xemLuong(tongHopDauVao.getConNguoi());
                    break;
                case 4:
                    quanlyBill(tongHopDauVao.getDsBill(), tongHopDauVao.getDsBillChiTiet(),
                            tongHopDauVao.getDsThucAn());
                    break;
                case 5:
                    quanlyBillChiTiet(tongHopDauVao.getDsBillChiTiet());
                    break;
                case 6:
                    quanlyPhieuNhap(tongHopDauVao.getDsPhieuNhap(), tongHopDauVao.getDsPhieuNhapChiTiet(),
                            tongHopDauVao.getDsThietBi(), tongHopDauVao.getDsThucAn());
                    break;
                case 7:
                    quanlyPhieuNhapChiTiet(tongHopDauVao.getDsPhieuNhapChiTiet());
                    break;
                case 8:
                    quanlyThucAn(tongHopDauVao.getDsThucAn());
                    break;
                case 9:
                    quanlyCoSoHaTang(tongHopDauVao.getDsTang());
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        }

    }

    public void xemthongtin(ConNguoi conNguoi) {
        NhanVien nv = (NhanVien) conNguoi;
        nv.xuat();
    };

    public void suaMatKhau(ConNguoi conNguoi) {
        NhanVien nv = (NhanVien) conNguoi;
        String matkhaucuu = nv.getTaiKhoan().getMatkhau();
        Scanner sc = new Scanner(System.in);
        nv.getTaiKhoan().nhapMatKhau(matkhaucuu);
    };

    public void xemLuong(ConNguoi conNguoi) {
        NhanVien nv = (NhanVien) conNguoi;
        if (nv instanceof QuanLi) {
            QuanLi ql = (QuanLi) nv;
            System.out.println(ql.TinhLuong());
            return;
        }
        if (nv instanceof PhucVu) {
            PhucVu pv = (PhucVu) nv;
            System.out.println(pv.TinhLuong());
        }
    };

    public void quanlyBill(danhSachBill dsbill, danhSachBillChiTiet dsBillChiTiet, DanhSachThucAn dsThucAn) {
        dsbill.luachon(dsBillChiTiet, dsThucAn);
    };

    public void quanlyBillChiTiet(danhSachBillChiTiet dsBillChiTiet) {
        dsBillChiTiet.luachon();
    };

    public void quanlyPhieuNhap(danhSachPhieuNhap dsPhieuNhap, danhSachPhieuNhapChiTiet dsPhieuNhapChiTiet,
            danhSachThietBi dsThietBi, DanhSachThucAn dsThucAn) {
        dsPhieuNhap.luachon(dsPhieuNhapChiTiet, dsThietBi, dsThucAn);
    };

    public void quanlyPhieuNhapChiTiet(danhSachPhieuNhapChiTiet dsPhieuNhapChiTiet) {
        dsPhieuNhapChiTiet.luachon();
    };

    public void quanlyThucAn(DanhSachThucAn dsThucAn) {
        dsThucAn.menu();
    };

    public void quanlyCoSoHaTang(danhSachTang dsTang) {
        dsTang.luachon();
    };
}