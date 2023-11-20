package NET;
import java.util.*;
public class menu {
    public void xuat(){
        Scanner sc = new Scanner(System.in);
        int choice;
        choice=sc.nextInt();
        System.out.println("CHÀO MỪNG ĐẾN VỚI");
        System.out.println("ỨNG DỤNG QUẢN LÍ QUÁN NET \n");
        System.out.println("QUYỀN TRUY CẬP CỦA BẠN LÀ ? ");
        System.out.println("1.TÔI LÀ KHÁCH HÀNG (CUSTOMER)");
        System.out.println("2.TÔI LÀ NGƯỜI NHÂN VIÊN (STAFF).");
        System.out.println("3.TÔI LÀ QUẢN TRỊ VIÊN CỦA QUÁN (ADMIN)");
        System.out.println("0.THOÁT.");
        Quyen a = new Quyen();
        switch (choice) {
            case 0:
                    System.exit(0);
                break;
            case 1:
                 a = new user();
                
            break;
            
            case 2:
                a = new staff();
                break;
            case 3:
                a = new admin();
                
        }
    }
}
