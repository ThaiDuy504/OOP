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

public class danhSachThietBi {
    private ArrayList<Devices> dsThietBi = new ArrayList<>();

    public danhSachThietBi() {
        dsThietBi = new ArrayList<>();
    }

    public danhSachThietBi(ArrayList<Devices> dsThietBi) {
        this.dsThietBi = dsThietBi;
    }

    public ArrayList<Devices> getDsThietBi() {
        return dsThietBi;
    }

    public void setDsThietBi(ArrayList<Devices> dsThietBi) {
        this.dsThietBi = dsThietBi;
    }

    public int getDsThietBiLength() {
        return dsThietBi.size();
    }

    public void nhapThietBi() {
        int soluong;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong thiet bi can them: ");
        soluong = sc.nextInt();
        for (int i = 0; i < soluong; ++i) {
            System.out.println("Nhap thiet bi thu " + (i + 1) + ": ");
            Devices thietbi = new Devices();
            thietbi.nhap();
            dsThietBi.add(thietbi);
        }
    }

    public void themThietBi() {
        System.out.println("Nhap thong tin thiet bi: ");
        Devices thietbi = new Devices();
        thietbi.nhap();
        dsThietBi.add(thietbi);
    }

    public void xuatdsThietBi() {
        System.out.println("Danh Sach thiet bi: ");
        for (Devices thietbi : dsThietBi) {
            System.out.println(thietbi);
        }
    }

    public void xoaThietBi() {
        System.out.print("Nhap ma thiet bi can xoa");
        Scanner sc = new Scanner(System.in);
        String maThietBi = sc.nextLine();
        Devices ans = timKiemThietBi(maThietBi);
        if (ans == null) {
            System.out.println("Khong tim thay thiet bi");
            return;
        }
        dsThietBi.remove(ans);
    }

    public void timKiemThietBi() {
        Devices ans = null;
        System.out.println("Nhap vao ma thiet bi can tim: ");
        Scanner sc = new Scanner(System.in);
        String mathietbi = sc.nextLine();
        ans = timKiemThietBi(mathietbi);
        if (ans != null)
            ans.xuat();
        else {
            System.out.println("Khong tim thay thiet bi");
        }
    }

    public Devices timKiemThietBi(String mathietbi) {
        Devices ans = null;
        for (Devices thietbi : dsThietBi) {
            if (thietbi.getMaThietBi().equalsIgnoreCase(mathietbi)) {
                ans = thietbi;
                break;
            }
        }
        return ans;
    }

    public void luachon(String maPhong) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--Menu-Thiet-Bi--");
            System.out.println("1.Xuat danh sach thiet bi");
            System.out.println("2.Nhap thiet bi");
            System.out.println("3.Them 1 thiet bi");
            System.out.println("4.Tim thiet bi");
            System.out.println("5.Xoa thiet bi");
            System.out.println("6.Doc file danh sach thiet bi");
            System.out.println("7.Ghi file danh sach thiet bi");
            System.out.println("8.Thoat menu");
            switch (sc.nextInt()) {
                case 1:
                    xuatdsThietBi();
                    break;
                case 2:
                    nhapThietBi();
                    break;
                case 3:
                    themThietBi();
                    break;
                case 4:
                    timKiemThietBi();
                    break;
                case 5:
                    xoaThietBi();
                    break;
                case 6:
                    docfile(maPhong);
                    break;
                case 7:
                    ghifile(maPhong);
                case 8:
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        }
    }

    public void docfile(String maPhong) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\dstb" + maPhong + ".txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(danhSachThietBi.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        try {
            dsThietBi = (ArrayList<Devices>) ois.readObject();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } finally {
            System.out.println("da doc xong file danh sach thiet bi");
        }
    }

    public void ghifile(String maPhong) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\dstb" + maPhong + ".txt");
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
            oos.writeObject(dsThietBi);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        try {
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachThietBi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachThietBi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("da ghi xong danh sach thiet bi");
    }

}
