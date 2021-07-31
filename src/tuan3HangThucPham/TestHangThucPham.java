package tuan3HangThucPham;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestHangThucPham {

	static HangThucPham listProducts[];
	static FunctionList func = new FunctionList(10);

	public static void menu() {
		System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ THỰC PHẨM");
		System.out.println("1.Thêm sản phẩm.");
		System.out.println("2.Xóa sản phẩm.");
		System.out.println("3.Sửa thông tin.");
		System.out.println("4.Tìm kiếm.");
		System.out.println("5.Xuất danh sách.");
		System.out.println("6.Liệt kê danh sách sản phẩm hết HSD");
		System.out.println("7.Tổng số lượng sản phẩm.");
		System.out.println("8.Tổng giá trị.");
		System.out.println("9.Thoát.");
		System.out.println("Lựa chọn:");
	}

	public static int CheckIdProducts() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập id:");
		while (!sc.hasNextInt()) {
			System.out.println("Vui lòng nhập đúng định dạng. ID chỉ bao gồm số !");
			sc.next();
		}
		int id = sc.nextInt();
		for (int i = 0; i < func.count; i++) {
			while (listProducts[i].getMaHang() == id) {
				System.out.println("Trùng mã. Vui lòng nhập lại !");
				System.out.println("Nhập id:");
				id = sc.nextInt();
				sc.nextLine();
			}
		}
		return id;
	}

	public static boolean CheckValidate(String date) {
		if (date == null) {			
			return false;
		} else {
			SimpleDateFormat checkDate = new SimpleDateFormat("dd/MM/yyyy");
			checkDate.setLenient(false);
			try {
				checkDate.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("Sai định dạng. Vui lòng nhập lại");
				return false;
			}
			return true;
		}
	}

	public static Calendar dateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static boolean CheckDate(Calendar ngaySX, Calendar ngayHD) {
		if (ngaySX.compareTo(ngayHD) <= 0) {
			return true;
		} else {
			System.out.println("Warring: Ngày hết hạn không được nhỏ hơn ngày sản xuất.");
			return false;
		}
	}

	public static void InputData(HangThucPham products) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar ngaySuanXuat = null;
		Calendar ngayHetHan = null;
		int maHang = CheckIdProducts();
		System.out.println("Nhập tên hàng:");
		String tenHang = sc.nextLine();
		while (tenHang == null) {
			System.out.println("Tên không được để trống. Vui lòng nhập lại !");
			tenHang = sc.nextLine();
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
		try {
			System.out.println("Ngày SX(dd/MM/yyyy):");
			String time = sc.next();
			while (CheckValidate(time) == false) {
				time = sc.next();
			}
			Date date = dateFormat.parse(time); // Convert String to Date
			ngaySuanXuat = dateToCalendar(date); // Convert Date to Calendar
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			do {
				System.out.println("Ngày hết hạn(dd/MM/yyyy):");
				String time = sc.next();
				while (CheckValidate(time) == false) {
					time = sc.next();
				}
				Date date = dateFormat.parse(time); // Convert String to Date
				ngayHetHan = dateToCalendar(date); // Convert Date to Calendar
			} while (CheckDate(ngaySuanXuat, ngayHetHan) == false);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		products.setMaHang(maHang);
		products.setTenHang(tenHang);
		products.setDonGia(donGia);
		products.setNgaySanXuat(ngaySuanXuat);
		products.setNgayHetHan(ngayHetHan);
	}

	public static void InputDefault() {
		Calendar nsx1 = new GregorianCalendar(2021, 1, 1);
		Calendar hsd1 = new GregorianCalendar(2021, 2, 1);
		Calendar nsx2 = new GregorianCalendar(2019, 7, 5);
		Calendar hsd2 = new GregorianCalendar(2019, 7, 11);
		Calendar nsx3 = new GregorianCalendar(2019, 8, 12);
		Calendar hsd3 = new GregorianCalendar(2021, 4, 21);
		Calendar nsx4 = new GregorianCalendar(2018, 3, 15);
		Calendar hsd4 = new GregorianCalendar(2019, 6, 10);
		Calendar nsx5 = new GregorianCalendar(2021, 6, 16);
		Calendar hsd5 = new GregorianCalendar(2021, 6, 19);
		Calendar nsx6 = new GregorianCalendar(2021, 6, 16);
		Calendar hsd6 = new GregorianCalendar(2021, 10, 19);
		Calendar nsx7 = new GregorianCalendar(2021, 4, 26);
		Calendar hsd7 = new GregorianCalendar(2021, 11, 29);

		HangThucPham tp1 = new HangThucPham(111, "Sữa chua", 20000, nsx1, hsd1);
		HangThucPham tp2 = new HangThucPham(112, "Coca cola", 10000, nsx2, hsd2);
		HangThucPham tp3 = new HangThucPham(113, "Đường", 15000, nsx3, hsd3);
		HangThucPham tp4 = new HangThucPham(114, "Bột ngọt", 22000, nsx4, hsd4);
		HangThucPham tp5 = new HangThucPham(115, "Hạt nêm", 25000, nsx5, hsd5);
		HangThucPham tp6 = new HangThucPham(116, "Ca cao", 33000, nsx6, hsd6);
		HangThucPham tp7 = new HangThucPham(117, "Rựu vang", 125000, nsx7, hsd7);

		func.addProducts(tp1);
		func.addProducts(tp2);
		func.addProducts(tp3);
		func.addProducts(tp4);
		func.addProducts(tp5);
		func.addProducts(tp6);
		func.addProducts(tp7);

	}

	public static void exportListProductsExp(HangThucPham arrList[]) {
		for (int i = 0; i < func.count; i++) {
			if (arrList[i].CheckExpProducts() == false) {
				System.out.println(arrList[i]);
			}
		}
	}

	public static void title() {
		System.out.println(String.format(
				"\n|" + "%-8s" + "|" + "%-17s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%17s" + "|",
				"Mã hàng", "Tên hàng", "Đơn giá", "Ngày sản xuất", "Hạn sử dụng", "Trạng thái"));
		System.out.println("----------------------------------------------------------------------------------------------");
	}

	public static void menuModify() {
		System.out.println("Menu thay đổi thông tin");
		System.out.println("1.Tên sản phẩm");
		System.out.println("2.Đơn giá");
		System.out.println("3.NSX");
		System.out.println("4.HSD");
		System.out.println("5.Thoát");
		System.out.println("Lựa chọn:");
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		listProducts = func.exportAllListProducts();

		menu();
		int choise = sc.nextInt();
		while (choise != 0) {
			switch (choise) {
			case 1:
				InputDefault();
				HangThucPham newTp = new HangThucPham();
				InputData(newTp);
				if (func.addProducts(newTp))
					System.out.println("Thêm thành công !");
				else
					throw new Exception("Thêm thất bại");
				break;
			case 2:
				System.out.println("Nhập ID sản phẩm:");
				int id = sc.nextInt();
				HangThucPham product = func.searchProducts(id);
				if (func.deleteProducts(product))
					System.out.println("Xoá thành công !");
				else
					throw new Exception("Xóa thất bại");
				break;
			case 3:
				System.out.println("Nhập ID sản phẩm:");
				id = sc.nextInt();
				while (func.searchProducts(id) == null) {
					System.out.println("Sai ID. Vui lòng nhập lại");
					id = sc.nextInt();
				}
				menuModify();
				choise = sc.nextInt();
				while (choise != 0) {
					switch (choise) {
					case 1:
						sc.nextLine();
						System.out.println("Nhập tên mới:");
						String name = sc.nextLine();
						while (name == null || name.trim().equals("")) {
							System.out.println("Tên không được để trống. Vui lòng nhập lại !");
							name = sc.nextLine();
						}
						func.searchProducts(id).setTenHang(name);
						break;
					case 2:
						System.out.println("Nhập đơn giá mới:");
						while (!sc.hasNextDouble()) {
							System.out.println("Vui lòng nhập đúng định dạng !");
							sc.next();
						}
						double donGia = sc.nextDouble();
						while (donGia <= 0) {
							System.out.println("Đơn giá > 0. Vui lòng nhập lại !");
							donGia = sc.nextDouble();
						}
						func.searchProducts(id).setDonGia(donGia);
						break;
					case 3:
						try {
							Calendar ngaySuanXuat = null;
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							System.out.println("Ngày SX(dd/MM/yyyy):");
							String time = sc.next();
							while (CheckValidate(time) == false) {
								time = sc.next();
							}
							Date date = dateFormat.parse(time); // Convert String to Date
							ngaySuanXuat = dateToCalendar(date); // Convert Date to Calendar
							func.searchProducts(id).setNgaySanXuat(ngaySuanXuat);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 4:
						try {
							Calendar ngayHetHan = null;
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							Calendar ngaySuanXuat = func.searchProducts(id).getNgaySanXuat();
							do {
								System.out.println("Ngày hết hạn(dd/MM/yyyy):");
								String time = sc.next();
								while (CheckValidate(time) == false) {
									time = sc.next();
								}
								Date date = dateFormat.parse(time); // Convert String to Date
								ngayHetHan = dateToCalendar(date); // Convert Date to Calendar
							} while (CheckDate(ngaySuanXuat, ngayHetHan) == false);

							func.searchProducts(id).setNgayHetHan(ngayHetHan);

						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						break;
					default:
						break;
					}
					menuModify();
					choise = sc.nextInt();
					if (choise < 0 || choise > 5) {
						System.out.println("Chọn sai. Vui lòng nhập lại !");
						choise = sc.nextInt();
					} else if (choise == 5)
						break;
				}
				break;
			case 4:
				sc.nextLine();
				System.out.println("Nhập thông tin tìm kiếm(id hoặc tên sản phẩm):");
				String key = sc.nextLine();
				while (key.trim().equals("")) {
					System.out.println("Keyword không được để trống !");
					key = sc.nextLine();
				}
				title();
				for (int i = 0; i < func.count; i++) {
					String maHang = String.valueOf(listProducts[i].getMaHang());
					String tenHang = listProducts[i].getTenHang();
					String donGia = String.valueOf(listProducts[i].getDonGia());
					if (tenHang != null && tenHang.contains(key) || maHang != null && maHang.contains(key)
							|| donGia != null && donGia.contains(key)) {
						System.out.println(listProducts[i]);
					}
				}
				break;
			case 5:
				title();
				for (int i = 0; i < func.count; i++) {
					System.out.println(listProducts[i]);
				}
				break;
			case 6:
				title();
				for (int i = 0; i < func.count; i++) {
					if (listProducts[i].CheckExpProducts() == false) {
						System.out.println(listProducts[i]);
					}
				}
				break;
			case 7:
				System.out.println("Tổng số lượng sản phẩm: " + func.count);
				break;
			case 8:
				System.out.println("Tổng giá trị: " + String.format("%,.2f", func.sumProducts()) + "đ");
				break;
			case 9:
				System.out.println("Xin cảm ơn !");
				break;
			default:
				break;
			}
			menu();
			choise = sc.nextInt();
			if (choise < 0 || choise > 9) {
				System.out.println("Chọn sai. Vui lòng nhập lại !");
				choise = sc.nextInt();
			} else if (choise == 9)
				break;
		}

	}

}
