package tuan6TrueLove_e;

public class TestNhanVien {
    static DanhSachNhanVien dsNv;

    public static void nhapcung() {
        NhanVien nv1 = new NhanVien("11a", "Nguyen Van A", 67000000L);
        NhanVien nv2 = new NhanVien("12a", "Nguyen Van B", 98000000L);
        NhanVien nv3 = new NhanVien("13a", "Nguyen Van C", 45000000L);

        dsNv.addNhanVien(nv1);
        dsNv.addNhanVien(nv2);
        dsNv.addNhanVien(nv3);
    }

    public static void titleNhanVien() {
        System.out.println(String.format("|" + "%-8s" + "|" + "%15s" + "|"+ "%15s" + "|", "Mã NV", "Tên NV", "Doanh thu"));
    }

    private static void xuatNhanVien() {
        for (NhanVien nv : dsNv.listNv) {
            System.out.println(nv);
        }
    }
    public static void main(String[] args) {
        dsNv = new DanhSachNhanVien();
        nhapcung();
        System.out.println("\nDanh sách nhân viên(TreeSet): ");
        titleNhanVien();
        xuatNhanVien();

    }
}
