package NET;
// import java.lang.reflect.Array;
import java.util.*;
public class FLOOR {
    Scanner sc = new Scanner(System.in);
    public int maTang;
    public int so_phong;
    public int so_cot;
    public int so_dong;
    DS_PHONG ds_phong=new DS_PHONG();
    public FLOOR(){
        
    }
    public FLOOR(FLOOR Tang){
        this.maTang=Tang.maTang;
    }
    public void setmaTang(int matang){
        this.maTang=matang;
    }
    public int getMaTang(){
        return this.maTang;
    }
    void menu(){
        System.out.println("QUANC CO 2 TANG");
        System.out.println("CHON TANG : (CHON SO 1 HOAC SO 2)");
        int room_choice;
        room_choice = sc.nextInt();
            ds_phong.declare(room_choice);
            ds_phong.menu(room_choice);        
    }
}
    
