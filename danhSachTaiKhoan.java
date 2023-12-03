package Net;

import java.util.Vector;

import Net.TaiKhoan;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class danhSachTaiKhoan {
    private Vector<TaiKhoan> dsTaiKhoan = new Vector<>();

    public danhSachTaiKhoan() {
        dsTaiKhoan = new Vector<TaiKhoan>();
    }

    public danhSachTaiKhoan(Vector<TaiKhoan> dsTaiKhoan) {
        this.dsTaiKhoan = dsTaiKhoan;
    }

    public void xuatTaiKhoan() {
        for (int i = 0; i < dsTaiKhoan.size(); ++i) {
            dsTaiKhoan.get(i).xuat();
        }
    }

    public void themTaiKhoan() {
        System.out.println("Nhap so luong tai khoan can tao: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            TaiKhoan temp = new TaiKhoan();
            boolean validate = true;
            while (validate) {
                temp.nhap();
                for (TaiKhoan tk : dsTaiKhoan) {
                    if (tk.getTendangnhap() == temp.getTendangnhap()) {
                        System.out.println("Tai khoan da ton tai");
                        break;
                    } else {
                        dsTaiKhoan.add(temp);
                        validate = false;
                    }
                }
            }
        }
    }

    public void themTaiKhoan(TaiKhoan taikhoan) {
        dsTaiKhoan.add(taikhoan);
    }

    public TaiKhoan timTaiKhoan(String tendangnhap) {
        for (TaiKhoan tk : dsTaiKhoan) {
            if (tk.getTendangnhap().equals(tendangnhap))
                return tk;
        }
        return null;
    }

    public int xoaTaiKhoan(String tendangnhap) {
        TaiKhoan temp = timTaiKhoan(tendangnhap);
        if (temp == null) {
            System.out.println("Tai khoan khong ton tai");
            return -1;
        }
        dsTaiKhoan.remove(temp);
        return 1;
    }

    public void docfile() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(".\\dstk.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(danhSachTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        try {
            dsTaiKhoan = (Vector<TaiKhoan>) ois.readObject();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } finally {
            System.out.println("da doc xong danh sach tai khoan");
        }

    }

    public void ghifile() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(".\\dstk.txt");
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
            oos.writeObject(dsTaiKhoan);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        try {
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(danhSachTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("da ghi xong danh sach tai khoan");
    }
}
