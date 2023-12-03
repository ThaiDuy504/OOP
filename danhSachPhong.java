package Net;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import Net.ROOM;

import java.util.Arrays;

public class danhSachPhong {
    private ROOM[] dsPhong = new ROOM[1000];
    private int soluong;
    Scanner sc = new Scanner(System.in);

    public danhSachPhong() {
        dsPhong = new ROOM[1000];
    }

    public danhSachPhong(ROOM[] dsPhong, int soluong) {
        this.dsPhong = dsPhong;
        this.soluong = soluong;
    }

    public ROOM[] getDsPhong() {
        return dsPhong;
    }

    public void setDsPhong(ROOM[] dsPhong) {
        this.dsPhong = dsPhong;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void nhapPhong() {
        System.out.print("Nhap so luong phong can them");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n + soluong > dsPhong.length)
            dsPhong = Arrays.copyOf(dsPhong, n + soluong);
        int i = 0;
        while (i < n) {
            System.out.println("Nhap thong tin phong thu " + (i + 1) + ":");
            ROOM r = new ROOM();
            r.nhap();
            int flag = 0;
            for (int j = 0; j < soluong + i; ++j) {
                if (dsPhong[j].getMaPhong().equals(r.getMaPhong())) {
                    System.out.println("Ma phong da ton tai");
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                continue;
            dsPhong[soluong++] = r;
        }
    }

    public void themPhong() {
        ROOM r = new ROOM();
        while (true) {
            System.out.println("Nhap thong tin phong can them: ");
            r.nhap();
            int flag = 0;
            for (int j = 0; j < soluong; ++j) {
                if (dsPhong[j].getMaPhong().equals(r.getMaPhong())) {
                    System.out.println("Ma phong da ton tai");
                    break;
                }
            }
            if (flag == 1)
                continue;
            dsPhong[soluong++] = r;
            break;
        }
    }

    public void timPhong() {
        System.out.print("Nhap ma phong can tim: ");
        Scanner sc = new Scanner(System.in);
        String maPhong = sc.nextLine();
        int i = timPhong(maPhong);
        if (i != -1) {
            System.out.println(dsPhong[i]);
            return;
        }
        System.out.println("Khong tim thay phong");
    }

    public int timPhong(String maPhong) {
        int ans = -1;
        for (int i = 0; i < soluong; ++i) {
            if (dsPhong[i].getMaPhong().equals(maPhong)) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public void suaPhong() {
        System.out.print("Nhap ma phong can sua: ");
        Scanner sc = new Scanner(System.in);
        String maPhong = sc.nextLine();
        int i = timPhong(maPhong);
        if (i == -1) {
            System.out.println("Khong tim thay phong ");
            return;
        }
        System.out.println("Nhap ma phong moi: ");
        ROOM temp = new ROOM();
        int flag = 1;
        while (flag == 1) {
            temp.nhap();
            for (int j = 0; j < soluong; ++j) {
                if (dsPhong[j].getMaPhong().equals(temp.getMaPhong())) {
                    System.out.println("Ma phong da ton tai");
                    continue;
                }
                flag = 0;
            }
        }
        dsPhong[i].nhap();
    }

    public void xoaPhong() {
        System.out.print("Nhap ma phong can xoa: ");
        Scanner sc = new Scanner(System.in);
        String maPhong = sc.nextLine();
        int i = timPhong(maPhong);
        if (i == -1) {
            System.out.println("Khong tim thay phong ");
            return;
        }
        for (int j = i; j < soluong - 1; ++j) {
            dsPhong[j] = dsPhong[j + 1];
        }
        dsPhong = Arrays.copyOf(dsPhong, --soluong);
    }

    public void setTinhTrangPhong() {
        System.out.print("Nhap ma phong can chinh tinh trang: ");
        Scanner sc = new Scanner(System.in);
        String maPhong = sc.nextLine();
        int i = timPhong(maPhong);
        if (i == -1) {
            System.out.println("Khong tim thay phong ");
            return;
        }
        System.out.println("Nhap tinh trang can chinh: ");
        System.out.println("1. Bao tri");
        System.out.println("2.  Hoat dong");
        int choose = sc.nextInt();
        if (choose != 1 && choose != 2) {
            System.out.println("Lua chon khong hop le");
            return;
        }
        if (choose == 1)
            dsPhong[i].setBaoTri();
        if (choose == 2)
            dsPhong[i].setHoatDong();
    }

    public void quanLyPhongChiTiet() {
        System.out.print("Nhap ma phong can quan ly: ");
        Scanner sc = new Scanner(System.in);
        String maPhong = sc.nextLine();
        int i = timPhong(maPhong);
        if (i == -1) {
            System.out.println("Khong tim thay phong ");
            return;
        }
        dsPhong[i].menu();
    }

    public void xuatdsPhong() {
        System.out.println("Danh sach phong :");
        for (int i = 0; i < soluong; ++i) {
            System.out.println(dsPhong[i]);
        }
    }

    public void luachon(String maTang) {
        while (true) {
            System.out.println("--Menu-Phong--");
            System.out.println("1.Xuat danh sach phong");
            System.out.println("2.Nhap phong");
            System.out.println("3.Them 1 phong");
            System.out.println("4.Sua 1 phong");
            System.out.println("5.Tim phong");
            System.out.println("6.Set tinh trang phong");
            System.out.println("7.Xoa phong");
            System.out.println("8.quan ly phong chi tiet");
            System.out.println("9.Doc file danh sach phong");
            System.out.println("10.Ghi file danh sach phong");
            System.out.println("11.Thoat menu");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    xuatdsPhong();
                    break;
                case 2:
                    nhapPhong();
                    break;
                case 3:
                    themPhong();
                    break;
                case 4:
                    suaPhong();
                    break;
                case 5:
                    timPhong();
                    break;
                case 6:
                    setTinhTrangPhong();
                    break;
                case 7:
                    xoaPhong();
                    break;
                case 8:
                    quanLyPhongChiTiet();
                    break;
                case 9:
                    docfile(maTang);
                    break;
                case 10:
                    ghifile(maTang);
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        }
    }

    public void docfile(String maTang) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\dsp" + maTang + ".txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(danhSachPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        try {
            dsPhong = (ROOM[]) ois.readObject();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } finally {
            System.out.println("da doc xong file danh sach phong");
        }
    }

    public void ghifile(String maTang) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\dsp" + maTang + ".txt");
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
            oos.writeObject(dsPhong);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        try {
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("da ghi xong danh sach phong");
    }

}
