package tuan6VeNhaGa;

import java.util.Map;
import java.util.Scanner;

public class TestKhachHang {
    static DanhSachKhachHang dsKh;

    public static void nhapcung() {
        KhachHang kh1 = new KhachHang("245316555", "Nguyen Van A", "Hà Nội", 290000);
        KhachHang kh2 = new KhachHang("245316556", "Nguyen Van B", "Sài Gòn", 320000);
        KhachHang kh3 = new KhachHang("245316557", "Nguyen Van C", "Hà Nội", 290000);
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

    public static KhachHang nhapMem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số CMND: ");
        String cmnd = sc.nextLine();
        System.out.println("Nhập tên khách hàng: ");
        String ten = sc.nextLine();
        System.out.println("Nhập ga đến: ");
        String gaDen = sc.nextLine();
        System.out.println("Nhập giá tiền: ");
        double giaTien = sc.nextDouble();
        KhachHang kh = new KhachHang(cmnd, ten, gaDen, giaTien);
        if (dsKh.searchKhachHangQueue(cmnd) == null) {
            dsKh.addKhachHang(kh);
        } else {
            kh = dsKh.searchKhachHangQueue(cmnd);
            kh.setTenKh(ten);
            kh.setGaDen(gaDen);
            kh.setGiaTien(giaTien);
        }
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
        dsKh.listKh = dsKh.danhSachKh();
        menu();
        // -------------
        dsKh.dsNhaGa();
        // -----
        int choise = sc.nextInt();
        while (choise != 0) {
            switch (choise) {
                case 1:
                    nhapcung();
                    boolean st = dsKh.addKhachHang(nhapMem());
                    if (st) {
                        System.out.println("Khách hàng đã được thêm vào danh sách.");
                        System.out.println("\nDanh sách khách hàng chờ bán vé: ");
                        titleKhachHang();
                        xuatKhachHang();
                    } else {
                        System.out.println("Lỗi thêm.");
                    }
                    break;
                case 2:
                    boolean status = dsKh.banVeKhachHang();
                    if (status) {
                        System.out.println("Bán thành công.");
                        System.out.println("Danh sách khách hàng đã mua vé: ");
                        titleKhachHang();
                        for (KhachHang kh : dsKh.listKhMuaVe) {
                            System.out.println(kh);
                        }
                    } else {
                        System.out.println("Bán thất bại.");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("\nDanh sách khách hàng chờ bán vé: ");
                        titleKhachHang();
                        xuatKhachHang();
                        System.out.println("\nDanh sách khách hàng đã mua vé: ");
                        titleKhachHang();
                        for (KhachHang kh : dsKh.listKhMuaVe) {
                            System.out.println(kh);
                        }
                    } catch (Exception e) {
                        System.out.println("Không tìm thấy dữ liệu.");
                    }
                    break;
                case 4:
                    System.out.println("\nDanh sách khách hàng chờ bán vé: ");
                    titleKhachHang();
                    xuatKhachHang();
                    sc.nextLine();
                    System.out.println("Nhập số CMND khách hàng muốn hủy: ");
                    String cmnd = sc.nextLine();
                    status = dsKh.huyKhachHang(cmnd);
                    if (status) {
                        System.out.println("Hủy thành công.");
                        System.out.println("\nDanh sách khách hàng chờ bán vé: ");
                        titleKhachHang();
                        xuatKhachHang();
                    } else {
                        System.out.println("Hủy thất bại.");
                    }
                    break;
                case 5:
                    System.out.println("Số khách hàng đang chờ mua vé: " + dsKh.listKh.size() + " khách hàng");
                    System.out.println("Số khách hàng đã bán vé: " + dsKh.khMuaVe + " khách hàng");
                    System.out.println("Doanh thu bán vé: " + String.format("%,.1f", dsKh.doanhThu()) + " VNĐ");
                    break;
                case 6:
                    status = dsKh.saveToFileKhChoMuaVe();
                    if (status) {
                        System.out.println("Lưu thành công.");
                    } else {
                        System.out.println("Lưu thất bại.");
                    }
                    break;
                case 7:
                    try {
                        System.out.println("Danh sách các ga đang chờ mua vé: ");
                        System.out.println(String.format("|" + "%12s" + "|", "Ga đến"));
                        for (String ga : dsKh.dsNhaGa()) {
                            System.out.println(String.format("|" + "%12s" + "|", ga));
                        }
                    } catch (Exception e) {
                        System.out.println("Không tìm thấy dữ liệu.");
                    }
                    break;
                case 8:
                    try {
                        System.out.println("Danh sách các ga đang chờ mua vé và số vé tương ứng: ");
                        System.out.println(String.format("|" + "%12s" + "|" + "%12s" + "|", "Ga đến", "Số vé"));
                        dsKh.countVe();
                        for (Map.Entry<String, Integer> entry : dsKh.mapGa.entrySet()) {
                            System.out.println(String.format("|" + "%12s" + "|" + "%12s" + "|", entry.getKey(),
                                    entry.getValue() + " vé"));
                        }
                    } catch (Exception e) {
                        System.out.println("Không tìm thấy dữ liệu.");
                    }
                    break;
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
