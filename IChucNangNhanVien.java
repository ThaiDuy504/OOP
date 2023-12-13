package Net;

import Net.DanhSachThucAn;
import Net.danhSachThietBi;

public interface IChucNangNhanVien extends IChucNangKhachHang {
    public void xemLuong(ConNguoi conNguoi);

    public void quanlyBill(danhSachBill dsbill, danhSachBillChiTiet dsBillChiTiet, DanhSachThucAn dsThucAn);

    public void quanlyBillChiTiet(danhSachBillChiTiet dsBillChiTiet);

    public void quanlyPhieuNhap(danhSachPhieuNhap dsPhieuNhap, danhSachPhieuNhapChiTiet dsPhieuNhapChiTiet,
            danhSachThietBi dsThietBi, DanhSachThucAn dsThucAn);

    public void quanlyPhieuNhapChiTiet(danhSachPhieuNhapChiTiet dsPhieuNhapChiTiet);

    public void quanlyThucAn(DanhSachThucAn dsThucAn);

    public void quanlyCoSoHaTang(danhSachTang dsTang);
}