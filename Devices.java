package Net;

import java.util.Scanner;

public class Devices {
    Scanner sc = new Scanner(System.in);
    private NhaPhanPhoi nhaPhanPhoi = new NhaPhanPhoi();
    private String MaThietBi;
    private String TenThietBi;
    private String LoaiThietBi;
    private int soluong;
    private double donGia;
    private int BaoHanh;

    public Devices() {
    }

    public Devices(NhaPhanPhoi nhaPhanPhoi, String maThietBi, String tenThietBi, String loaiThietBi, int soluong,
            double donGia, int baoHanh) {
        this.nhaPhanPhoi = nhaPhanPhoi;
        this.MaThietBi = maThietBi;
        this.TenThietBi = tenThietBi;
        this.LoaiThietBi = loaiThietBi;
        this.soluong = soluong;
        this.donGia = donGia;
        this.BaoHanh = baoHanh;
    }

    public Devices(Devices a) {
        this.nhaPhanPhoi = a.nhaPhanPhoi;
        this.MaThietBi = a.MaThietBi;
        this.TenThietBi = a.TenThietBi;
        this.LoaiThietBi = a.LoaiThietBi;
        this.soluong = a.soluong;
        this.donGia = a.donGia;
        this.BaoHanh = a.BaoHanh;
    }

    public NhaPhanPhoi getNhaPhanPhoi() {
        return nhaPhanPhoi;
    }

    public void setNhaPhanPhoi(NhaPhanPhoi nhaPhanPhoi) {
        this.nhaPhanPhoi = nhaPhanPhoi;
    }

    public String getMaThietBi() {
        return MaThietBi;
    }

    public void setMaThietBi() {
        String maThietBi;
        while (true) {
            System.out.print("Nhap ma thiet bi: ");
            maThietBi = sc.nextLine();
            if (checkLoi.checkMaThietBi(maThietBi) == false) {
                System.out.println("Nhap ma thiet bi sai cu phap TB + 3 ky tu so tro len");
            } else
                break;

        }
        setMaThietBi(maThietBi);
    }

    public void setMaThietBi(String maThietBi) {
        MaThietBi = maThietBi;
    }

    public String getTenThietBi() {
        return TenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        TenThietBi = tenThietBi;
    }

    public String getLoaiThietBi() {
        return LoaiThietBi;
    }

    public void setLoaiThietBi(String loaiThietBi) {
        LoaiThietBi = loaiThietBi;
    }

    public int getBaoHanh() {
        return BaoHanh;
    }

    public void setBaoHanh(int baoHanh) {
        BaoHanh = baoHanh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong() {
        System.out.println("Nhap so luong: ");
        Scanner sc = new Scanner(System.in);
        int soluong = sc.nextInt();
        while (soluong <= 0) {
            System.out.println("So luong khong hop le moi nhap lai: ");
            soluong = sc.nextInt();
        }
        setSoluong(soluong);
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = Math.max(0, donGia);
    }

    public void nhap() {
        nhaPhanPhoi.nhap();
        setMaThietBi();
        System.out.println("nhap vao ten thiet bi : ");
        TenThietBi = sc.nextLine();
        System.out.println("nhap vao loai thiet bi : ");
        LoaiThietBi = sc.nextLine();
        System.out.println("nhap vao thoi luong bao hanh : ");
        BaoHanh = sc.nextInt();
        setSoluong();
        System.out.print("Nhap don gia: ");
        setDonGia(sc.nextDouble());
    }

    public void nhap(String identify) {
        nhaPhanPhoi.nhap();
        System.out.println("nhap vao ten thiet bi : ");
        TenThietBi = sc.nextLine();
        System.out.println("nhap vao loai thiet bi : ");
        LoaiThietBi = sc.nextLine();
        System.out.println("nhap vao thoi luong bao hanh : ");
        BaoHanh = sc.nextInt();
        setSoluong();
        System.out.print("Nhap don gia: ");
        setDonGia(sc.nextDouble());
    }

    public void xuat() {
        System.out.println("ma nha phan phoi : " + nhaPhanPhoi.toString());
        System.out.println("ma thiet bi la : " + MaThietBi);
        System.out.println("ten thiet bi la : " + TenThietBi);
        System.out.println("loai thiet bi la : " + LoaiThietBi);
        System.out.println("thoi luong bao hanh la: " + BaoHanh);
        System.out.println("So luong: " + soluong);
        System.out.println("Don gia: " + donGia);
    }

    @Override
    public String toString() {
        return "[Nha phan phoi= " + nhaPhanPhoi.toString() + ", Ma thiet bi= " + MaThietBi + ", Ten thiet bi= "
                + TenThietBi
                + ", Loai thiet bi = " + LoaiThietBi + ", So luong: " + soluong + ",Don gia: " + donGia
                + ", Thoi gian bao hanh = " + BaoHanh
                + "]";
    }
}
