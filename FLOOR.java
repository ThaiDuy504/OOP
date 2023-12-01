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

    public FLOOR(FLOOR Tang) {
        this.maTang = Tang.maTang;
    }

    public void setmaTang(int matang) {
        this.maTang = matang;
    }

    public int getMaTang() {
        return this.maTang;
    }
    public void declare(int maTang){
        so_phong=36;
        so_cot=6;
        so_dong=6;
        phong = new ROOM[so_phong*so_phong];
        
        for(int i=0;i<so_phong;i++){
            phong[i]=new ROOM(maTang, i, true);    
            // System.out.println("\n");
        }
    }

    //hàm xuất các phòng 
     public void display(){
        int index=0;
        // so_phong=(int) Math.sqrt(phong.length);
        System.out.println("so phong co trong tang nay la : "+so_phong);
         for(int i=0;i<so_dong;i++){
             for(int j=0;j<so_cot;j++){
                if(index < so_phong){
                    phong[index].xuat();
                    index++;
                }
             }
            System.out.println();
        }
     }
    //hàm thêm phòng:
    public void  addROOM(int maTang){
        so_phong=(int)Math.sqrt(phong.length);
        System.out.println(so_phong);
        phong=Arrays.copyOf(phong,phong.length+1);
        System.out.println("nhap vao so phong cho phong nay: ");
        int maphong;
        maphong=sc.nextInt();
        phong[so_phong]=new ROOM(maTang,maphong,true);
        so_phong++;
        if(so_dong>=so_cot){
            ++so_dong;
        }
        else{
            ++so_cot;
        }
        System.out.println("so cot  va so dong: "+so_cot+so_dong);
    }
    //hàm xóa phòng
    public void DeleteROOM(){
        //cho người dùng nhập vào vị trí phòng muốn xóa 
        int RoomPosition ;
        System.out.println("nhap vao ma phong ban muon xoa .");
        RoomPosition= sc.nextInt();
        for(int i=0;i<so_phong;i++){
            if(RoomPosition==i){
                phong[i]=new ROOM(phong[i+1]);
            }
        }
        phong=Arrays.copyOf(phong,so_phong-1);
        so_phong--;
        if(so_cot<=so_dong){
            so_dong--;
        }
        else{
            so_cot--;
        }
    }
    void menu(){
        System.out.println("QUANC CO 2 TANG");
        System.out.println("CHON TANG : (CHON SO 1 HOAC SO 2)");
        int room_choice;
        room_choice = sc.nextInt();
        while(room_choice!=0){
        switch (room_choice) {
            case 1:
                System.out.println("ban dang o tang 1: ");
                System.out.println("chon : ");
                System.out.println("1.xem phong");
                System.out.println("2.chinh sua thong tin phong ");
                System.out.println("3.them phong");
                System.out.println("4.xoa phong");
                System.out.println("5:xem thiet bi trong phong.");
                System.out.println("6:chinh sua thong tin thiet bi.");
                System.out.println("7:doc file danh sach thiet bi .");
                System.out.println("8:viet len file.");
                int selection;
                selection=sc.nextInt();
                declare(room_choice);
                switch (selection) {
                    case 1:
                        display();
                        break;

                    case 3:                        
                        System.out.println("so tang sau khi them : ");
                        addROOM(room_choice);
                        display();
                        break;

                    case 4:
                        System.out.println("so phong sau khi xoa : ");
                        DeleteROOM();
                        display();
                        break;

                    case 5:
                        System.out.println("chon phong de xem thiet bi cua phong : ");
                        int choice_room=sc.nextInt();
                        for(int i=0;i<so_phong;i++){
                            if(choice_room==phong[i].maPhong){
                                phong[i].declare_Devices();
                                phong[i].display_devices();
                            }
                        }
                        break;

                    case 6:
                        System.out.println("chon phong de xem thiet bi cua phong : ");
                        int choice_room2=sc.nextInt();
                        String maThietBi;
                        for(int i=0;i<so_phong;i++){
                            if(choice_room2==phong[i].maPhong){
                                phong[i].declare_Devices();
                                System.out.println("nhap vao ma thiet bi cua thiet bi muon chinh sua : " );
                                maThietBi=sc.nextLine();
                                phong[i].fixed_devices(maThietBi);
                            }
                        }
                        break;
                    
                    case 7:

                        System.out.println("chon phong de xem thiet bi cua phong : ");
                        int choice_room3=sc.nextInt();
                        String maThietBi2;
                        for(int i=0;i<so_phong;i++){
                            if(choice_room3==phong[i].maPhong){
                                phong[i].declare_Devices();
                                System.out.println("nhap vao ma thiet bi cua thiet bi muon chinh sua : " );
                                maThietBi2=sc.nextLine();
                                System.out.println("nhap vao ten file text");
                                String file_name=sc.nextLine();
                                phong[i].ReadFILE(file_name);
                                phong[i].xuat_arraylist();
                            }
                        }
                        break;
                    case 8:

                        System.out.println("chon phong de xem thiet bi cua phong : ");
                        int choice_room4=sc.nextInt();
                        // String maThietBi3;
                        for(int i=0;i<so_phong;i++){
                            if(choice_room4==phong[i].maPhong){
                                phong[i].declare_Devices();
                                phong[i].display_devices();
                                phong[i].writeFile("./lib/filetext2.txt");
                            }
                        }
                        break;
                }

                

                break;
        
            case 2:
                System.out.println("ban dang o tang 2: ");
                System.out.println("chon : ");
                System.out.println("1.xem phong");
                System.out.println("2.chinh sua thong tin phong ");
                System.out.println("3.them phong");
                System.out.println("4.xoa phong");
                System.out.println("5:xem thiet bi tren phong: ");
                int selection2;
                selection2=sc.nextInt();
                declare(room_choice);
                switch (selection2) {
                    case 1:
                        display();
                        break;

                    case 3:                        
                        System.out.println("so tang sau khi them : ");
                        addROOM(room_choice);
                        display();
                        break;

                    case 4:
                        System.out.println("so phong sau khi xoa : ");
                        DeleteROOM();
                        display();
                        break;
                    
                    case 5:
                        System.out.println("chon phong de xem thiet bi cua phong : ");
                        int choice_room=sc.nextInt();
                        for(int i=0;i<so_phong;i++){
                            if(choice_room==phong[i].maPhong){
                                phong[i].declare_Devices();
                                phong[i].display_devices();
                            }
                        }
                        break;
                    case 6:
                        System.out.println("chon phong de xem thiet bi cua phong : ");
                        int choice_room2=sc.nextInt();
                        String maThietBi;
                        for(int i=0;i<so_phong;i++){
                            if(choice_room2==phong[i].maPhong){
                                phong[i].declare_Devices();
                                System.out.println("nhap vao ma thiet bi cua thiet bi muon chinh sua : " );
                                maThietBi=sc.nextLine();
                                phong[i].fixed_devices(maThietBi);
                            }
                        }
                        break;
                        case 7:

                        System.out.println("chon phong de xem thiet bi cua phong : ");
                        int choice_room3=sc.nextInt();
                        String maThietBi2;
                        for(int i=0;i<so_phong;i++){
                            if(choice_room3==phong[i].maPhong){
                                phong[i].declare_Devices();
                                System.out.println("nhap vao ma thiet bi cua thiet bi muon chinh sua : " );
                                maThietBi2=sc.nextLine();
                                System.out.println("nhap vao ten file text");
                                String file_name=sc.nextLine();
                                phong[i].ReadFILE(file_name);
                                phong[i].xuat_arraylist();
                            }
                        }
                        break;
                    case 8:

                        System.out.println("chon phong de xem thiet bi cua phong : ");
                        int choice_room4=sc.nextInt();
                        // String maThietBi3;
                        for(int i=0;i<so_phong;i++){
                            if(choice_room4==phong[i].maPhong){
                                phong[i].declare_Devices();
                                phong[i].display_devices();
                                phong[i].writeFile("./lib/filetext2.txt");
                            }
                        }
                        break;
                }

            case 0:
                System.out.println("thoat chuong trinh.");
                return;
        }
    }
    }
}
