package Net;

import java.util.*;

public class Bill{
	protected int maBill;
   	private int soGioChoi;
   	private DanhSachThucAn dsTA;
   	Scanner sc = new Scanner(System.in);
   
   	public Bill() {
   	}
   	
   	public Bill(int maBill, int soGioChoi, DanhSachThucAn dsTA) {
		this.maBill = maBill;
		this.soGioChoi = soGioChoi;
		this.dsTA = dsTA;
   }

	public int getMaBill() {
		return maBill;
	}

	public void setMaBill(int maBill) {
		this.maBill = maBill;
	}

	public int getSoGioChoi() {
		return soGioChoi;
	}
	
	public void setSoGioChoi(int soGioChoi) {
		this.soGioChoi = soGioChoi;
	}

	public DanhSachThucAn getDsTA() {
		return dsTA;
	}

	public void setDsTA(DanhSachThucAn dsTA) {
		this.dsTA = dsTA;
	}
	public void nhap() {
	    System.out.print("Nhập mã bill:");
	    setMaBill(sc.nextInt());
	    System.out.print("Nhập số giờ chơi:");
	    setSoGioChoi(sc.nextInt());
	    dsTA.nhapdsThucAn();
	}

	public void xuat() {
        System.out.println("Mã bill: "+getMaBill());
        System.out.println("So gio choi: "+getSoGioChoi());
        System.out.println("Danh sach thuc an: ");
        dsTA.xuatdsThucAn();
        System.out.println("----------------------------");
	}



	@Override
	public String toString() {
		return "Bill [maBill=" + maBill + ", soGioChoi=" + soGioChoi + "]";
	}
	
}

