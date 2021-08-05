package tuan6TrueLove_b;

import java.util.Scanner;

public class TestSanPham {
	static DanhSachTrueLove dsTv;

	public static void nhapcung() {
		NhanVien nv1 = new NhanVien("11a", "Nguyen Van A");
		NhanVien nv2 = new NhanVien("12a", "Nguyen Van B");
		NhanVien nv3 = new NhanVien("13a", "Nguyen Van C");

		dsTv.addNhanVien(nv1);
		dsTv.addNhanVien(nv2);
		dsTv.addNhanVien(nv3);
	}

	public static void titleNhanVien() {
		System.out.println(String.format("|" + "%-8s" + "|" + "%15s" + "|", "Mã NV", "Tên NV"));
	}

	private static void xuatNhanVien() {
		for (NhanVien nv : dsTv.listNv) {
			System.out.println(nv);
		}
	}

	public static void titleSanPham() {
		System.out.println(String.format("|" + "%-8s" + "|" + "%15s" + "|", "Mã SP", "Tên SP"));
	}

	private static void xuatSanPham() {
		for (SanPham nv : dsTv.listSp) {
			System.out.println(nv);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dsTv = new DanhSachTrueLove();
		nhapcung();
		titleNhanVien();
		xuatNhanVien();
		System.out.println("\n--Thêm sản phẩm--");
		System.out.println("Nhập mã sản phẩm: ");
		String ma = sc.nextLine();
		System.out.println("\nChọn tên cho sản phẩm mới: ");
		String ten = sc.nextLine();
		NhanVien obj = dsTv.searchNhanVien(ten);
		while (obj == null) {
			System.out.println("Thất bại. Tên sản phẩm trùng hoặc không thuộc tên nhân viên.");
			System.out.println("\nNhập lại: ");
			ten = sc.nextLine();
			obj = dsTv.searchNhanVien(ten);
		}
		if (dsTv.checkTenSanPham(obj) != null) {
			SanPham sp = new SanPham(ma, ten);
			dsTv.addSanPham(sp);
			System.out.println("Thêm thành công");
			System.out.println("Danh sách sản phẩm: ");
			titleSanPham();
			xuatSanPham();
		}
	}
}
