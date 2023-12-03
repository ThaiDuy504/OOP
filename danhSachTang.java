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

import Net.Tang;

public class danhSachTang {
    ArrayList<Tang> dsTang = new ArrayList<>();

    public danhSachTang() {
    }

    public danhSachTang(ArrayList<Tang> dsTang) {
        this.dsTang = dsTang;
    }

    public ArrayList<Tang> getDsTang() {
        return dsTang;
    }

    public void setDsTang(ArrayList<Tang> dsTang) {
        this.dsTang = dsTang;
    }

    public void nhapTang() {
        System.out.print("Nhap so luong tang can them");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0;
        while (i < n) {
            Tang t = new Tang();
            t.nhap();
            int flag = 1;
            for (Tang tang : dsTang) {
                if (tang.getMaTang().equals(t.getMaTang())) {
                    System.out.println("Ma tang da ton tai");
                    flag = 0;
                    break;
                }
            }
            i += flag;
            if (flag == 1)
                dsTang.add(t);
        }
    }

    public void themTang() {
        System.out.println("Nhap thong tin tang can them");
        Tang t = new Tang();
        while (true) {
            t.nhap();
            int flag = 0;
            for (Tang tang : dsTang) {
                if (tang.getMaTang().equals(t.getMaTang())) {
                    System.out.println("Ma tang da ton tai");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                dsTang.add(t);
                return;
            }
        }
    }

    public void timTang() {
        System.out.print("Nhap ma tang can tim: ");
        Scanner sc = new Scanner(System.in);
        String maTang = sc.nextLine();
        Tang t = timTang(maTang);
        if (t == null) {
            System.out.println("Khong tim thay tang");
            return;
        }
        System.out.println(t);
    }

    public Tang timTang(String maTang) {
        Tang ans = null;
        for (Tang t : dsTang) {
            if (t.getMaTang().equals(maTang)) {
                ans = t;
                break;
            }
        }
        return ans;
    }

    public void suaTang() {
        System.out.print("Nhap ma tang can sua: ");
        Scanner sc = new Scanner(System.in);
        String maTang = sc.nextLine();
        Tang tang = timTang(maTang);
        if (tang == null) {
            System.out.println("Khong tim thay tang");
            return;
        }
        System.out.print("Nhap thong tin sua: ");
        int index = dsTang.indexOf(tang);
        int flag = 1;
        Tang t = new Tang();
        t.setDsPhong(tang.getDsPhong());
        while (flag == 1) {
            t.nhap();
            if (timTang(t.getMaTang()) != null) {
                System.out.println("Ma tang da ton tai");
                continue;
            }
            flag = 0;
        }
        dsTang.set(index, t);
    }

    public void xoaTang() {
        System.out.print("Nhap ma tang can xoa: ");
        Scanner sc = new Scanner(System.in);
        String maTang = sc.nextLine();
        Tang tang = timTang(maTang);
        if (tang == null) {
            System.out.println("Khong tim thay tang");
            return;
        }
        dsTang.remove(tang);
    }

    public void setTinhTrangTang() {
        System.out.print("Nhap ma tang can xoa: ");
        Scanner sc = new Scanner(System.in);
        String maTang = sc.nextLine();
        Tang tang = timTang(maTang);
        if (tang == null) {
            System.out.println("Khong tim thay tang");
            return;
        }
        int index = dsTang.indexOf(tang);
        System.out.println("Lua chon tinh trang");
        System.out.println("1.Bao tri");
        System.out.println("2.Hoat dong");
        int choose = sc.nextInt();
        if (choose != 1 && choose != 2) {
            System.out.println("Lua chon khong hop le");
            return;
        }
        if (choose == 1)
            dsTang.get(index).setBaoTri();
        if (choose == 2)
            dsTang.get(index).setHoatDong();
    }

    public void quanLyTangChiTiet() {
        System.out.print("Nhap ma tang can quan ly: ");
        Scanner sc = new Scanner(System.in);
        String maTang = sc.nextLine();
        Tang tang = timTang(maTang);
        if (tang == null) {
            System.out.println("Khong tim thay tang");
            return;
        }
        int index = dsTang.indexOf(tang);
        dsTang.get(index).menu();
    }

    public void xuatdsTang() {
        dsTang.forEach(tang -> System.out.println(tang));
    }

    public void luachon() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--Menu-Tang--");
            System.out.println("1.Xuat danh sach tang");
            System.out.println("2.Nhap tang");
            System.out.println("3.Them 1 tang");
            System.out.println("4.Sua 1 tang");
            System.out.println("5.Tim tang");
            System.out.println("6.Set tinh trang tang");
            System.out.println("7.Xoa tang");
            System.out.println("8.quan ly tang chi tiet");
            System.out.println("9.Doc file danh sach tang");
            System.out.println("10.Ghi file danh sach tang");
            System.out.println("11.Thoat menu");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    xuatdsTang();
                    break;
                case 2:
                    nhapTang();
                    break;
                case 3:
                    themTang();
                    break;
                case 4:
                    suaTang();
                    break;
                case 5:
                    timTang();
                    break;
                case 6:
                    setTinhTrangTang();
                    break;
                case 7:
                    xoaTang();
                    break;
                case 8:
                    quanLyTangChiTiet();
                    break;
                case 9:
                    docfile();
                    break;
                case 10:
                    ghifile();
                    break;
                case 11:
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
            fis = new FileInputStream("D:\\dst.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(danhSachTang.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        try {
            dsTang = (ArrayList<Tang>) ois.readObject();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } finally {
            System.out.println("da doc xong file danh sach tang");
        }
    }

    public void ghifile() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\dst.txt");
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
            oos.writeObject(dsTang);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        try {
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachTang.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachTang.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("da ghi xong danh sach tang");
    }
}
