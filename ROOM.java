package NET;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
public class ROOM {
    Scanner sc = new Scanner(System.in);
    public int maTang;
    public int maPhong;
    public Boolean status;
    public String state;
    public Devices Device[];
    public static List<Devices> Device_file = new ArrayList<>();
    public  int quantityOfDevices; 
    public ROOM(ROOM phong){
        this.maPhong=phong.maPhong;
        this.maTang=phong.maTang;
        this.status=phong.status;
    }
    public ROOM(int maTang,int maPhong,Boolean status){
        this.maPhong=maPhong;
        this.status=status;
        this.maTang=maTang;
    }
    public void setmaphong(int maphong){
        this.maPhong=maphong;
    }
    public int maphong(){
        return maPhong;
    }
    public void setTrangThai(boolean trangthai){
        this.status=trangthai;
    }
    void xuat(){
        if(status==true){
            state="Chua dat";
        }
        System.out.print(maTang+"."+maPhong+"."+state+" ");
    }
    public void declare_Devices(){
        Device=new Devices[3];
        Device[0]=new Devices("Dareu","01","EK75","Ban Phim",1);
        Device[1]=new Devices("HP","02","Pavillon","May tinh",2);
        Device[2]=new Devices("Logitech","03","G102","Chuot",3);
    }
    public void display_devices(){
       for(int i=0;i<3;i++){
        Device[i].xuat();
       }
    }
    public void fixed_devices(String MaTHietbi){
        System.out.println("nhap vao thong tin moi cho thiet bi nay: ");
        String a;
        String b;
        String c;
        String d;
        int e;
        System.out.println("nhap vao ma nha phan phoi : ");
        a=sc.nextLine();
        System.out.println("nhap vao ma thiet bi  : ");
        b=sc.nextLine();
        System.out.println("nhap vao ten thiet bi : ");
        c=sc.nextLine();
        System.out.println("nhap vao loai thiet bi : ");
        d=sc.nextLine();
        System.out.println("nhap vao thoi luong bao hanh : ");
        e=sc.nextInt();
        for(int i=0;i<3;i++){
            if(Device[i].MaThietBi==MaTHietbi){
                Device[i]=new Devices(a,b,c,d,e);
            }
        }
    }
    public void ReadFILE(String file_name){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file_name));
            String line;
            while((line = bufferedReader.readLine())!=null){
                String[] parts = line.split(",");
                if(parts.length == 5){
                    String brand=parts[0];
                    String code = parts[1];
                    String name= parts[2];
                    String type=parts[3];
                    int BaoHanh = Integer.parseInt(parts[4]);
                    Devices ThietBi=new Devices(brand, code, name, type, BaoHanh);
                    Device_file.add(ThietBi);
                }
            }
        }catch(IOException e){
            System.out.println("co loi xayu ra khi doc du lieu tu file");
            e.printStackTrace();
        }
    }
    public void xuat_arraylist(){
        for(Devices i : Device_file){
            i.xuat();
        }
    }
    public void writeFile(String file_name){
        declare_Devices();
       try (BufferedWriter file_writer = new BufferedWriter(new FileWriter(file_name))){
            for(int i=0;i<Device.length;i++ ){
                String line = Device[i].getMaNhaPhanPhoi()+","+Device[i].getMaThietBi()+","+Device[i].getTenThietBi()+","+Device[i].getLoaiThietBi()+","+Device[i].getBaoHanh();
                file_writer.write(line+"\n");
            }
        }
       catch(IOException e){
            System.out.println("co loi xayu ra khi doc du lieu tu file");
            e.printStackTrace();
        }
    }
}
