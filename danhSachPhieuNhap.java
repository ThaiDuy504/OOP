package Net;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import Net.PhieuNhapThucAn;
import Net.danhSachPhieuNhapChiTiet;

public class danhSachPhieuNhap {
    ArrayList<PhieuNhapThucAn> dsPhieuNhap = new ArrayList<>();

    public danhSachPhieuNhap() {
        dsPhieuNhap = new ArrayList<>();
    }

    public danhSachPhieuNhap(ArrayList<PhieuNhapThucAn> dsPhieuNhap) {
        this.dsPhieuNhap = dsPhieuNhap;
    }

    public ArrayList<PhieuNhapThucAn> getDsPhieuNhap() {
        return dsPhieuNhap;
    }

    public void setDsPhieuNhap(ArrayList<PhieuNhapThucAn> dsPhieuNhap) {
        this.dsPhieuNhap = dsPhieuNhap;
    }

    public void nhapPhieuNhap(danhSachPhieuNhapChiTiet dsPhieuNhapChiTiet, boolean nhapThucAn) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Nhập mã phiếu nhập: ");
        String maPhieuNhap = scanner.nextLine();
    
        System.out.println("Nhập ngày nhập (dd/mm/yyyy): ");
        String ngayNhap = scanner.nextLine();
    
        System.out.println("Nhập số lượng: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); 
    
        // Kiểm tra lựa chọn nhập thức ăn hay thiết bị
        if (nhapThucAn) {
            System.out.println("Nhập mã thức ăn: ");
            String maThucAn = scanner.nextLine();
    
            // Kiểm tra xem thức ăn đã tồn tại trong danh sách chưa
            boolean daTonTai = dsPhieuNhapChiTiet.kiemTraTonTaiThucAn(maThucAn);
    
            if (daTonTai) {
                dsPhieuNhapChiTiet.capNhatSoLuongThucAn(maThucAn, soLuong);
            } else {
                ThucAn thucAn = new ThucAn(maThucAn);
                dsPhieuNhapChiTiet.themThucAn(thucAn);
                dsPhieuNhapChiTiet.capNhatSoLuongThucAn(maThucAn, soLuong);
            }
        } else {
            System.out.println("Nhập mã thiết bị: ");
            String maThietBi = scanner.nextLine();
    
            // Kiểm tra xem thiết bị đã tồn tại trong danh sách chưa
            boolean daTonTai = dsPhieuNhapChiTiet.kiemTraTonTaiThietBi(maThietBi);
    
            if (daTonTai) {
                dsPhieuNhapChiTiet.capNhatSoLuongThietBi(maThietBi, soLuong);
            } else {
                ThietBi thietBi = new ThietBi(maThietBi);
                dsPhieuNhapChiTiet.themThietBi(thietBi);
                dsPhieuNhapChiTiet.capNhatSoLuongThietBi(maThietBi, soLuong);
            }
        }
    
        PhieuNhapThucAn phieuNhap = new PhieuNhapThucAn(maPhieuNhap, ngayNhap, soLuong);
        dsPhieuNhap.add(phieuNhap);
    
        System.out.println("Phiếu nhập đã được thêm vào danh sách.");
    }

    public void themPhieuNhap(danhSachPhieuNhapChiTiet dsPhieuNhapChiTiet) {
        PhieuNhapThucAn phieunhap = new PhieuNhapThucAn();
        phieunhap.nhap();
        double tongTien = dsPhieuNhapChiTiet.nhapPhieuNhapChiTiet(phieunhap.getMaPhieuNhap(), phieunhap.getNgayNhap());
        dsPhieuNhap.add(phieunhap);
    }

    public void timPhieuNhap() {
        System.out.println("Nhap ma phieu nhap can tim: ");
        Scanner sc = new Scanner(System.in);
        String maPHieuNhap = sc.nextLine();
        PhieuNhapThucAn ans = timPhieuNhap(maPHieuNhap);
        if (ans == null) {
            System.out.println("Khong tim thay phieu nhap");
            return;
        } else
            System.out.println(ans);
    }

    public PhieuNhapThucAn timPhieuNhap(String maphieu) {
        PhieuNhapThucAn ans = null;
        for (PhieuNhapThucAn phieunhap : dsPhieuNhap) {
            if (phieunhap.getMaPhieuNhap().equals(maphieu)) {
                ans = phieunhap;
                break;
            }
        }
        return ans;
    }

    public void huyPhieuNhap() {
        System.out.print("Nhap ma phieu can huy: ");
        Scanner sc = new Scanner(System.in);
        String maphieu = sc.nextLine();
        PhieuNhapThucAn phieunhap = timPhieuNhap(maphieu);
        if (phieunhap == null) {
            System.out.println("KHong tim thay phieu nhap");
            return;
        }
        System.out.println("Da huy phieu " + maphieu);
        phieunhap.huyPhieuNhap();
    }

    public void xuatDanhSachPhieuNhap() {
        System.out.println("danh sach phieu nhap: ");
        dsPhieuNhap.forEach(phieunhap -> System.out.println(phieunhap));
    }

    public void luachon(danhSachPhieuNhapChiTiet dsPhieuNhapChiTiet) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--Menu-phieu-nhap--");
            System.out.println("1.Nhap phieu nhap moi");
            System.out.println("2.Them 1 phieu nhap moi");
            System.out.println("3.Tim phieu nhap");
            System.out.println("4.Huy phieu nhap");
            System.out.println("5.Xuat danh sach phieu nhap");
            System.out.println("6.Doc file danh sach phieu nhap");
            System.out.println("7.Ghi file danh sach phieu nhap");
            System.out.println("8.Thoat menu");
            switch (sc.nextInt()) {
                case 1:
                    nhapPhieuNhap(dsPhieuNhapChiTiet);
                    break;
                case 2:
                    themPhieuNhap(dsPhieuNhapChiTiet);
                    break;
                case 3:
                    timPhieuNhap();
                    break;
                case 4:
                    huyPhieuNhap();
                case 5:
                    xuatDanhSachPhieuNhap();
                    break;
                case 6:
                    docfile();
                    break;
                case 7:
                    ghifile();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        }
    }

    public void docfile() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\dspn.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(danhSachPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        try {
            dsPhieuNhap = (ArrayList<PhieuNhapThucAn>) ois.readObject();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }

        System.out.println("da doc danh sach phieu nhap thanh cong");
    }

    public void ghifile() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\dspn.txt");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        try {
            oos.writeObject(dsPhieuNhap);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        try {
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("da ghi danh sach phieu nhap thanh cong");
    }
}
