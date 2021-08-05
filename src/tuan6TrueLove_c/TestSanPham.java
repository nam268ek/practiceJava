package tuan6TrueLove_c;

public class TestSanPham {
	static DanhSachTrueLove dsTv;

	public static void nhapcung() {
		NhanVien nv1 = new NhanVien("11a", "Nguyen Van A");
		NhanVien nv2 = new NhanVien("12a", "Nguyen Van C");
		NhanVien nv3 = new NhanVien("13a", "Nguyen Van B");
		NhanVien nv4 = new NhanVien("14a", "Nguyen Van B");
		NhanVien nv5 = new NhanVien("15a", "Nguyen Van C");
		NhanVien nv6 = new NhanVien("16a", "Nguyen Van B");

		dsTv.addNhanVien(nv1);
		dsTv.addNhanVien(nv2);
		dsTv.addNhanVien(nv3);
		dsTv.addNhanVien(nv4);
		dsTv.addNhanVien(nv5);
		dsTv.addNhanVien(nv6);
	}

	public static void titleNhanVien() {
		System.out.println(String.format("|" + "%-8s" + "|" + "%15s" + "|", "Mã NV", "Tên NV"));
	}

	private static void xuatNhanVien() {
		for (NhanVien nv : dsTv.listNv) {
			System.out.println(nv);
		}
	}

	public static void main(String[] args) {
		dsTv = new DanhSachTrueLove();
		nhapcung();
		titleNhanVien();
		xuatNhanVien();

		dsTv.countNv();
		System.out.println("\nTên sản phẩm được chọn là: " + dsTv.tenSanPham());
	}
}
