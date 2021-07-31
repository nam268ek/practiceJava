package tuan5HangHoaSanhSu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestHangHoa {
	static DanhSachHangHoa dsHangHoa;

	public static void nhapcung() {
		Calendar ngayNhap1 = new GregorianCalendar(2021, 7, 12);
		Calendar ngayNhap2 = new GregorianCalendar(2021, 9, 24);
		Calendar ngayNhap3 = new GregorianCalendar(2021, 8, 12);
		Calendar ngayNhap4 = new GregorianCalendar(2021, 10, 24);
		Calendar ngayNhap5 = new GregorianCalendar(2019, 8, 12);
		Calendar ngayNhap6 = new GregorianCalendar(2021, 4, 24);

		HangHoa h1 = new HangSanhSu("11a", "Chén", 90, 6000, "NSX A", ngayNhap1);
		HangHoa h2 = new HangSanhSu("12a", "Chén", 90, 6000, "NSX A", ngayNhap2);
		HangHoa h3 = new HangSanhSu("13a", "Chén", 90, 6000, "NSX A", ngayNhap1);
		HangHoa h4 = new HangDienMay("14a", "Quạt", 90, 6000, 12, 30);
		HangHoa h5 = new HangDienMay("15a", "Tivi", 2, 160000, 12, 30);
		HangHoa h6 = new HangDienMay("16a", "Tủ lạnh", 90, 6000, 12, 30);
		HangHoa h7 = new HangThucPham("17a", "Rau", 90, 6000, ngayNhap2, ngayNhap1, "Long An");
		HangHoa h8 = new HangThucPham("18a", "Cá", 90, 6000, ngayNhap1, ngayNhap2, "Long An");
		HangHoa h9 = new HangThucPham("19a", "Thịt", 90, 6000, ngayNhap2, ngayNhap1, "Long An");
		HangHoa h10 = new HangThucPham("20a", "Thịt", 90, 6000, ngayNhap2, ngayNhap3, "Long An");
		HangHoa h11 = new HangThucPham("21a", "Thịt", 90, 6000, ngayNhap2, ngayNhap4, "Long An");
		HangHoa h12 = new HangThucPham("22a", "Bò kho", 90, 6000, ngayNhap5, ngayNhap6, "Long An");

		dsHangHoa.addHangHoa(h1);
		dsHangHoa.addHangHoa(h2);
		dsHangHoa.addHangHoa(h3);
		dsHangHoa.addHangHoa(h4);
		dsHangHoa.addHangHoa(h5);
		dsHangHoa.addHangHoa(h6);
		dsHangHoa.addHangHoa(h7);
		dsHangHoa.addHangHoa(h8);
		dsHangHoa.addHangHoa(h9);
		dsHangHoa.addHangHoa(h10);
		dsHangHoa.addHangHoa(h11);
		dsHangHoa.addHangHoa(h12);
	}

	public static boolean CheckDate(Calendar ngaySX, Calendar ngayHD) {
		if (ngaySX.compareTo(ngayHD) <= 0) {
			return true;
		} else {
			System.out.println("Warring: Ngày hết hạn không được nhỏ hơn ngày sản xuất.");
			return false;
		}
	}

	public static HangHoa InputGD() {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar ngaySuanXuat = null;
		Calendar ngayHetHan = null;
		Calendar ngayNhapKho = null;
		System.out.println("Nhập mã hàng: ");
		String maHh = sc.nextLine();
		System.out.println("Nhập tên hàng: ");
		String tenHh = sc.nextLine();

		System.out.println("Nhập số lượng tồn:");
		while (!sc.hasNextDouble()) {
			System.out.println("Vui lòng nhập đúng định dạng !");
			sc.next();
		}
		int soLuong = sc.nextInt();
		while (soLuong <= 0) {
			System.out.println("Số lượng tồn > 0. Vui lòng nhập lại !");
			soLuong = sc.nextInt();
		}
		System.out.println("Nhập đơn giá:");
		while (!sc.hasNextInt()) {
			System.out.println("Vui lòng nhập đúng định dạng !");
			sc.next();
		}
		double donGia = sc.nextDouble();
		while (donGia <= 0) {
			System.out.println("Đơn giá > 0. Vui lòng nhập lại !");
			donGia = sc.nextDouble();
		}
		System.out.println("Nhập loại hàng:\n" + "1.Hàng thực phẩm.\n" + "2.Hàng sành sứ.\n" + "3.Hàng điện máy.\n"
				+ "Lựa chọn: ");
		while (!sc.hasNextInt()) {
			System.out.println("Sai định dạng. Vui lòng nhập lại !");
			sc.next();
		}
		HangHoa hh = null;
		int choise = sc.nextInt();
		switch (choise) {
			case 1:
				try {
					System.out.println("Ngày SX(dd/MM/yyyy):");
					String time = sc.next();
					while (dsHangHoa.CheckValidate(time) == false) {
						time = sc.next();
					}
					Date date = dateFormat.parse(time); // Convert String to Date
					ngaySuanXuat = dsHangHoa.dateToCalendar(date); // Convert Date to Calendar
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					do {
						System.out.println("Ngày hết hạn(dd/MM/yyyy):");
						String time = sc.next();
						while (dsHangHoa.CheckValidate(time) == false) {
							time = sc.next();
						}
						Date date = dateFormat.parse(time); // Convert String to Date
						ngayHetHan = dsHangHoa.dateToCalendar(date); // Convert Date to Calendar
					} while (CheckDate(ngaySuanXuat, ngayHetHan) == false);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Nhập nhà cung cấp: ");
				String nhaCungCap = sc.nextLine();
				hh = new HangThucPham(maHh, tenHh, soLuong, donGia, ngaySuanXuat, ngayHetHan, nhaCungCap);
				break;
			case 2:
				System.out.println("Nhập nhà sản xuất: ");
				String nhaSanXuat = sc.nextLine();
				try {
					System.out.println("Ngày nhập kho(dd/MM/yyyy):");
					String time = sc.next();
					while (dsHangHoa.CheckValidate(time) == false) {
						time = sc.next();
					}
					Date date = dateFormat.parse(time); // Convert String to Date
					ngayNhapKho = dsHangHoa.dateToCalendar(date); // Convert Date to Calendar
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				hh = new HangSanhSu(maHh, tenHh, soLuong, donGia, nhaSanXuat, ngayNhapKho);
				break;
			case 3:
				sc.nextLine();
				System.out.println("Nhập thời gian bảo hành:");
				while (!sc.hasNextInt()) {
					System.out.println("Vui lòng nhập đúng định dạng !");
					sc.next();
				}
				double baoHanh = sc.nextDouble();
				while (baoHanh <= 0) {
					System.out.println("Thời gian bảo hành > 0. Vui lòng nhập lại !");
					baoHanh = sc.nextDouble();
				}
				System.out.println("Nhập công suất:");
				while (!sc.hasNextInt()) {
					System.out.println("Vui lòng nhập đúng định dạng !");
					sc.next();
				}
				double congSuat = sc.nextDouble();
				while (congSuat <= 0) {
					System.out.println("Công suất > 0. Vui lòng nhập lại !");
					congSuat = sc.nextDouble();
				}

				hh = new HangDienMay(maHh, tenHh, soLuong, donGia, baoHanh, congSuat);
		}
		return hh;
	}

	public static void menu() {
		System.out.println("\nCHƯƠNG TRÌNG QUẢN LÝ HÀNG HÓA");
		System.out.println("1.Thêm Hàng hóa.");
		System.out.println("2.Tìm kiếm Hàng hóa.");
		System.out.println("3.In danh sách Hàng hóa.");
		System.out.println("4.In danh sách các Hàng hóa sắp hết hạn.");
		System.out.println("5.Sắp xếp danh sách tăng dần theo số lượng.");
		System.out.println("6.Sắp xếp danh sách giảm dần theo đơn giá.");
		System.out.println("7.Cập nhật số lượng tồn cho hàng hóa.");
		System.out.println("8.Xóa một Hàng hóa.");
		System.out.println("9.Tổng số Hàng hóa.");
		System.out.println("0.Thoát.");
		System.out.println("Lựa chọn:");
	}

	public static void xuatHangTHucPham() {
		for (HangHoa obj : dsHangHoa.xuatAllDS()) {
			if (obj instanceof HangThucPham) {
				System.out.println(obj);
			}
		}
	}

	public static void xuatHangSanhSu() {
		for (HangHoa obj : dsHangHoa.xuatAllDS()) {
			if (obj instanceof HangSanhSu) {
				System.out.println(obj);
			}
		}
	}

	public static void xuatHangDienMay() {
		for (HangHoa obj : dsHangHoa.xuatAllDS()) {
			if (obj instanceof HangDienMay) {
				System.out.println(obj);
			}
		}
	}

	public static void titleThucPham() {
		System.out.println(String.format(
				"\n|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s"
						+ "|" + "%15s" + "|" + "%17s" + "|",
				"Mã Hàng", "Tên hàng", "Số lượng tồn", "Đơn giá", "Ngày SX", "Ngày HD", "Nhà cung cấp", "Hạn ngày",
				"Mức độ bán buôn"));
	}

	public static void titleDienMay() {
		System.out.println(String.format(
				"\n|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%17s"
						+ "|",
				"Mã Hàng", "Tên hàng", "Số lượng tồn", "Đơn giá", "Thời gian BH", "Công suất", "Mức độ bán buôn"));
	}

	public static void titleSanhSu() {
		System.out.println(String.format(
				"\n|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%17s"
						+ "|",
				"Mã Hàng", "Tên hàng", "Số lượng tồn", "Đơn giá", "Nhà SX", "Ngày nhập kho", "Mức độ bán buôn"));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dsHangHoa = new DanhSachHangHoa();
		menu();
		int choise = sc.nextInt();
		while (choise != 0) {
			switch (choise) {
				case 1:
					nhapcung();
					HangHoa newHh = InputGD();
					boolean status = dsHangHoa.addHangHoa(newHh);
					if (status) {
						System.out.println("Thêm thành công !");
						System.out.println("Danh sách hàng thực phẩm: ");
						titleThucPham();
						xuatHangTHucPham();
						System.out.println("Danh sách hàng điện máy: ");
						titleDienMay();
						xuatHangDienMay();
						System.out.println("Danh sách hàng sành sứ: ");
						titleSanhSu();
						xuatHangSanhSu();
					} else
						System.out.println("Thêm thất bại !");
					break;
				case 2:
					sc.nextLine();
					System.out.println("Nhập mã Hàng hóa tìm kiếm:");
					String maHh = sc.nextLine();
					HangHoa obj = dsHangHoa.searchHangHoa(maHh);
					if (obj != null && obj instanceof HangThucPham) {
						System.out.println("Danh sách hàng thực phẩm: ");
						titleThucPham();
						System.out.println(obj);
					} else if (obj != null && obj instanceof HangDienMay) {
						System.out.println("Danh sách hàng điện máy: ");
						titleDienMay();
						System.out.println(obj);
					} else if (obj != null && obj instanceof HangSanhSu) {
						System.out.println("Danh sách hàng sành sứ: ");
						titleSanhSu();
						System.out.println(obj);
					} else {
						System.out.println("Không tìm thấy Hàng hóa nào.");
					}
					break;
				case 3:
					System.out.println("Danh sách tất cả Hàng hóa:");
					System.out.println("Danh sách hàng thực phẩm: ");
					titleThucPham();
					xuatHangTHucPham();
					System.out.println("Danh sách hàng điện máy: ");
					titleDienMay();
					xuatHangDienMay();
					System.out.println("Danh sách hàng sành sứ: ");
					titleSanhSu();
					xuatHangSanhSu();
					break;
				case 4:
					System.out.println("Nhập số ngày hết hạn: ");
					int day = sc.nextInt();
					System.out.println("Danh sách hàng thực phẩm dưới " + day + " ngày: ");
					titleThucPham();
					for (HangHoa p : dsHangHoa.listHh) {
						if (p instanceof HangThucPham) {
							HangThucPham tp = (HangThucPham) p;
							if (tp.ngayHH() > 0 && tp.ngayHH() <= day) {
								System.out.println(tp);
							}
						}
					}
					break;
				case 5:
					System.out.println("Danh sách đã sắp xếp theo số lượng: ");
					dsHangHoa.sapXepTheoSoLuong();
					System.out.println("Danh sách hàng thực phẩm: ");
					titleThucPham();
					xuatHangTHucPham();
					System.out.println("Danh sách hàng điện máy: ");
					titleDienMay();
					xuatHangDienMay();
					System.out.println("Danh sách hàng sành sứ: ");
					titleSanhSu();
					xuatHangSanhSu();
					break;
				case 6:
					System.out.println("Danh sách đã sắp xếp theo đơn giá: ");
					dsHangHoa.sapXepTheoDonGia();
					System.out.println("Danh sách hàng thực phẩm: ");
					titleThucPham();
					xuatHangTHucPham();
					System.out.println("Danh sách hàng điện máy: ");
					titleDienMay();
					xuatHangDienMay();
					System.out.println("Danh sách hàng sành sứ: ");
					titleSanhSu();
					xuatHangSanhSu();
					break;
				case 7:
					System.out.println("Danh sách hàng hóa trước khi cập nhật: ");
					System.out.println("Danh sách hàng thực phẩm: ");
					titleThucPham();
					xuatHangTHucPham();
					System.out.println("Danh sách hàng điện máy: ");
					titleDienMay();
					xuatHangDienMay();
					System.out.println("Danh sách hàng sành sứ: ");
					titleSanhSu();
					xuatHangSanhSu();
					sc.nextLine();
					System.out.println("Nhập mã Hàng hóa: ");
					String key = sc.nextLine();
					HangHoa temp = dsHangHoa.searchHangHoa(key);
					if (temp != null) {
						System.out.println("Nhập số lượng:");
						int soLuong = sc.nextInt();
						temp.setSoLuongTon(soLuong);
					}
					System.out.println("Danh sách hàng hóa sau khi cập nhật: ");
					System.out.println("Danh sách hàng thực phẩm: ");
					titleThucPham();
					xuatHangTHucPham();
					System.out.println("Danh sách hàng điện máy: ");
					titleDienMay();
					xuatHangDienMay();
					System.out.println("Danh sách hàng sành sứ: ");
					titleSanhSu();
					xuatHangSanhSu();
					break;
				case 8:
					System.out.println("Danh sách hàng hóa trước khi xóa: ");
					System.out.println("Danh sách hàng thực phẩm: ");
					titleThucPham();
					xuatHangTHucPham();
					System.out.println("Danh sách hàng điện máy: ");
					titleDienMay();
					xuatHangDienMay();
					System.out.println("Danh sách hàng sành sứ: ");
					titleSanhSu();
					xuatHangSanhSu();
					sc.nextLine();
					System.out.println("Nhập mã hàng hóa cần xóa:");
					String delete = sc.nextLine();
					HangHoa temp2 = dsHangHoa.searchHangHoa(delete);
					if (temp2 != null) {
						status = dsHangHoa.deleteHangHoa(delete);
						if (status) {
							System.out.println("Xóa thành công");
							System.out.println("Danh sách hàng hóa sau khi xóa:");
							System.out.println("Danh sách hàng thực phẩm: ");
							titleThucPham();
							xuatHangTHucPham();
							System.out.println("Danh sách hàng điện máy: ");
							titleDienMay();
							xuatHangDienMay();
							System.out.println("Danh sách hàng sành sứ: ");
							titleSanhSu();
							xuatHangSanhSu();
						} else
							System.out.println("Xóa không thành công");
					} else
						System.out.println("Không tìm thấy");
					break;
				case 9:
					int tp = 0;
					int dm = 0;
					int ss = 0;
					for (HangHoa p : dsHangHoa.listHh) {
						if (p instanceof HangThucPham) {
							tp++;
						} else if (p instanceof HangDienMay) {
							dm++;
						} else if (p instanceof HangSanhSu) {
							ss++;
						}
					}
					System.out.println("Tổng số Hàng hóa: ");
					System.out.println("\nHàng thực phẩm: " + tp + " sản phẩm");
					System.out.println("Hàng điện máy: " + dm + " sản phẩm");
					System.out.println("Hàng sành sứ: " + ss + " sản phẩm");
					break;
			}
			menu();
			choise = sc.nextInt();
			while (choise < 0 || choise > 10) {
				System.out.println("Chọn sai. Vui lòng nhập lại !");
				choise = sc.nextInt();
			}
		}
		System.out.println("Application closed !");
	}
}
