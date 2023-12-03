package Net;

/**
 * IChucNangNhanVien
 */
public interface IChucNangNhanVien extends IChucNangKhachHang {
    public void xemLuong(ConNguoi conNguoi);

    public void quanlyBill(danhSachBill dsbill, danhSachBillChiTiet dsBillChiTiet);

    public void quanlyBillChiTiet(danhSachBillChiTiet dsBillChiTiet);

    public void quanlyPhieuNhap(danhSachPhieuNhap dsPhieuNhap, danhSachPhieuNhapChiTiet dsPhieuNhapChiTiet);

    public void quanlyPhieuNhapChiTiet(danhSachPhieuNhapChiTiet dsPhieuNhapChiTiet);

    public void quanlyThucAn(DanhSachThucAn dsThucAn);

    public void quanlyCoSoHaTang(danhSachTang dsTang);
}