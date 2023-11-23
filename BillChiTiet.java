package Net;

public class BillChiTiet extends Bill{
    public int maKhachHang;
    public String ngayXuat;
    public double donGia;
    public BillChiTiet(){
    }
    
	
	public BillChiTiet(int maBill, int soGioChoi, DanhSachThucAn dsTA,int maKhachHang,String ngayXuat,double donGia) {
		super(maBill, soGioChoi,dsTA);
		this.maKhachHang=maKhachHang;
		this.ngayXuat=ngayXuat;
		this.donGia=donGia;
	}


	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public int getMaBill() {
		return maBill;
	}
	public void setMaBill(int maBill) {
		this.maBill = maBill;
	}
	public String getNgayXuat() {
		return ngayXuat;
	}
	public void setNgayXuat(String ngayXuat) {
		this.ngayXuat = ngayXuat;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public void nhap() {
        super.nhap();
        System.out.print("Nhập mã khách hàng: ");
        setMaKhachHang(sc.nextInt());

        System.out.print("Nhập ngày xuất: ");
        setNgayXuat(sc.next());

        System.out.print("Nhập đơn giá: ");
        setDonGia(sc.nextDouble());
    }
	public void xuat() {
		super.xuat();
        System.out.println("Mã khách hàng: "+getMaKhachHang());
        System.out.println("Ngày xuất: "+getNgayXuat());
        System.out.println("Đơn giá: "+getDonGia());
        System.out.println("----------------------------");
	}


	@Override
	public String toString() {
		return "BillChiTiet [maKhachHang=" + maKhachHang + ", ngayXuat=" + ngayXuat + ", donGia=" + donGia + "]";
	}
	
}
