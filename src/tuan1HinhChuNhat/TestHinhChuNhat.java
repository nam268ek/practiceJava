package tuan1HinhChuNhat;

import java.util.Scanner;

public class TestHinhChuNhat {
	public static void main(String[] args) {
		System.out.println("-----HCN------");
		
		HinhChuNhat cn1 = new HinhChuNhat(4,5);
		System.out.println("Chuvi:" + cn1.Chuvi());
		System.out.println("DienTich:" + cn1.DienTich());
		
		HinhChuNhat cn2 = new HinhChuNhat();
		Question(cn2);
		System.out.println("Chuvi:" + cn2.Chuvi());
		System.out.println("DienTich:" + cn2.DienTich());
	}
	
	public static void Question(HinhChuNhat obj) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input ChieuDai:");
		obj.setChieuDai(scan.nextInt());
		System.out.println("Input ChieuRong:");
		obj.setChieuRong(scan.nextInt());
		scan.close();
	}
}
