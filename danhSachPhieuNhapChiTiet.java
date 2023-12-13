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

import Net.DanhSachThucAn;
import Net.Devices;
import Net.PhieuNhapThietBiChiTiet;
import Net.PhieuNhapThucAnChiTiet;
import Net.ThucAn;
import Net.danhSachThietBi;

public class danhSachPhieuNhapChiTiet {
    ArrayList<PhieuNhapChiTiet> dsPhieuNhapChiTiet = new ArrayList<>();

    public danhSachPhieuNhapChiTiet() {
        dsPhieuNhapChiTiet = new ArrayList<>();
    }

    public danhSachPhieuNhapChiTiet(ArrayList<PhieuNhapChiTiet> dsPhieuNhapChiTiet) {
        this.dsPhieuNhapChiTiet = dsPhieuNhapChiTiet;
    }

    public ArrayList<PhieuNhapChiTiet> getDsPhieuNhapChiTiet() {
        return dsPhieuNhapChiTiet;
    }

    public void setDsPhieuNhapChiTiet(ArrayList<PhieuNhapChiTiet> dsPhieuNhapChiTiet) {
        this.dsPhieuNhapChiTiet = dsPhieuNhapChiTiet;
    }

    public void capNhatSoLuongThucAn(String maThucAn, int soLuong, DanhSachThucAn dsThucAn) {
        for (ThucAn thucAn : dsThucAn.getDsThucAn()) {
            if (thucAn.getMaThucAn().equals(maThucAn)) {
                thucAn.setSoluong(thucAn.getSoluong() + soLuong);
                return;
            }
        }
    }

    public void capNhatSoLuongThietBi(String maThietBi, int soLuong, danhSachThietBi dsThietBi) {
        for (Devices thietBi : dsThietBi.getDsThietBi()) {
            if (thietBi.getMaThietBi().equals(maThietBi)) {
                thietBi.setSoluong(thietBi.getSoluong() + soLuong);
                return;
            }
        }
    }

