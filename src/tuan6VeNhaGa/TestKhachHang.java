package tuan6VeNhaGa;

import java.util.Scanner;

public class TestKhachHang {
    static DanhSachKhachHang dsKh;

    public static void nhapcung() {
        KhachHang kh1 = new KhachHang("245316555", "Nguyen Van A", "Hà Nội", 290000);
        KhachHang kh2 = new KhachHang("245316556", "Nguyen Van B", "Sài Gòn", 320000);
        KhachHang kh3 = new KhachHang("245316557", "Nguyen Van C", "Ha Noi", 290000);
        KhachHang kh4 = new KhachHang("245316558", "Nguyen Van D", "Vũng Tàu", 135000);
        KhachHang kh5 = new KhachHang("245316559", "Nguyen Van E", "Sa Pa", 430000);
        KhachHang kh6 = new KhachHang("245316550", "Nguyen Van F", "Đà Nẵng", 670000);

        dsKh.addKhachHang(kh1);
        dsKh.addKhachHang(kh2);
        dsKh.addKhachHang(kh3);
        dsKh.addKhachHang(kh4);
        dsKh.addKhachHang(kh5);
        dsKh.addKhachHang(kh6);
    }

    public static KhachHang nhapmem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số CMND: ");
        String cmnd = sc.nextLine();
        System.out.println("Nhập tên khách hàng: ");
        String ten = sc.nextLine();
        System.out.println("Nhập ga đến: ");
        String ganDo = sc.nextLine();
        System.out.println("Nhập giá tiền: ");
        double giaTien = sc.nextDouble();
        KhachHang kh = new KhachHang(cmnd, ten, ganDo, giaTien);
        return kh;
    }

    public static void titleKhachHang() {
        System.out.println(String.format("|" + "%-12s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|", "Số CMND",
                "Tên KH", "Ga đến", "Giá tiền"));
    }

    private static void xuatKhachHang() {
        for (KhachHang obj : dsKh.listKh) {
            System.out.println(obj);
        }
    }

    public static void menu() {
        System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ VÉ NHÀ GA");
        System.out.println("1.Thêm một khách hàng mới vào hàng đợi mua vé.");
        System.out.println("2.Bán một vé cho khách hàng. Chỉ bán cho người đăng ký trước.");
        System.out.println("3.Hiển thị danh sách khách hàng.");
        System.out.println("4.Hủy một khách hàng ra khỏi danh sách. (khách hàng không mua vé nữa).");
        System.out.println("5.Thống kê tình hình bán vé");
        System.out.println("6.Lưu danh sách vào file");
        System.out.println("7.Hiển thị danh sách các ga đang chờ mua vé.");
        System.out.println("8.Hiển thị danh sách các ga đang chờ mua vé và số vé tương ứng cho ga.");
        System.out.println("0.Thoát");
        System.out.println("Lựa chọn: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dsKh = new DanhSachKhachHang();
        menu();
        int choise = sc.nextInt();
        while (choise != 0) {
            switch (choise) {
                case 1:
                nhapcung();
                titleKhachHang();
                xuatKhachHang();
                break;
                case 2:
                dsKh.banVeKhachHang();
                break;
                case 3:
                
            }
            menu();
            choise = sc.nextInt();
            while (choise < 0 || choise > 8) {
                System.out.println("Chọn sai. Vui lòng nhập lại !");
                choise = sc.nextInt();
            }
        }
        System.out.println("Application closed !");
    }
}
