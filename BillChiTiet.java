package Net;

public class BillChiTiet {
	private String maBill;
	private String ngayXuat;
	private int soluong;
	private ThucAn thucAn;

	public BillChiTiet() {
		maBill = "";
		ngayXuat = "";
		soluong = 0;
		thucAn = null;
	}

	public BillChiTiet(int maBill, String ngayXuat, int soluong, ThucAn thucAn) {
		this.maBill = maBill;
		this.ngayXuat = ngayXuat;
		this.soluong = soluong;
		this.thucAn = thucAn;
	}

	public String getMaBill() {
		return maBill;
	}

	public void setMaBill(String maBill) {
		this.maBill = maBill;
	}

	public String getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(String ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public ThucAn getThucAn() {
		return thucAn;
	}

	public void setThucAn(ThucAn thucAn) {
		this.thucAn = thucAn;
	}

	public double getDonGia() {
		return soluong * thucAn.getDonGia();
	}

	public void nhap() {
		System.out.print("Nhập mã Bill: ");
		setMaBill(maBill);

		System.out.print("Nhập ngày xuất: ");
		setNgayXuat(sc.next());

		System.out.print("Nhap thuc an: ");
		thucAn.nhap();
		System.out.print("Nhap so luong: ");
		sc.nextInt(soluong);
	}

	public void xuat() {
		System.out.println("Mã khách hàng: " + getMaKhachHang());
		System.out.println("Ngày xuất: " + getNgayXuat());
		System.out.println("Đơn giá: " + getDonGia());
		System.out.println("----------------------------");
	}

	@Override
	public String toString() {
		return "BillChiTiet [maKhachHang=" + maKhachHang + ", ngayXuat=" + ngayXuat + ", donGia=" + getDonGia() + "]";
	}

}
