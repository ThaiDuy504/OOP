package quan_li_quan_net;
import java.util.Scanner;

public abstract class KhachHang extends ConNguoi {
    private String maKhachHang;
    private int diemTichLuy;

    public KhachHang(String hoTen, String diaChi, String soDienThoai, String ngaySinh, String taiKhoan, String maKhachHang, int diemTichLuy) {
        super(hoTen, diaChi, soDienThoai, ngaySinh, taiKhoan);
        this.maKhachHang = maKhachHang;
        this.diemTichLuy = diemTichLuy;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }
    public void setMaKhachHang() {
		while (true) {
			maKhachHang = sc.nextLine();
			maKhachHang = maKhachHang.toUpperCase();
			if (maKhachHang.matches("KH" + "[0-9]{1,2}")) {
				break;
			} else {
				System.out.println(" Mã Khách Hàng: KH__. Ví dụ: KH01");
			}
			System.out.print("Mời nhập lại: ");
		}
	}
    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        while (true) {
            try{
                diemTichLuy= Double.parseDouble(sc.nextLine());
                if(diemTichLuy>=0){
                    break;
                }else{
                    system.out.print("Điểm Tích Lũy không đúng! Mời Nhập Lại: ");
                }
            }
            
        }
    }
    public void CongDiemTichLuy(int diem){
        diemTichLuy+=diem;
    }
    public abstract string TinhDiemTichLuy();

    public void nhap() {
		System.out.println("-----------Nhập Thông Tin Khách Hàng-----------");
		System.out.println("Nhập mã khách hàng :");
		setMaKhachHang();
		super.nhap();
		System.out.println("Nhập điểm tích lũy :");
		setDiemTichLuy();
	}
	
	public void xuat() {
		System.out.println("-------Xuất Thông Tin Khách Hàng -------");
		System.out.println("Mã Khách Hàng :"+maKhachHang);
		super.xuat();
		System.out.println("Điểm Tích Lũy :"+diemTichLuy);
}

}
