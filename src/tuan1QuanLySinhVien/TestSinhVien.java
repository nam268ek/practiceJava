package tuan1QuanLySinhVien;

import java.util.Scanner;

public class TestSinhVien {
	public static void main(String[] args) {
		System.out.println("Quan ly sinh vien");
		SinhVien sv1 = new SinhVien(16032701, "NguyenMinhNam", 6, 5);
		SinhVien sv2 = new SinhVien(16032701, "NguyenMinhNam2", 7, 9);
		SinhVien sv3 = new SinhVien();
		Question(sv3);
		System.out.println("==============================================================");
		System.out.println(String.format("%-8s %-20s %10s %10s %10s", "mssv", "hoten", "diemlt", "diemth", "diemtb"));
		System.out.println("==============================================================");
		System.out.println(sv1.toString());
		System.out.println(sv2.toString());
		System.out.println(sv3.toString());

	}

	public static void Question(SinhVien obj) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input mSSV:");
		obj.setmSSV(sc.nextInt());
		System.out.println("Input Name:");
		sc.nextLine();
		obj.setHoTen(sc.nextLine());
		System.out.println("Input diemLT:");
		obj.setDiemLT(sc.nextFloat());
		System.out.println("Input diemTH:");
		obj.setDiemTH(sc.nextFloat());
		sc.close();
	}
}
