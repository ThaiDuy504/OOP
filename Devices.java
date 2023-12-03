package Net;

import java.util.Scanner;

public class Devices {
    Scanner sc = new Scanner(System.in);
    private NhaPhanPhoi nhaPhanPhoi;
    private String MaThietBi;
    private String TenThietBi;
    private String LoaiThietBi;
    private int BaoHanh;

    public Devices() {
    }

    public Devices(NhaPhanPhoi nhaPhanPhoi, String maThietBi, String tenThietBi, String loaiThietBi, int baoHanh) {
        this.nhaPhanPhoi = nhaPhanPhoi;
        MaThietBi = maThietBi;
        TenThietBi = tenThietBi;
        LoaiThietBi = loaiThietBi;
        BaoHanh = baoHanh;
    }

    public Devices(Devices a) {
        this.nhaPhanPhoi = a.nhaPhanPhoi;
        this.MaThietBi = a.MaThietBi;
        this.TenThietBi = a.TenThietBi;
        this.LoaiThietBi = a.LoaiThietBi;
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

    public void nhap() {
        nhaPhanPhoi.nhap();
        setMaThietBi();
        System.out.println("nhap vao ten thiet bi : ");
        TenThietBi = sc.nextLine();
        System.out.println("nhap vao loai thiet bi : ");
        LoaiThietBi = sc.nextLine();
        System.out.println("nhap vao thoi luong bao hanh : ");
        BaoHanh = sc.nextInt();
    }

    public void xuat() {
        System.out.println("ma nha phan phoi : " + nhaPhanPhoi.toString());
        System.out.println("ma thiet bi la : " + MaThietBi);
        System.out.println("ten thiet bi la : " + TenThietBi);
        System.out.println("loai thiet bi la : " + LoaiThietBi);
        System.out.println("thoi luong bao hanh la: " + BaoHanh);
    }

    @Override
    public String toString() {
        return "[Nha phan phoi= " + nhaPhanPhoi.toString() + ", Ma thiet bi= " + MaThietBi + ", Ten thiet bi= "
                + TenThietBi
                + ", Loai thiet bi = " + LoaiThietBi + ", Thoi gian bao hanh = " + BaoHanh + "]";
    }
}
