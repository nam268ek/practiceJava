package tuan2Xe;

import java.util.ArrayList;
import java.util.Scanner;

public class MainXe {

	static ArrayList<Xe> ListXe = new ArrayList<Xe>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Xe addXe = new Xe(12, "Nguyen Van A", "Honda", 100, 25000000);
		Xe addXe2 = new Xe(13, "Nguyen Van B", "Suzuki", 200, 35000000);
		Xe addXe3 = new Xe(14, "Nguyen Van C", "Toyota", 350, 350000000);

		ListXe.add(addXe);
		ListXe.add(addXe2);
		ListXe.add(addXe3);

		menu();
		int n = sc.nextInt();
		while (n >= 1 && n <= 5) {
			switch (n) {
			case 1:
				Xe newXe = new Xe();
				InputXe(newXe);
				ListXe.add(newXe);
				break;
			case 2:
				title();
				float sumTax = 0;
				for (int i = 0; i < ListXe.size(); i++) {
					float temp = ListXe.get(i).getThue();
					sumTax += temp;
					System.out.println(ListXe.get(i));
				}
				titleTax();
				System.out.printf(String.format("%,13.1f" + "|", sumTax));
				break;
			case 3:
				System.out.println("Nhap maXe:");
				int id = sc.nextInt();
				for (int i = 0; i < ListXe.size(); i++) {
					if (ListXe.get(i).getMaXe() == id)
						ListXe.remove(i);
				}
				break;
			case 4:
				System.out.println("Nhap maXe:");
				id = sc.nextInt();
				for (int i = 0; i < ListXe.size(); i++) {
					if (ListXe.get(i).getMaXe() == id) {
						System.out.println("MENU-Sua");
						menu_lv2();
						int n2 = sc.nextInt();
						sc.nextLine();
						while (n2 >= 1 && n2 <= 4) {
							switch (n2) {
							case 1:
								System.out.println("Nhap ten chu xe:");
								ListXe.get(i).setTenChuXe(sc.nextLine());
								System.out.println("Complete !");
								break;
							case 2:
								System.out.println("Nhap ten xe:");
								ListXe.get(i).setLoaiXe(sc.nextLine());
								System.out.println("Complete !");
								break;
							case 3:
								System.out.println("Dung tich:");
								ListXe.get(i).setDungTich(sc.nextFloat());
								System.out.println("Complete !");
								break;
							case 4:
								System.out.println("Tri gia:");
								ListXe.get(i).setTriGia(sc.nextFloat());
								System.out.println("Complete !");
								break;
							default:
								break;
							}
							System.out.println("\nMENU-Sua");
							menu_lv2();
							n2 = sc.nextInt();
						}
					}
				}
				break;
			case 5:
				System.out.println("MENU-Search");
				menu_lv2();
				int n3 = sc.nextInt();
				sc.nextLine();
				while (n3 >= 1 && n3 <= 4) {
					switch (n3) {
					case 1:
						System.out.println("Nhap thong tin:");
						String info = sc.nextLine();
						title();
						for (Xe obj : ListXe) {
							if (obj.getTenChuXe() != null && obj.getTenChuXe().contains(info)) {
								System.out.println(obj);
							}
						}
						break;
					case 2:
						// sc.nextLine();
						System.out.println("Nhap thong tin:");
						info = sc.nextLine();
						title();
						for (Xe obj : ListXe) {
							if (obj.getLoaiXe() != null && obj.getLoaiXe().contains(info)) {
								System.out.println(obj);
							}
						}
						break;
					case 3:
						// sc.nextLine();
						System.out.println("Nhap thong tin:");
						info = sc.nextLine();
						title();
						for (Xe obj : ListXe) {
							if (String.valueOf(obj.getDungTich()) != null
									&& String.valueOf(obj.getDungTich()).contains(info)) {
								System.out.println(obj);
							}
						}
						break;
					case 4:
						System.out.println("Nhap thong tin:");
						info = sc.nextLine();
						title();
						for (Xe obj : ListXe) {
							if (String.valueOf(obj.getTriGia()) != null
									&& String.valueOf(obj.getTriGia()).contains(info)) {
								System.out.println(obj);
							}
						}
						break;
					default:
						break;
					}
					System.out.println("\nMENU-Search");
					menu_lv2();
					n3 = sc.nextInt();
				}
				break;
			}
			menu();
			n = sc.nextInt();
		}
		System.out.println("\n:Application Close !");
	}

	public static void menu_lv2() {
		System.out.println("1.Ten chu xe.");
		System.out.println("2.Ten xe");
		System.out.println("3.Dung tich.");
		System.out.println("4.triGia.");
		System.out.println("5.Thoat.");
		System.out.println("-> Choise: ");
	}

	public static void InputXe(Xe db) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ma Xe:");
		int check = sc.nextInt();
		for (int i = 0; i < ListXe.size(); i++) {
			while (ListXe.get(i).getMaXe() == check) {
				System.out.println(":Trung ma Xe. Vui long nhap lai !");
				System.out.println("Ma Xe:");
				check = sc.nextInt();
			}
		}
		sc.nextLine();
		System.out.println("Ten chu xe:");
		db.setTenChuXe(sc.nextLine());
		System.out.println("Loai xe:");
		db.setLoaiXe(sc.nextLine());
		System.out.println("Dung tich:");
		db.setDungTich(sc.nextFloat());
		System.out.println("Tri gia:");
		db.setTriGia(sc.nextFloat());
		db.getThue();
	}

	public static void titleTax() {
		System.out.printf(String.format("|" + "%80s", "SumTax:"));
	}

	public static void title() {
		System.out.println(String.format(
				"\n|" + "%-8s" + "|" + "%-20s" + "|" + "%-8s" + "|" + "%12s" + "|" + "%20s" + "|" + "%20s" + "|",
				"maXe", "tenChuXe", "tenXe", "dungTich", "triGia", "thue"));
	}

	public static void menu() {
		System.out.println("\nCHUONG TRINH DANG KY XE");
		System.out.println("1.Nhap thong tin xe.");
		System.out.println("2.Xuat bang ke khai thue.");
		System.out.println("3.Xoa thong tin xe.");
		System.out.println("4.Sua thong tin xe.");
		System.out.println("5.Tim kiem thong tin xe.");
		System.out.println("6.Thoat.");
		System.out.printf("-> Choise: ");
	}
}
