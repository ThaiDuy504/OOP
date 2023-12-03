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

    public double nhapPhieuNhapChiTiet(String maPhieuNhap, String ngayXuat) {
        int i = 0;
        double tongTien = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            PhieuNhapChiTiet phieunhap = new PhieuNhapChiTiet(maPhieuNhap, ngayXuat);
            System.out.println("Nhap phieu nhap chi tiet so " + (++i) + ": ");
            phieunhap.nhap();
            tongTien += phieunhap.getDonGia();
            dsPhieuNhapChiTiet.add(phieunhap);
            System.out.print("Ban co muon nhap tiep(0/1): ");
            if (sc.nextInt() == 0) {
                break;
            }
            System.out.println();
        }
        return tongTien;
    }

    public double themPhieuNhapChiTiet(String maPhieuNhap, String ngayXuat) {
        PhieuNhapChiTiet phieunhap = new PhieuNhapChiTiet(maPhieuNhap, ngayXuat);
        System.out.println("Nhap phieu nhap chi tiet ");
        phieunhap.nhap();
        dsPhieuNhapChiTiet.add(phieunhap);
        return phieunhap.getDonGia();
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
