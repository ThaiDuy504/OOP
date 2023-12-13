package Net;

import java.util.Scanner;

import Net.DanhSachConNguoi;
import Net.DanhSachThucAn;
import Net.KhachHang;
import Net.QuanLi;
import Net.QuyenHanAdmin;
import Net.QuyenHanNhanVien;
import Net.TaiKhoan;
import Net.TongHopDauVao;
import Net.danhSachPhieuNhap;
import Net.danhSachPhieuNhapChiTiet;
import Net.danhSachThietBi;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        DanhSachConNguoi dsConNguoi = new DanhSachConNguoi();
        danhSachBill dsBill = new danhSachBill();
        danhSachBillChiTiet dsBillChiTiet = new danhSachBillChiTiet();
        danhSachPhieuNhap dsPhieuNhap = new danhSachPhieuNhap();
        danhSachPhieuNhapChiTiet dsPhieuNhapcChiTiet = new danhSachPhieuNhapChiTiet();
        DanhSachThucAn dsThucAn = new DanhSachThucAn();
        danhSachThietBi dsThietBi = new danhSachThietBi();
        danhSachTang dsTang = new danhSachTang();
        ConNguoi conNguoi = null;
        TaiKhoan tknv = new TaiKhoan("thaideptrai", "12345678", "30/08/2002", "OPEN", new QuyenHanNhanVien());
        ConNguoi nhanvien = new QuanLi("NV0000", "TEO", "vo gia cu", "29/02/2000", "0", tknv, 3000);
        System.out.println(nhanvien);
        while (true) {
            System.out.println("1.Dang nhap");
            System.out.println("2.Thoat chuong chinh");
            int choose = sc.nextInt();
            sc.nextLine();
            if (choose == 1) {
                System.out.println("---Login---");
                System.out.print("Nhap ten dang nhap: ");
                String ten = sc.nextLine();
                System.out.print("Nhap mat khau: ");
                String matkhau = sc.nextLine();
                if (ten.equals("admin") && matkhau.equals("admin")) {
                    QuyenHanAdmin quyenHan = new QuyenHanAdmin();
                    quyenHan.xemChucNang(dsConNguoi);
                    continue;
                }
                if (dsConNguoi.timKiemTheoTaiKhoan(ten, matkhau) != null
                        || (ten.equals(nhanvien.getTaiKhoan().getTendangnhap())
                                && matkhau.equals(nhanvien.getTaiKhoan().getMatkhau()))) {
                    conNguoi = dsConNguoi.timKiemTheoTaiKhoan(ten, matkhau);
                    if (conNguoi == null)
                        conNguoi = nhanvien;
                    if (conNguoi instanceof NhanVien) {
                        TongHopDauVao tongHopDauVao = new TongHopDauVao();
                        tongHopDauVao.setConNguoi(conNguoi);
                        tongHopDauVao.setDsBill(dsBill);
                        tongHopDauVao.setDsBillChiTiet(dsBillChiTiet);
                        tongHopDauVao.setDsPhieuNhap(dsPhieuNhap);
                        tongHopDauVao.setDsPhieuNhapChiTiet(dsPhieuNhapcChiTiet);
                        tongHopDauVao.setDsThucAn(dsThucAn);
                        tongHopDauVao.setDsTang(dsTang);
                        tongHopDauVao.setDsThietBi(dsThietBi);
                        conNguoi.getTaiKhoan().getQuyenhan().xemChucNang(tongHopDauVao);
                        continue;
                    }
                    if (conNguoi instanceof KhachHang) {
                        conNguoi.getTaiKhoan().getQuyenhan().xemChucNang(conNguoi);
                        continue;
                    }
                }
                System.out.println("khong tim thay tai khoan");
            }
            if (choose == 2) {
                return;
            } else {
                System.out.println("Lua chon khong hop le");
            }
        }

    }
}
