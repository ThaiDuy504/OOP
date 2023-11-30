package NET;

import java.util.Arrays;
import java.util.Scanner;
public class DS_PHONG {
    Scanner sc=new Scanner(System.in);
    public ROOM ds_phong[];
    int so_phong;
    int so_cot;
    int so_dong;
    public DS_PHONG(){
        so_phong=36;
        ds_phong=new ROOM[so_phong];
    }
    public void declare(int maTang){
        so_phong=36;
        so_cot=6;
        so_dong=6;
        ds_phong = new ROOM[so_phong*so_phong];
        
        for(int i=0;i<so_phong;i++){
            ds_phong[i]=new ROOM(maTang,i, true);    
            // System.out.println("\n");
        }
    }
    public void change(int maPhong){
        System.out.println("nhap vao thong tin moi cho phong nay: ");
        System.out.println("nhap vao ma tang cho phong nay.");
        int maTang,trangthai;
        maTang=sc.nextInt();
        System.out.println("1:trang thai da dat phong.");
        System.out.println("0:trang thai chua dat phong.");
        trangthai=sc.nextInt();
        boolean status;
        if(trangthai==1){
            status=true;
        }
        else{
            status=false;
        }
        ds_phong[maPhong]=new ROOM(maTang,maPhong,status);
    }
    //hàm xuất các phòng 
     public void display(){
        int index=0;
        // so_phong=(int) Math.sqrt(phong.length);
        System.out.println("so phong co trong tang nay la : "+so_phong);
         for(int i=0;i<so_dong;i++){
             for(int j=0;j<so_cot;j++){
                if(index < so_phong){
                    ds_phong[index].xuat();
                    index++;
                }
             }
            System.out.println();
        }
     }
    //hàm thêm phòng:
    public void  addROOM(int maTang){
        so_phong=(int)Math.sqrt(ds_phong.length);
        System.out.println(so_phong);
        ds_phong=Arrays.copyOf(ds_phong,ds_phong.length+1);
        System.out.println("nhap vao so phong cho phong nay: ");
        int maphong;
        maphong=sc.nextInt();
        ds_phong[so_phong]=new ROOM(maTang,maphong,true);
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
                ds_phong[i]=new ROOM(ds_phong[i+1]);
            }
        }
        ds_phong=Arrays.copyOf(ds_phong,so_phong-1);
        so_phong--;
        if(so_cot<=so_dong){
            so_dong--;
        }
        else{
            so_cot--;
        }
    }

    void menu(int maTang){
        declare(maTang);
        int choice;
        boolean thoat=true;
        while (thoat) {
        System.out.println("0.Thoat");
        System.out.println("1.xem phong");
        System.out.println("2.chinh sua thong tin phong ");
        System.out.println("3.them phong");
        System.out.println("4.xoa phong");
        System.out.println("5:xem cac lua chon ve thiet bi trong phong.");
        System.out.println("chon thao tac ban muon truy cap : ");
        choice=sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("ban chon xem phong");
                display();
                break;
            case 2:
                System.out.println("ban chon sua thong tin phong");
                System.out.println("nhap vao so phong ma ban muon sua : ");
                int room_choice;
                room_choice=sc.nextInt();
                change(room_choice);
                break;
            
            case 3:
                System.out.println("ban chon them phong");
                addROOM(maTang);
                break;
            case 4:
                System.out.println("ban chon xoa phong");
                DeleteROOM();
                break;
            case 5:
                System.out.println("nhap vao phong ban muon xem thiet bi cua phong.");
                int ma_phong;
                ma_phong=sc.nextInt();
                for(int i=0;i<so_phong;i++){
                    if(ds_phong[i].maphong()==ma_phong){
                        ds_phong[i].menu();
                    }
                }
                break;
            case 0:
                System.out.println("thoat.");
                thoat=false;
                break;
        }
    }
    
}

}
