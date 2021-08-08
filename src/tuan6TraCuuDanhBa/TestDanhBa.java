package tuan6TraCuuDanhBa;

import java.util.Scanner;

public class TestDanhBa {
    static DanhSachDanhBa dsDb;

    public static void nhapCung() {
        DanhBa db1 = new DanhBa("0377136666", "Nguyen Van A", "Hà Nội");
        DanhBa db2 = new DanhBa("0377136667", "Nguyen Van B", "Hồ Chí Minh");
        DanhBa db3 = new DanhBa("0377136668", "Nguyen Van C", "Hà Nội");
        DanhBa db4 = new DanhBa("0377136669", "Nguyen Van D", "Đà Lạt");
        DanhBa db5 = new DanhBa("0377136660", "Nguyen Van E", "Đak Nông");

        dsDb.addDanhBa(db1);
        dsDb.addDanhBa(db2);
        dsDb.addDanhBa(db3);
        dsDb.addDanhBa(db4);
        dsDb.addDanhBa(db5);
    }

    public static DanhBa nhapMem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số điện thoại: ");
        String s = sc.nextLine();
        System.out.println("Nhập tên: ");
        String t = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String d = sc.nextLine();
        DanhBa db = new DanhBa(s, t, d);
        return db;
    }

    public static void titleDanhBa() {
        System.out.println(String.format("|" + "%12s" + "|" + "%15s" + "|" + "%12s" + "|", "Số ĐT", "Tên", "Địa chỉ"));
    }

    public static void xuatDanhBa() {
        for (DanhBa db : dsDb.listDb) {
            System.out.println(db);
        }
    }

    public static void menu() {
        System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ DANH BẠ");
        System.out.println("1. Nhập danh bạ.");
        System.out.println("2. Tìm theo địa chỉ.");
        System.out.println("3. Tìm theo số điện thoại.");
        System.out.println("0. Thoát");
        System.out.println("Lựa chọn:");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dsDb = new DanhSachDanhBa();
        menu();
        int choise = sc.nextInt();
        while (choise != 0) {
            switch (choise) {
                case 1:
                    nhapCung();
                    DanhBa db = nhapMem();
                    boolean st = dsDb.addDanhBa(db);
                    if (st) {
                        System.out.println("\nĐã thêm danh bạ thành công.");
                        System.out.println("Danh sách danh bạ: ");
                        titleDanhBa();
                        xuatDanhBa();
                    } else {
                        System.out.println("Đã có danh bạ này.");
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("\nNhập địa chỉ tìm kiếm: ");
                    String d = sc.nextLine();
                    titleDanhBa();
                    for (DanhBa db1 : dsDb.listDb) {
                        if (db1.getDiaChi().equalsIgnoreCase(d)) {
                            System.out.println(db1);
                        }
                    }

                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("\nNhập số điện thoại tìm kiếm: ");
                    String s = sc.nextLine();
                    titleDanhBa();
                    for (DanhBa db1 : dsDb.listDb) {
                        if (db1.getSoDienThoai().equalsIgnoreCase(s)) {
                            System.out.println(db1);
                        }
                    }
                    break;
            }
            menu();
            choise = sc.nextInt();
            while (choise < 0 || choise > 3) {
                System.out.println("Chọn sai. Vui lòng nhập lại !");
                choise = sc.nextInt();
            }
        }
        System.out.println("Application closed !");
    }
}
