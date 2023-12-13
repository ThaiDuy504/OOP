package Net;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Net.ThucAn;
import Net.danhSachBillChiTiet;

public class DanhSachThucAn {
    private int n;
    private ThucAn[] arrta = new ThucAn[100];
    private Scanner sc = new Scanner(System.in);

    public DanhSachThucAn() {
        arrta = new ThucAn[100];
        n = 0;
    }

    public DanhSachThucAn(ThucAn[] arrta, int n) {
        this.arrta = arrta;
        this.n = n;
    }

    public void add(ThucAn thucAn) {
        Arrays.copyOf(arrta, ++n);
        arrta[n - 1] = thucAn;
    }

    public ThucAn[] getDsThucAn() {
        return arrta;
    }

    public void setDsThucAn(ThucAn[] arrta) {
        this.arrta = arrta;
    }

    public void menu() {
        int choice;

        do {
            System.out.println("\n---------- Menu ----------");
            System.out.println("1. Tìm kiếm thức ăn");
            System.out.println("2. Thêm thức ăn");
            System.out.println("3. Xóa thức ăn");
            System.out.println("4. Sửa thông tin thức ăn");
            System.out.println("5. Xuất danh sách thức ăn");
            System.out.println("6. Ghi vào file");
            System.out.println("7. Đọc từ file");
            System.out.println("0. Thoát");

            System.out.print("Chọn một số: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    timkiemThucAn();
                    break;
                case 2:
                    themThucAn();
                    xuatdsThucAn();
                    break;
                case 3:
                    xoaThucAn();
                    xuatdsThucAn();
                    break;
                case 4:
                    suaThucAn();
                    xuatdsThucAn();
                    break;
                case 5:
                    xuatdsThucAn();
                    break;
                case 6:
                    writefile();
                    break;
                case 7:
                    readfile();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
            }
        } while (choice != 0);
    }

    public void nhapdsThucAn() {
        System.out.println("\n---------- Nhập danh sách thức ăn ----------");
        System.out.print("Nhập vào số lượng thức ăn:");
        n = sc.nextInt();
        arrta = new ThucAn[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào thức ăn thứ " + (i + 1));
            ThucAn ta = new ThucAn();
            ta.nhap();
            arrta[i] = ta;
        }
    }

    public void timkiemThucAn() {
        System.out.println("\n---------- Tìm kiếm thức ăn ----------");
        System.out.print("Nhập vào mã thức ăn cần tìm:");
        String mta = sc.nextLine();
        mta = mta.toUpperCase();
        ThucAn ans = timkiemThucAn(mta);
        if (ans == null) {
            System.out.println("khong tim thay");
            return;
        } else {
            ans.xuat();
        }
    }

    public ThucAn timkiemThucAn(String mta) {
        for (int i = 0; i < arrta.length; i++) {
            if (arrta[i] == null)
                continue;
            if (arrta[i].getMaThucAn().equals(mta))
                return arrta[i];
        }
        return null;
    }

    public void themThucAn() {
        System.out.println("\n---------- Them thuc an ----------");
        ThucAn ta = new ThucAn();
        ta.nhap();
        arrta = Arrays.copyOf(arrta, arrta.length + 1);
        arrta[n] = ta;
        n++;
    }

    public void xoaThucAn() {
        System.out.println("\n---------- Xóa thức ăn ----------");
        System.out.print("Nhập mã thức ăn cần xóa:");
        String mta = sc.nextLine();
        int index = -1;

        for (int i = 0; i < arrta.length; i++) {
            if (arrta[i] == null)
                continue;
            if (arrta[i].getMaThucAn().equals(mta)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < arrta.length - 1; i++) {
                if (arrta[i] == null)
                    continue;
                arrta[i] = arrta[i + 1];
            }
            arrta = Arrays.copyOf(arrta, n - 1);
            n--;
        } else {
            System.out.println("Không tìm thấy thức ăn có mã: " + mta);
        }
    }

    public void suaThucAn() {
        System.out.println("\n---------- Sửa thức ăn ----------");
        System.out.print("Nhập mã thức ăn cần sửa:");
        String mta = sc.nextLine();
        for (int i = 0; i < arrta.length; i++) {
            if (arrta[i] == null)
                continue;
            if (arrta[i].getMaThucAn().equals(mta)) {
                System.out.println("Nhập thông tin thức ăn mới:");
                arrta[i].nhap();
                break;
            }
        }
    }

    public void xuatdsThucAn() {
        System.out.println("\n---------- Danh sách thức ăn ----------");
        System.out.println("Danh sách thức ăn:");
        for (int i = 0; i < arrta.length; i++) {
            if (arrta[i] == null)
                continue;
            System.out.println("Thức ăn thứ " + (i + 1) + ":");
            arrta[i].xuat();
        }
    }

    public void thongKe(danhSachBillChiTiet dsBillChiTiet) {
        ArrayList<String> loai = new ArrayList<>();
        for (ThucAn ta : arrta) {
            if (ta == null)
                continue;
            if (loai.indexOf(ta.getTheLoai()) == -1)
                loai.add(ta.getTheLoai());
        }
        for (String s : loai) {
            System.out.println("Loai : " + s);
            double tien = 0;
            for (ThucAn ta : arrta) {
                if (ta == null)
                    continue;
                if (s.equals(ta.getTheLoai()))
                    tien += ta.getDonGia();
            }
            System.out.println("Tong Tien: " + tien);
        }
    }

    public void readfile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("ThucAn.dat");
            ois = new ObjectInputStream(fis);

            arrta = (ThucAn[]) ois.readObject();

            if (arrta == null) {
                System.out.println("Danh sách thức ăn trống.");
            } else {
                System.out.println("da doc xong danh sach thuc an");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writefile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("ThucAn.dat");
            oos = new ObjectOutputStream(fos);

            if (arrta != null) {
                oos.writeObject(arrta);
                System.out.println("Đã ghi danh sách thức ăn vào file: ThucAn.dat");
            } else {
                System.out.println("Danh sách thức ăn trống.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
