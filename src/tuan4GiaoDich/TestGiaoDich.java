package tuan4GiaoDich;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestGiaoDich {
	static ArrayList<GiaoDich> listGD = new ArrayList<GiaoDich>();
	static DanhSachGiaoDich dsGD;

	public static void nhapcung() {
		Calendar ngayNhap1 = new GregorianCalendar(2021, 2, 12);
		Calendar ngayNhap2 = new GregorianCalendar(2019, 3, 24);

		GiaoDich gd1 = new GiaoDichVang("11a", ngayNhap1, 20000, 12, "14K");
		GiaoDich gd2 = new GiaoDichTienTe("12a", ngayNhap2, 30000, 2234, 23300, "USD");
		GiaoDich gd3 = new GiaoDichVang("13a", ngayNhap1, 20000, 126, "14K");
		GiaoDich gd4 = new GiaoDichTienTe("14a", ngayNhap2, 30000, 220, 27000, "Euro");
		GiaoDich gd5 = new GiaoDichVang("15a", ngayNhap1, 20000, 12, "14K");
		GiaoDich gd6 = new GiaoDichTienTe("16a", ngayNhap2, 30000, 2200, 23300, "USD");
		GiaoDich gd7 = new GiaoDichVang("17a", ngayNhap1, 20000, 12000, "14K");
		GiaoDich gd8 = new GiaoDichTienTe("18a", ngayNhap2, 30000, 22000, 27000, "Euro");

		dsGD.addGiaoDich(gd1);
		dsGD.addGiaoDich(gd2);
		dsGD.addGiaoDich(gd3);
		dsGD.addGiaoDich(gd4);
		dsGD.addGiaoDich(gd5);
		dsGD.addGiaoDich(gd6);
		dsGD.addGiaoDich(gd7);
		dsGD.addGiaoDich(gd8);

	}

	public static GiaoDich InputGD() {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar ngayNhap = null;

		System.out.println("Nhập ID: ");
		String maGD = sc.nextLine();
		System.out.println("Nhập số lượng: ");
		int soLuong = sc.nextInt();
		try {
			System.out.println("Ngày nhập(dd/MM/yyyy):");
			String time = sc.next();
			while (dsGD.CheckValidate(time) == false) {
				time = sc.next();
			}
			Date date = dateFormat.parse(time); // Convert String to Date
			ngayNhap = dsGD.dateToCalendar(date); // Convert Date to Calendar
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Nhập đơn giá:");
		while (!sc.hasNextDouble()) {
			System.out.println("Vui lòng nhập đúng định dạng !");
			sc.next();
		}
		double donGia = sc.nextDouble();
		while (donGia <= 0) {
			System.out.println("Đơn giá > 0. Vui lòng nhập lại !");
			donGia = sc.nextDouble();

		}

		System.out.println("Nhập loại giao dịch:\n" + "1.Giao dịch vàng\n" + "2.Giao dịch tiền tệ\n" + "Lựa chọn: ");
		while (!sc.hasNextInt()) {
			System.out.println("Sai định dạng. Vui lòng nhập lại !");
			sc.next();
		}
		int choise = sc.nextInt();
		GiaoDich gd = null;
		switch (choise) {
		case 1:
			sc.nextLine();
			System.out.println("Loại vàng: ");
			while (!sc.hasNextLine()) {
				System.out.println("Sai định dạng. Vui lòng nhập lại !");
				sc.next();
			}
			String loaiVang = sc.nextLine();
			gd = new GiaoDichVang(maGD, ngayNhap, donGia, soLuong, loaiVang);
			break;
		case 2:
			System.out.println("Nhập tỉ giá: ");
			double tiGia = sc.nextDouble();
			System.out.println("Loại tiền(USD, Euro, VND): ");
			String loaiTienTe = sc.nextLine().trim();
			gd = new GiaoDichTienTe(maGD, ngayNhap, donGia, soLuong, tiGia, loaiTienTe);
			break;
		}
		return gd;
	}

	public static void title() {
		System.out
				.println(String.format(
						"\n|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%12s" + "|" + "%15s" + "|" + "%15s" + "|"
								+ "%15s" + "|",
						"mã GD", "ngày nhập", "đơn giá", "số lượng", "loại vàng", "tỉ giá", "đơn vị tiền"));
	}

	public static void menu() {
		System.out.println("\nCHƯƠNG TRÌNG QUẢN LÝ GIAO DỊCH");
		System.out.println("1.Thêm giao dịch.");
		System.out.println("2.Xóa giao dịch.");
		System.out.println("3.Sửa giao dịch.");
		System.out.println("4.Tìm kiếm giao dịch.");
		System.out.println("5.Thoát.");
		System.out.println("Lựa chọn:");
	}
	public static void xuatDS() {
		for(GiaoDich obj : dsGD.xuatAllDS()) {
			System.out.println(obj);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dsGD = new DanhSachGiaoDich();
		int slGiaoDichVang = 0;
		int slGiaoDichUSD = 0;
		int slGiaoDichEuro = 0;
		int slGiaoDichVND = 0;
		menu();
		int choise = sc.nextInt();
		while (choise != 5) {
			switch (choise) {
			case 1:
				nhapcung();
//				GiaoDich gd = InputGD();
//				dsGD.addGiaoDich(gd);
				break;
			case 2:
				System.out.println("Danh Sách trước khi xóa:");
				title();
				xuatDS();
				sc.nextLine();
				System.out.println("Nhập ID");
				String key = sc.nextLine();
				boolean status = dsGD.deleteGiaoDich(dsGD.searchGiaoDich(key));
				if (status) {
					System.out.println("Xóa thành công !");
					System.out.println("Danh sách sau khi xóa:");
					title();
					xuatDS();
				}									
				else
					System.out.println("Lỗi !");
				break;
			case 3:
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Calendar ngayNhap = null;
				System.out.println("Danh sách trước khi sửa:");
				title();
				xuatDS();
				System.out.println("Nhập ID:");
				String id = sc.nextLine();
				GiaoDich gd = dsGD.searchGiaoDich(id);
				if (gd != null) {
					System.out.println("Nhập số lượng: ");
					int soLuong = sc.nextInt();
					try {
						System.out.println("Ngày nhập(dd/MM/yyyy):");
						String time = sc.next();
						while (dsGD.CheckValidate(time) == false) {
							time = sc.next();
						}
						Date date = dateFormat.parse(time); // Convert String to Date
						ngayNhap = dsGD.dateToCalendar(date); // Convert Date to Calendar
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Nhập đơn giá:");
					while (!sc.hasNextDouble()) {
						System.out.println("Vui lòng nhập đúng định dạng !");
						sc.next();
					}
					double donGia = sc.nextDouble();
					while (donGia <= 0) {
						System.out.println("Đơn giá > 0. Vui lòng nhập lại !");
						donGia = sc.nextDouble();

					}

					System.out.println(
							"Nhập loại giao dịch:\n" + "1.Giao dịch vàng\n" + "2.Giao dịch tiền tệ\n" + "Lựa chọn: ");
					while (!sc.hasNextInt()) {
						System.out.println("Sai định dạng. Vui lòng nhập lại !");
						sc.next();
					}
					int choise1 = sc.nextInt();
					// GiaoDich gd1 = null;
					switch (choise1) {
					case 1:
						sc.nextLine();
						System.out.println("Loại vàng: ");
						while (!sc.hasNextLine()) {
							System.out.println("Sai định dạng. Vui lòng nhập lại !");
							sc.next();
						}
						String loaiVang = sc.nextLine();
						gd = new GiaoDichVang(id, ngayNhap, donGia, soLuong, loaiVang);
						break;
					case 2:
						System.out.println("Nhập tỉ giá: ");
						double tiGia = sc.nextDouble();
						System.out.println("Loại tiền(USD, Euro, VND): ");
						String loaiTienTe = sc.nextLine().trim();
						gd = new GiaoDichTienTe(id, ngayNhap, donGia, soLuong, tiGia, loaiTienTe);
						break;
					}
					
				}
				System.out.println("Danh sách sau khi sửa:");
				title();
				xuatDS();
				status = dsGD.suaGiaoDich(gd);
				if (status)
					System.out.println("Thành công !");
				else
					System.out.println("Lỗi !");
				break;
			case 4:
				sc.nextLine();
				System.out.println("Nhap ID:");
				id = sc.nextLine().trim();
				GiaoDich temp = dsGD.searchGiaoDich(id);
				title();
				System.out.println(temp);
				if (temp != null)
					System.out.println("Thành công !");
				else
					System.out.println("Lỗi !");
				break;
			}
			menu();
			choise = sc.nextInt();
			if (choise < 0 || choise > 5) {
				System.out.println("Chọn sai. Vui lòng nhập lại !");
				choise = sc.nextInt();
			} else if (choise == 5)
				break;
		}

		listGD = dsGD.xuatAllDS();

		title();
		for (GiaoDich obj : listGD) {
			System.out.println(obj);
		}

		for (GiaoDich obj : listGD) {
			if (obj instanceof GiaoDichVang)
				slGiaoDichVang += obj.getSoLuong();
			else if (obj instanceof GiaoDichTienTe && ((GiaoDichTienTe) obj).getLoaiTienTe() == "USD")
				slGiaoDichUSD += obj.getSoLuong();
			else if (obj instanceof GiaoDichTienTe && ((GiaoDichTienTe) obj).getLoaiTienTe() == "Euro")
				slGiaoDichEuro += obj.getSoLuong();
			else if (obj instanceof GiaoDichTienTe)
				slGiaoDichVND += obj.getSoLuong();
		}
		System.out.println("\nTổng số lượng Vàng: " + String.format("%,1d", slGiaoDichVang) + " kg");
		System.out.println("Tổng số lượng USD: " + String.format("%,1d", slGiaoDichUSD) + " USD");
		System.out.println("Tổng số lượng Euro: " + String.format("%,1d", slGiaoDichEuro) + " Euro");
		System.out.println("Tổng số lượng VND: " + String.format("%,d", slGiaoDichVND) + " VND");

	}
}
