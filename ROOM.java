package Net;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class ROOM {
    Scanner sc = new Scanner(System.in);
    private int maTang;
    private static int maPhong = 0;
    private Boolean status;
    private String state;
    danhSachThietBi dsThietBi;

    public ROOM() {
        maPhong++;
    }

    public ROOM(int maTang) {
        this.maTang = maTang;
        maPhong++;
    }

    public int getMaTang() {
        return maTang;
    }

    public void setMaTang(int maTang) {
        this.maTang = maTang;
    }

    public static int getMaPhong() {
        return maPhong;
    }

    public static void setMaPhong(int maPhong) {
        ROOM.maPhong = maPhong;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public danhSachThietBi getDsThietBi() {
        return dsThietBi;
    }

    public void setDsThietBi(danhSachThietBi dsThietBi) {
        this.dsThietBi = dsThietBi;
    }

    public static void setmaphong(int maphong) {
        maPhong = maphong;
    }

    public static int maphong() {
        return maPhong;
    }

    public void setTrangThai(boolean trangthai) {
        this.status = trangthai;
    }

    public void nhap() {
        System.out.print("Nhap ma tang: ");
        maTang = sc.nextInt();
    }

    public void xuat() {
        if (status == true) {
            state = "Chua dat";
        }
        System.out.print(maTang + "." + maPhong + "." + state + " ");
        display_devices();
    }

    public void display_devices() {
        for (int i = 0; i < 3; i++) {
            dsThietBi.xuatdsThietBi();
        }
    }
}
