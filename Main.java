package Net;

import java.util.Scanner;

import Net.DanhSachThucAn;
import Net.TongHopDauVao;
import Net.danhSachPhieuNhap;
import Net.danhSachPhieuNhapChiTiet;

public class Main {
    public static void main(String args[]) throws Exception {
        DanhSachKhachHang dsKhachHang = new DanhSachKhachHang();
        DanhSachNhanVien dsNhanVien = new DanhSachNhanVien();
        Scanner sc = new Scanner(System.in);
        danhSachBill dsBill = new danhSachBill();
        danhSachBillChiTiet dsBillChiTiet = new danhSachBillChiTiet();
        danhSachPhieuNhap dsPhieuNhap = new danhSachPhieuNhap();
        danhSachPhieuNhapChiTiet dsPhieuNhapcChiTiet = new danhSachPhieuNhapChiTiet();
        DanhSachThucAn dsThucAn = new DanhSachThucAn();
        danhSachTang dsTang = new danhSachTang();
        QuyenHan quyenHan;
        ConNguoi conNguoi = null;
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
                    quyenHan = new QuyenHanAdmin();
                    quyenHan.xemChucNang(dsKhachHang, dsNhanVien);
                    continue;
                }
                if (dsKhachHang.timKiemTheoTaiKhoan(ten, matkhau) != null) {
                    if (conNguoi == null)
                        conNguoi = new ConNguoi();
                    conNguoi = dsKhachHang.timKiemTheoTaiKhoan(ten, matkhau);
                    conNguoi.getTaiKhoan().getQuyenhan().xemChucNang(conNguoi);
                    continue;
                }

                if (dsNhanVien.timKiemTheoTaiKhoan(ten, matkhau) != null) {
                    conNguoi = dsNhanVien.timKiemTheoTaiKhoan(ten, matkhau);
                    TongHopDauVao tongHopDauVao = new TongHopDauVao();
                    tongHopDauVao.setConNguoi(conNguoi);
                    tongHopDauVao.setDsBill(dsBill);
                    tongHopDauVao.setDsBillChiTiet(dsBillChiTiet);
                    tongHopDauVao.setDsPhieuNhap(dsPhieuNhap);
                    tongHopDauVao.setDsPhieuNhapChiTiet(dsPhieuNhapcChiTiet);
                    tongHopDauVao.setDsThucAn(dsThucAn);
                    tongHopDauVao.setDsTang(dsTang);
                    conNguoi.getTaiKhoan().getQuyenhan().xemChucNang(tongHopDauVao);
                    continue;
                }

                System.out.println("khong tim thay tai khoan");
            }
            if (choose == 2) {
                return;
            }
        }

    }
}
