package tuan6TrueLove_d;

import java.util.Scanner;

public class TestNhanVien {
    static DanhSachNhanVien dsNv;

    public static void nhapcung() {
        NhanVien nv1 = new NhanVien("11a", "Nguyen Van A");
        NhanVien nv2 = new NhanVien("12a", "Nguyen Van B");
        NhanVien nv3 = new NhanVien("13a", "Nguyen Van C");

        dsNv.addNhanVien(nv1);
        dsNv.addNhanVien(nv2);
        dsNv.addNhanVien(nv3);
    }

    public static void titleNhanVien() {
        System.out.println(String.format("|" + "%-8s" + "|" + "%15s" + "|", "Mã NV", "Tên NV"));
    }

    private static void xuatNhanVien() {
        for (NhanVien nv : dsNv.danhSachNhanVien) {
            System.out.println(nv);
        }
    }
    private static void xuatNhanVienDuLich() {
        for (NhanVien nv : dsNv.listNv) {
            System.out.println(nv);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dsNv = new DanhSachNhanVien();
        nhapcung();
        System.out.println("\nDanh sách nhân viên: ");
        titleNhanVien();
        xuatNhanVien();
        System.out.println("\nThêm nhân viên vào ds du lịch: ");
        System.out.println("Nhập mã nhân viên: ");
        String m = sc.nextLine();
        NhanVien obj = dsNv.searchNhanVien(m);
        while (obj == null) {
            System.out.println("Mã nhân viên không tồn tại!");
            System.out.println("Nhập mã nhân viên: ");
            m = sc.nextLine();
            obj = dsNv.searchNhanVien(m);
        }
        while (obj != null) {
            boolean status = dsNv.addNhanVienDk(obj);
            if (status) {
                System.out.println("Đã thêm thành công.");
                System.out.println("Bạn có muốn thêm nhân viên không(Y/N) ?");
                String yn = sc.nextLine();
                if (yn.equalsIgnoreCase("Y")) {
                    System.out.println("Nhập mã nhân viên: ");
                    m = sc.nextLine();
                    obj = dsNv.searchNhanVien(m);
                    while (obj == null) {
                        System.out.println("Mã nhân viên không tồn tại!");
                        System.out.println("Nhập mã nhân viên: ");
                        m = sc.nextLine();
                        obj = dsNv.searchNhanVien(m);
                    }
                } else {
                    System.out.println("\nDanh sách nhân viên du lịch: ");
                    titleNhanVien();
                    xuatNhanVienDuLich();
                    break;
                }

            } else {
                System.out.println("Lỗi thêm.");
                break;
            }
        }
    }
}
