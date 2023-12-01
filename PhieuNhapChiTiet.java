package Net;

public class PhieuNhapChiTiet extends PhieuNhapThucAn {
	public String nhaPhanPhoi;
	public String ngayNhap;

	public PhieuNhapChiTiet() {
	}

	public PhieuNhapChiTiet(int maPhieuNhap, int donGia, DanhSachThucAn dsTA, String nhaPhanPhoi, String ngayNhap) {
		super(maPhieuNhap, donGia, dsTA);
		this.nhaPhanPhoi = nhaPhanPhoi;
		this.ngayNhap = ngayNhap;
	}

	public String getNhaPhanPhoi() {
		return nhaPhanPhoi;
	}

	public void setNhaPhanPhoi(String nhaPhanPhoi) {
		this.nhaPhanPhoi = nhaPhanPhoi;
	}

	public int getMaPhieuNhap() {
		return maPhieuNhap;
	}

	public void setMaPhieuNhap(int maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public void nhap() {
		super.nhap();
		System.out.print("Nhập Nhà Phân Phối: ");
		setNhaPhanPhoi(sc.nextInt());

		System.out.print("Nhập ngày nhập: ");
		setNgayXuat(sc.next());

		System.out.print("Nhập đơn giá: ");
		setDonGia(sc.nextDouble());
	}

	public void xuat() {
		super.xuat();
		System.out.println("Nhà Phân Phối: " + getNhaPhanPhoi());
		System.out.println("Ngày Nhập: " + getNgayNhap());
		System.out.println("Đơn giá: " + getDonGia());
		System.out.println("----------------------------");
	}

	@Override
	public String toString() {
		return "PhieuNhapChiTiet [nhaPhanPhoi=" + nhaPhanPhoi + ", ngayNhap=" + ngayNhap + ", donGia=" + donGia + "]";
	}
