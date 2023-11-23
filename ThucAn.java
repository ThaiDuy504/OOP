	package Net;
	
	
	import java.util.Scanner;
	
	public class ThucAn {
		private int MaThucAn;
		private String TenThucAn;
		private String TheLoai;
		private double DonGia;
		Scanner sc=new Scanner(System.in);
		public ThucAn() {
		}
		public ThucAn(int MaThucAn,String TenThucAn,String TheLoai,double DonGia) {
			this.MaThucAn=MaThucAn;
			this.TenThucAn=TenThucAn;
			this.TheLoai=TheLoai;
			this.DonGia=DonGia;
		}
	
		public int getMaThucAn() {
			return MaThucAn;
		}
	
		public void setMaThucAn(int maThucAn) {
			this.MaThucAn = maThucAn;
		}
	
	
		public String getTenThucAn() {
			return TenThucAn;
		}
	
		public void setTenThucAn(String tenThucAn) {
			this.TenThucAn = tenThucAn;
		}
	
		public String getTheLoai() {
			return TheLoai;
		}
	
		public void setTheLoai(String theLoai) {
			this.TheLoai = theLoai;
		}
	
		public double getDonGia() {
			return DonGia;
		}
	
	
		public void setDonGia(double donGia) {
			this.DonGia = donGia;
		}
		public void nhap() {
			System.out.print("Nhập mã thức ăn: ");
	        setMaThucAn(sc.nextInt());
	        sc.nextLine();
	        System.out.print("Nhập tên thức ăn: ");
	        setTenThucAn(sc.nextLine());
	        System.out.print("Nhập loại thức ăn: ");
	        setTheLoai(sc.nextLine());
	        System.out.print("Nhập đơn giá: ");
	        setDonGia(sc.nextDouble());
	    }
		public void xuat() {
			System.out.println("Mã thức ăn: " +MaThucAn);
	        System.out.println("Tên thức ăn: " +TenThucAn);
	        System.out.println("Loại thức ăn: " +TheLoai);
	        System.out.println("Đơn giá: " +DonGia);
	        System.out.println("----------------------------");
		 }
		@Override
		public String toString() {
			return "ThucAn [MaThucAn=" + MaThucAn + ", TenThucAn=" + TenThucAn + ", TheLoai=" + TheLoai + ", DonGia="
					+ DonGia + ", sc=" + sc + "]";
		}
		
		
	}