    public double nhapPhieuNhapChiTiet(String maPhieuNhap, String ngayXuat, danhSachThietBi dsThietbi,
            DanhSachThucAn dsThucAn) {
        int i = 0;
        double tongTien = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhap lua chon: ");
            System.out.println("1. Thiet bi");
            System.out.println("2. Thuc an");
            int choose = sc.nextInt();
            if (choose == 1) {
                PhieuNhapThietBiChiTiet phieunhap = new PhieuNhapThietBiChiTiet(maPhieuNhap, ngayXuat);
                System.out.println("Nhap phieu nhap chi tiet so " + (++i) + ": ");
                Devices thietbi = new Devices();
                thietbi.setMaThietBi();
                Devices ans = dsThietbi.timKiemThietBi(thietbi.getMaThietBi());
                if (ans != null) {
                    thietbi.setDonGia(ans.getDonGia());
                    thietbi.setSoluong();
                    capNhatSoLuongThietBi(thietbi.getMaThietBi(), thietbi.getSoluong(), dsThietbi);
                } else {
                    thietbi.nhap("");
                    dsThietbi.getDsThietBi().add(thietbi);
                }
                phieunhap.setThietbi(thietbi);
                tongTien += phieunhap.getTongTien();
                dsPhieuNhapChiTiet.add(phieunhap);
            } else if (choose == 2) {
                PhieuNhapThucAnChiTiet phieunhap = new PhieuNhapThucAnChiTiet(maPhieuNhap, ngayXuat);
                System.out.println("Nhap phieu nhap chi tiet so " + (++i) + ": ");
                ThucAn thucAn = new ThucAn();
                thucAn.setMaThucAn();
                ThucAn ans = dsThucAn.timkiemThucAn(thucAn.getMaThucAn());
                if (ans != null) {
                    thucAn.setDonGia(ans.getDonGia());
                    thucAn.setSoluong();
                    capNhatSoLuongThucAn(ans.getMaThucAn(), thucAn.getSoluong(), dsThucAn);
                } else {
                    thucAn.nhap("");
                    dsThucAn.add(thucAn);
                }
                phieunhap.setThucAn(thucAn);
                tongTien += phieunhap.getTongTien();
                dsPhieuNhapChiTiet.add(phieunhap);
            } else {
                System.out.println("Lua chon khong hop le");
                continue;
            }
            System.out.print("Ban co muon nhap tiep(0/1): ");
            if (sc.nextInt() == 0) {
                break;
            }
            System.out.println();
        }
        return tongTien;
    }

    public double themPhieuNhapChiTiet(String maPhieuNhap, String ngayXuat, danhSachThietBi dsThietbi,
            DanhSachThucAn dsThucAn) {
        Scanner sc = new Scanner(System.in);
        int tongTien = 0;
        System.out.println("Nhap lua chon: ");
        System.out.println("1. Thiet bi");
        System.out.println("2. Thuc an");
        int choose = sc.nextInt();
        if (choose == 1) {
            PhieuNhapThietBiChiTiet phieunhap = new PhieuNhapThietBiChiTiet(maPhieuNhap, ngayXuat);
            System.out.println("Nhap phieu nhap chi tiet: ");
            Devices thietbi = new Devices();
            thietbi.setMaThietBi();
            Devices ans = dsThietbi.timKiemThietBi(thietbi.getMaThietBi());
            if (ans != null) {
                thietbi.setDonGia(ans.getDonGia());
                thietbi.setSoluong();
                capNhatSoLuongThietBi(thietbi.getMaThietBi(), thietbi.getSoluong(), dsThietbi);
            } else {
                thietbi.nhap("");
                dsThietbi.getDsThietBi().add(thietbi);
            }
            phieunhap.setThietbi(thietbi);
            tongTien += phieunhap.getTongTien();
            dsPhieuNhapChiTiet.add(phieunhap);
        } else if (choose == 2) {
            PhieuNhapThucAnChiTiet phieunhap = new PhieuNhapThucAnChiTiet(maPhieuNhap, ngayXuat);
            System.out.println("Nhap phieu nhap chi tiet so : ");
            ThucAn thucAn = new ThucAn();
            thucAn.setMaThucAn();
            ThucAn ans = dsThucAn.timkiemThucAn(thucAn.getMaThucAn());
            if (ans != null) {
                thucAn.setDonGia(ans.getDonGia());
                thucAn.setSoluong();
                capNhatSoLuongThucAn(ans.getMaThucAn(), thucAn.getSoluong(), dsThucAn);
            } else {
                thucAn.nhap("");
                dsThucAn.add(thucAn);
            }
            phieunhap.setThucAn(thucAn);
            tongTien += phieunhap.getTongTien();
            dsPhieuNhapChiTiet.add(phieunhap);
        } else {
            System.out.println("Lua chon khong hop le");
        }
        return tongTien;
    }

    public danhSachPhieuNhapChiTiet timDanhSachPhieuNhapChiTiet() {
        System.out.print("Nhap ma phieu nhap: ");
        danhSachPhieuNhapChiTiet dsPhieuNhap = new danhSachPhieuNhapChiTiet();
        Scanner sc = new Scanner(System.in);
        String maPhieu = sc.nextLine();
        for (PhieuNhapChiTiet phieunhap : dsPhieuNhapChiTiet) {
            if (phieunhap.getMaPhieuNhap().equals(maPhieu))
                dsPhieuNhap.getDsPhieuNhapChiTiet().add(phieunhap);
        }
        return dsPhieuNhap;
    }

    public void xuatDanhSachPhieuNhapChiTiet() {
        System.out.println("danh sach phieu nhap chi tiet");
        dsPhieuNhapChiTiet.forEach(phieunhap -> System.out.println(phieunhap));
    }

    public void luachon() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--Menu-Phieu-Nhap-Chi-Tiet--");
            System.out.println("1.Xuat danh sach phieu nhap chi tiet");
            System.out.println("2.Tim phieu nhap chi tiet");
            System.out.println("3.Doc file danh sach phieu nhap chi tiet");
            System.out.println("4.Ghi file danh sach phieu nhap chi tiet");
            System.out.println("5.Thoat menu");
            switch (sc.nextInt()) {
                case 1:
                    xuatDanhSachPhieuNhapChiTiet();
                    break;
                case 2:
                    timDanhSachPhieuNhapChiTiet().xuatDanhSachPhieuNhapChiTiet();
                    break;
                case 3:
                    docfile();
                    break;
                case 4:
                    ghifile();
                    break;
                case 5:
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
            fis = new FileInputStream("D:\\dspnct.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(danhSachPhieuNhapChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        try {
            dsPhieuNhapChiTiet = (ArrayList<PhieuNhapChiTiet>) ois.readObject();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } finally {
            System.out.println("da doc xong danh sach phieu nhap chi tiet");
        }

    }

    public void ghifile() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\dspnct.txt");
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
            oos.writeObject(dsPhieuNhapChiTiet);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        try {
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachPhieuNhapChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachPhieuNhapChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("da ghi xong danh sach phieu nhap chi tiet");
    }
}
