package Net;

import java.util.ArrayList;
import java.util.Scanner;

import Net.DanhSachThucAn;
import Net.danhSachBillChiTiet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class danhSachBill {
    private ArrayList<Bill> dsBill = new ArrayList<>();

    public danhSachBill() {
        dsBill = new ArrayList<>();
    }

    public danhSachBill(ArrayList<Bill> dsBill) {
        this.dsBill = dsBill;
    }

    public ArrayList<Bill> getDsBill() {
        return dsBill;
    }

    public void setDsBill(ArrayList<Bill> dsBill) {
        this.dsBill = dsBill;
    }

    public void nhapBill(danhSachBillChiTiet dsBillChiTiet, DanhSachThucAn dsThucAn) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong bill can nhap: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            System.out.println("Nhap bill thu " + (i + 1) + ":");
            Bill newBill = new Bill();
            double tongTienThucAn = dsBillChiTiet.NhapBillChiTiet(newBill.getMaBill(), newBill.getNgayLap(), dsThucAn);
            newBill.setTongTienThucAn(tongTienThucAn);
            newBill.nhap();
            dsBill.add(newBill);
        }
    }

    public void themBill(danhSachBillChiTiet dsBillChiTiet, DanhSachThucAn dsThucAn) {
        Bill newBill = new Bill();
        double tongTienThucAn = dsBillChiTiet.NhapBillChiTiet(newBill.getMaBill(), newBill.getNgayLap(), dsThucAn);
        newBill.setTongTienThucAn(tongTienThucAn);
        newBill.nhap();
        dsBill.add(newBill);
    }

    public void timBill() {
        Scanner sc = new Scanner(System.in);
        String mabill = sc.nextLine();
        for (Bill bill : dsBill) {
            if (bill.getMaBill().equals(mabill)) {
                System.out.println(bill);
                return;
            }
        }
        System.out.println("Khong tim thay ma bill");
    }

    public Bill timBill(String maBill) {
        Bill ans = null;

        for (Bill bill : dsBill) {
            if (bill.getMaBill().equals(maBill)) {
                ans = bill;
                break;
            }
        }
        return ans;
    }

    public void huyBill() {
        System.out.print("Nhap ma bill can huy");
        Scanner sc = new Scanner(System.in);
        String mabill = sc.nextLine();
        Bill bill = timBill(mabill);
        if (bill == null) {
            System.out.println("Khong tim thay ma bill");
            return;
        }
        System.out.println("Da huy bill" + mabill);
        bill.huyBill();
    }

    public void xuatDanhSachBill() {
        System.out.println("danh sach bill: ");
        dsBill.forEach((bill) -> System.out.println(bill));
    }

    public void luachon(danhSachBillChiTiet dsBillChiTiet, DanhSachThucAn dsThucAn) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--Menu-Bill--");
            System.out.println("1.Nhap bill moi");
            System.out.println("2.Them 1 bill moi");
            System.out.println("3.Tim bill");
            System.out.println("4.Huy bill");
            System.out.println("5.Xuat danh sach bill");
            System.out.println("6.Doc file danh sach bill");
            System.out.println("7.Ghi file danh sach bill");
            System.out.println("8.Thoat menu");
            switch (sc.nextInt()) {
                case 1:
                    nhapBill(dsBillChiTiet, dsThucAn);
                    break;
                case 2:
                    themBill(dsBillChiTiet, dsThucAn);
                    break;
                case 3:
                    timBill();
                    break;
                case 4:
                    huyBill();
                case 5:
                    xuatDanhSachBill();
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
            fis = new FileInputStream(".\\dsb.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(danhSachBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        try {
            dsBill = (ArrayList<Bill>) ois.readObject();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }

        for (Bill bill : dsBill) {
            System.out.println(bill);
        }
    }

    public void ghifile() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(".\\dsb.txt");
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
            oos.writeObject(dsBill);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        try {
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}