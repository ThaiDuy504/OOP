package Net;

import Net.ConNguoi;
import Net.danhSachBill;
import Net.danhSachBillChiTiet;
import Net.danhSachPhieuNhap;
import Net.danhSachPhieuNhapChiTiet;

public class TongHopDauVao {
    private ConNguoi conNguoi;
    private danhSachBill dsBill;
    private danhSachBillChiTiet dsBillChiTiet;
    private danhSachPhieuNhap dsPhieuNhap;
    private danhSachPhieuNhapChiTiet dsPhieuNhapChiTiet;
    private DanhSachThucAn dsThucAn;
    private danhSachTang dsTang;

    public TongHopDauVao() {

    }

    public TongHopDauVao(ConNguoi conNguoi) {
        this.conNguoi = conNguoi;
    }

    public ConNguoi getConNguoi() {
        return conNguoi;
    }

    public void setConNguoi(ConNguoi conNguoi) {
        this.conNguoi = conNguoi;
    }

    public danhSachBill getDsBill() {
        return dsBill;
    }

    public void setDsBill(danhSachBill dsBill) {
        this.dsBill = dsBill;
    }

    public danhSachBillChiTiet getDsBillChiTiet() {
        return dsBillChiTiet;
    }

    public void setDsBillChiTiet(danhSachBillChiTiet dsBillChiTiet) {
        this.dsBillChiTiet = dsBillChiTiet;
    }

    public danhSachPhieuNhap getDsPhieuNhap() {
        return dsPhieuNhap;
    }

    public void setDsPhieuNhap(danhSachPhieuNhap dsPhieuNhap) {
        this.dsPhieuNhap = dsPhieuNhap;
    }

    public danhSachPhieuNhapChiTiet getDsPhieuNhapChiTiet() {
        return dsPhieuNhapChiTiet;
    }

    public void setDsPhieuNhapChiTiet(danhSachPhieuNhapChiTiet dsPhieuNhapChiTiet) {
        this.dsPhieuNhapChiTiet = dsPhieuNhapChiTiet;
    }

    public DanhSachThucAn getDsThucAn() {
        return dsThucAn;
    }

    public void setDsThucAn(DanhSachThucAn dsThucAn) {
        this.dsThucAn = dsThucAn;
    }

    public danhSachTang getDsTang() {
        return dsTang;
    }

    public void setDsTang(danhSachTang dsTang) {
        this.dsTang = dsTang;
    }

}
