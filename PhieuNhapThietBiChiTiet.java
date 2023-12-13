
package Net;

public class PhieuNhapThietBiChiTiet extends PhieuNhapChiTiet {
    Devices thietbi;

    public PhieuNhapThietBiChiTiet() {

    }

    public PhieuNhapThietBiChiTiet(String maPhieuNhap, String ngayNhap) {
        super(maPhieuNhap, ngayNhap);
    }

    public PhieuNhapThietBiChiTiet(Devices thietbi) {
        this.thietbi = thietbi;
    }

    public Devices getThietbi() {
        return thietbi;
    }

    public void setThietbi(Devices thietbi) {
        this.thietbi = thietbi;
    }

    public void nhap() {
        System.out.println("Nhap thiet bi:");
        thietbi.nhap();
    }

    public double getTongTien() {
        return thietbi.getDonGia() * thietbi.getSoluong();
    }

    public void xuat() {
        super.xuat();
        thietbi.xuat();
    }

    @Override
    public String toString() {
        return "[Ma phieu: " + getMaPhieuNhap() + ", Ngay nhap: " + getNgayNhap() + ",Thiet bi : " + thietbi + "]";
    };
}