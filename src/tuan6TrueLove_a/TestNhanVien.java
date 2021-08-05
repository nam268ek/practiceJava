package tuan6TrueLove_a;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
		for (NhanVien nv : dsNv.listNv) {
			System.out.println(nv);
		}
	}

	public static void main(String[] args) {
		SimpleDateFormat formater = new SimpleDateFormat("MM/yyyy");
		Calendar currentTime = Calendar.getInstance();
		dsNv = new DanhSachNhanVien();
		nhapcung();
		titleNhanVien();
		xuatNhanVien();

		System.out.println("\nQuà tặng dành cho nhân viên tháng " + formater.format(currentTime.getTime()) + " là: ");
		titleNhanVien();
		System.out.println(dsNv.quaTang());
	}
}
