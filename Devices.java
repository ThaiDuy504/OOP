package Net;

import java.util.Scanner;

public class Devices {
    Scanner sc = new Scanner(System.in);
    public String maNhaPhanPhoi;
    public String MaThietBi;
    public String TenThietBi;
    public String LoaiThietBi;
    public int BaoHanh;

    public Devices() {
    }

    public Devices(String MNPP, String MTB, String TTB, String LTB, int BH) {
        this.maNhaPhanPhoi = MNPP;
        this.MaThietBi = MTB;
        this.TenThietBi = TTB;
        this.LoaiThietBi = LTB;
        this.BaoHanh = BH;
    }

    public Devices(Devices a) {
        this.maNhaPhanPhoi = a.maNhaPhanPhoi;
        this.MaThietBi = a.MaThietBi;
        this.TenThietBi = a.TenThietBi;
        this.LoaiThietBi = a.LoaiThietBi;
        this.BaoHanh = a.BaoHanh;
    }

    public String getMaNhaPhanPhoi() {
        return maNhaPhanPhoi;
    }

    public void setMaNhaPhanPhoi(String maNhaPhanPhoi) {
        this.maNhaPhanPhoi = maNhaPhanPhoi;
    }

    public String getMaThietBi() {
        return MaThietBi;
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
        System.out.println("nhap vao ma nha phan phoi : ");
        maNhaPhanPhoi = sc.nextLine();
        System.out.println("nhap vao ma thiet bi : ");
        MaThietBi = sc.nextLine();
        System.out.println("nhap vao ten thiet bi : ");
        TenThietBi = sc.nextLine();
        System.out.println("nhap vao loai thiet bi : ");
        LoaiThietBi = sc.nextLine();
        System.out.println("nhap vao thoi luong bao hanh : ");
        BaoHanh = sc.nextInt();
    }

    public void xuat() {
        System.out.println("ma nha phan phoi la: " + maNhaPhanPhoi);
        System.out.println("ma thiet bi la : " + MaThietBi);
        System.out.println("ten thiet bi la : " + TenThietBi);
        System.out.println("loai thiet bi la : " + LoaiThietBi);
        System.out.println("thoi luong bao hanh la: " + BaoHanh);
    }

    @Override
    public String toString() {
        return "[Ma nha phan phoi= " + maNhaPhanPhoi + ", Ma thiet bi= " + MaThietBi + ", Ten thiet bi= " + TenThietBi
                + ", Loai thiet bi = " + LoaiThietBi + ", Thoi gian bao hanh = " + BaoHanh + "]";
    }
}
