package Net;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class danhSachThietBi {
    private ArrayList<Devices> dsThietBi;

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
        System.out.println("Danh Sach Sinh Vien: ");
        for (Devices thietbi : dsThietBi) {
            System.out.println(thietbi);
        }
    }

    public Devices timKiemThietBi() {
        Devices ans = null;
        System.out.println("Nhap vao ma thiet bi can tim: ");
        Scanner sc = new Scanner(System.in);
        String mathietbi = sc.nextLine();
        for (Devices thietbi : dsThietBi) {
            if (thietbi.getMaThietBi().equalsIgnoreCase(mathietbi)) {
                ans = thietbi;
                break;
            }
        }
        return ans;
    }

    public void docfile() {
        FileInputStream fis = null;
        fis = new FileInputStream("D:\\dstb.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            dsThietBi = (ArrayList<Devices>) ois.readObject();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }

        for (Devices thietbi : dsThietBi) {
            System.out.println(thietbi);
        }
    }

    public void ghifile() {
        FileOutputStream fos = null;
        fos = new FileOutputStream("D:\\dstb.txt");
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(fos);
        try {
            oos.writeObject(dsThietBi);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } finally {
            fos.close();
            System.out.println("da ghi xong thiet bi");
        }
    }

}
