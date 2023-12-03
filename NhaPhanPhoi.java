package Net;

import java.util.Scanner;

public class NhaPhanPhoi {
    private String maNhaPhanPhoi;
    private String tenNhaPhanPhoi;
    private Scanner sc = new Scanner(System.in);

    public NhaPhanPhoi() {
    }

    public NhaPhanPhoi(String maNhaPhanPhoi, String tenNhaPhanPhoi) {
        this.maNhaPhanPhoi = maNhaPhanPhoi;
        this.tenNhaPhanPhoi = tenNhaPhanPhoi;
    }

    public String getMaNhaPhanPhoi() {
        return maNhaPhanPhoi;
    }

    public void setMaNhaPhanPhoi(String maNhaPhanPhoi) {
        this.maNhaPhanPhoi = maNhaPhanPhoi;
    }

    public void setMaNhaPhanPhoi() {
        String maNhaPhanPhoi;
        while (true) {
            System.out.print("Nhap ma nha phan phoi: ");
            maNhaPhanPhoi = sc.nextLine();
            if (checkLoi.checkNhaPhanPhoi(maNhaPhanPhoi) == false) {
                System.out.println("Nhap ma nha phan phoi sai cu phap NPP + 1 den 2 ky tu so");
            } else
                break;

        }
        setMaNhaPhanPhoi(maNhaPhanPhoi);
    }

    public String getTenNhaPhanPhoi() {
        return tenNhaPhanPhoi;
    }

    public void setTenNhaPhanPhoi() {
        String tenNhaPhanPHoi;
        while (true) {
            System.out.print("Nhap ma nha phan phoi: ");
            tenNhaPhanPHoi = sc.nextLine();
            if (checkLoi.checkTen(tenNhaPhanPHoi) == false) {
                System.out.println("Ten nha phan phoi khong duoc bat dau bang khoang trang va khong co ky tu dac biet");
            } else
                break;
        }
        setTenNhaPhanPhoi(tenNhaPhanPHoi);
    }

    public void setTenNhaPhanPhoi(String tenNhaPhanPhoi) {
        this.tenNhaPhanPhoi = tenNhaPhanPhoi;
    }

    public void nhap() {
        setMaNhaPhanPhoi();
        setTenNhaPhanPhoi();
    }

    public void xuat() {
        System.out.println("Thong tin nha phan phoi: ");
        System.out.println("Ma nha phan phoi: " + maNhaPhanPhoi);
        System.out.println("Ten nha phan phoi: " + tenNhaPhanPhoi);
    }

    @Override
    public String toString() {
        return "[Ma nha phan phoi: " + maNhaPhanPhoi + ", Ten nha phan phoi: " + tenNhaPhanPhoi + "]";
    }

}
