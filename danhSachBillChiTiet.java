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
import Net.ThucAn;

public class danhSachBillChiTiet {
    private ArrayList<BillChiTiet> dsBillChiTiet = new ArrayList<>();

    public danhSachBillChiTiet() {
        dsBillChiTiet = new ArrayList<>();
    }

    public danhSachBillChiTiet(ArrayList<BillChiTiet> dsBillChiTiet) {
        this.dsBillChiTiet = dsBillChiTiet;
    }

    public ArrayList<BillChiTiet> getDsBillChiTiet() {
        return dsBillChiTiet;
    }

    public void setDsBillChiTiet(ArrayList<BillChiTiet> dsBillChiTiet) {
        this.dsBillChiTiet = dsBillChiTiet;
    }

    public double NhapBillChiTiet(String maBill, String ngayXuat, DanhSachThucAn dsThucAn) {
        int i = 0;
        double tongTien = 0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            BillChiTiet bill = new BillChiTiet(maBill, ngayXuat);
            System.out.print("Nhap bill chi tiet so " + (++i) + ": ");
            ThucAn thucAn = new ThucAn();
            thucAn.setMaThucAn();
            ThucAn ans = dsThucAn.timkiemThucAn(thucAn.getMaThucAn());
            while (ans == null) {
                System.out.println("Khong tim thay ma thuc an,moi nhap lai ");
                thucAn.setMaThucAn();
                ans = dsThucAn.timkiemThucAn(thucAn.getMaThucAn());
            }
            thucAn.setSoluong();
            while (ans.getSoluong() - thucAn.getSoluong() < 0) {
                System.out.println("Khong du thuc an yeu cau moi nhap lai: ");
                thucAn.setSoluong();
            }
            ans.setSoluong(ans.getSoluong() - thucAn.getSoluong());
            thucAn.setDonGia(ans.getDonGia());
            thucAn.setTheLoai(ans.getTheLoai());
            thucAn.setTenThucAn(ans.getTenThucAn());
            bill.setThucAn(thucAn);
            tongTien += bill.getDonGia();
            dsBillChiTiet.add(bill);
            System.out.print("Ban co muon nhap tiep(0/1)? ");
            int choose = scan.nextInt();
            if (choose == 0)
                return tongTien;
            System.out.println();
        }
    }

    public double themBillChiTiet(String maBill, String ngayXuat) {
        BillChiTiet billChiTiet = new BillChiTiet(maBill, ngayXuat);
        System.out.println("Nhap bill chi tiet");
        billChiTiet.nhap();
        dsBillChiTiet.add(billChiTiet);
        return billChiTiet.getDonGia();
    }

    public danhSachBillChiTiet timBillChiTiet() {
        System.out.print("Nhap ma bill: ");
        danhSachBillChiTiet dsbill = new danhSachBillChiTiet();
        Scanner sc = new Scanner(System.in);
        String mabill = sc.nextLine();
        for (BillChiTiet bill : dsBillChiTiet) {
            if (bill.getMaBill().equals(mabill))
                dsbill.getDsBillChiTiet().add(bill);
        }
        return dsbill;
    }

    public void xuatDanhSachBillChiTiet() {
        dsBillChiTiet.forEach(bill -> System.out.println(bill));
    }

    public void luachon() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--Menu-Bill-Chi-Tiet--");
            System.out.println("1.Xuat danh sach bill chi tiet");
            System.out.println("2.Tim bill chi tiet");
            System.out.println("3.Doc file danh sach bill");
            System.out.println("4.Ghi file danh sach bill");
            System.out.println("5.Thoat menu");
            switch (sc.nextInt()) {
                case 1:
                    xuatDanhSachBillChiTiet();
                    break;
                case 2:
                    timBillChiTiet().xuatDanhSachBillChiTiet();
                    break;
                case 3:
                    docfile();
                    break;
                case 4:
                    ghifile();
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
            fis = new FileInputStream("D:\\dsbct.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(danhSachBillChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        try {
            dsBillChiTiet = (ArrayList<BillChiTiet>) ois.readObject();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } finally {
            System.out.println("da doc xong danh sach bill chi tiet");
        }

    }

    public void ghifile() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\dsbct.txt");
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
            oos.writeObject(dsBillChiTiet);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        try {
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachBillChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachBillChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("da ghi xong danh sach bill chi tiet");
    }

}
