package quan_li_quan_net;
import java.util.Scanner;
public class PhieuNhapThucAn {
	protected int maPhieuNhap;
   	private int donGia;
   	private DanhSachThucAn dsTA;
   	Scanner sc = new Scanner(System.in);
   
   	public PhieuNhapThucAn () {
   	}
   	
   	public PhieuNhapThucAn (int maPhieuNhap, int donGia, DanhSachThucAn dsTA) {
		this.maPhieuNhap = maPhieuNhap;
		this.donGia = donGia;
		this.dsTA = dsTA;
   }

	public int getMaPhieuNhap() {
		return maPhieuNhap;
	}

	public void setMaPhieuNhap(int maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	public int getDonGia() {
		return donGia;
	}
	
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public DanhSachThucAn getDsTA() {
		return dsTA;
	}

	public void setDsTA(DanhSachThucAn dsTA) {
		this.dsTA = dsTA;
	}
	public void nhap() {
	    System.out.print("Nhập mã phiếu nhập:");
	    setMaPhieuNhap(sc.nextInt());
	    System.out.print("Nhập đơn giá:");
	    setDonGia(sc.nextInt());
	    dsTA.nhapdsThucAn();
	}

	public void xuat() {
        System.out.println("Mã Phiếu Nhập: "+getMaPhieuNhap());
        System.out.println("Đơn Giá: "+getDonGia());
        System.out.println("Danh sách thức ăn: ");
        dsTA.xuatdsThucAn();
        System.out.println("----------------------------");
	}



	@Override
	public String toString() {
		return "PhieuNhapThucAn  [maPhieuNhap=" + maPhieuNhap + ", donGia=" + donGia + "]";
	}
	
}
