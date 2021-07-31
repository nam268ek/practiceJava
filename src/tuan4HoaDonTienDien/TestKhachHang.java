package tuan4HoaDonTienDien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestKhachHang {
	static DanhSachKhachHang dsKh;

	public static void menu() {
		System.out.println("\nCHƯƠNG TRÌNG QUẢN LÝ HOÁ ĐƠN TIỀN ĐIỆN");
		System.out.println("1.Thêm khách hàng.");
		System.out.println("2.Xóa khách hàng.");
		System.out.println("3.Sửa khách hàng.");
		System.out.println("4.Tìm kiếm khách hàng.");
		System.out.println("5.Xuất danh sách.");
		System.out.println("6.Tổng số lượng cho từng loại.");
		System.out.println("7.Trung bình thành tiền của khách hàng nước ngoài.");
		System.out.println("8.Xuất ra các khách hàng của tháng 9/2013");
		System.out.println("9.Sắp xếp theo ngày.");
		System.out.println("10.Sắp xếp theo đơn giá.");
		System.out.println("11.Thoát.");
		System.out.println("Lựa chọn:");
	}

	public static void nhapcung() {
		Calendar ngayNhap1 = new GregorianCalendar(2021, 2, 12);
		Calendar ngayNhap2 = new GregorianCalendar(2019, 3, 24);
		Calendar ngayNhap3 = new GregorianCalendar(2013, 8, 24);

		KhachHang kh1 = new KhachHangVietNam("11a", "Nguyễn Van A", ngayNhap1, 20, 3500, "Sinh hoạt", 15);
		KhachHang kh2 = new KhachHangVietNam("12a", "Nguyễn Van B", ngayNhap1, 25, 3500, "Sinh hoạt", 15);
		KhachHang kh3 = new KhachHangVietNam("13a", "Nguyễn Van C", ngayNhap2, 40, 3500, "Kinh doanh", 30);
		KhachHang kh4 = new KhachHangVietNam("14a", "Nguyễn Van D", ngayNhap3, 60, 3500, "Sản xuất", 50);
		KhachHang khnn1 = new KhachHangNuocNgoai("15a", "Nguyễn A", ngayNhap2, 40, 3500, "Lào");
		KhachHang khnn2 = new KhachHangNuocNgoai("16a", "Nguyễn B", ngayNhap3, 40, 3500, "Campuchia");
		KhachHang khnn3 = new KhachHangNuocNgoai("17a", "Nguyễn C", ngayNhap1, 40, 3500, "Thái Lan");
		KhachHang khnn4 = new KhachHangNuocNgoai("18a", "Nguyễn D", ngayNhap2, 40, 3500, "Singapore");

		dsKh.addGiaoDich(kh1);
		dsKh.addGiaoDich(kh2);
		dsKh.addGiaoDich(kh3);
		dsKh.addGiaoDich(kh4);

		dsKh.addGiaoDich(khnn1);
		dsKh.addGiaoDich(khnn2);
		dsKh.addGiaoDich(khnn3);
		dsKh.addGiaoDich(khnn4);
	}

	public static KhachHang InputGD() {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar ngayNhap = null;
		System.out.println("Nhập mã khách hàng: ");
		String maKh = sc.nextLine();
		System.out.println("Nhập họ tên: ");
		String hoTen = sc.nextLine();
		try {
			System.out.println("Ngày nhập(dd/MM/yyyy):");
			String time = sc.next();
			while (dsKh.CheckValidate(time) == false) {
				time = sc.next();
			}
			Date date = dateFormat.parse(time); // Convert String to Date
			ngayNhap = dsKh.dateToCalendar(date); // Convert Date to Calendar
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Nhập số lượng:");
		while (!sc.hasNextDouble()) {
			System.out.println("Vui lòng nhập đúng định dạng !");
			sc.next();
		}
		double soLuong = sc.nextDouble();
		while (soLuong <= 0) {
			System.out.println("Số lượng > 0. Vui lòng nhập lại !");
			soLuong = sc.nextDouble();
		}
		System.out.println("Nhập đơn giá:");
		while (!sc.hasNextDouble()) {
			System.out.println("Vui lòng nhập đúng định dạng !");
			sc.next();
		}
		double donGia = sc.nextDouble();
		while (donGia <= 0) {
			System.out.println("đơn giá > 0. Vui lòng nhập lại !");
			donGia = sc.nextDouble();
		}
		System.out.println(
				"Nhập loại khách hàng:\n" + "1.Khách hàng Viet Nam.\n" + "2.Khách hàng nước ngoài.\n" + "Lựa chọn: ");
		while (!sc.hasNextInt()) {
			System.out.println("Sai định dạng. Vui lòng nhập lại !");
			sc.next();
		}
		KhachHang kh = null;
		int choise = sc.nextInt();
		switch (choise) {
			case 1:
				sc.nextLine();
				System.out.println("Nhập đối tượng kh((sinh hoạt, kinh doanh, sản xuất): ");
				while (!sc.hasNextLine()) {
					System.out.println("Sai định dạng. Vui lòng nhập lại !");
					sc.next();
				}
				String doiTuong = sc.nextLine();
				System.out.println("Nhập định mức: ");
				while (!sc.hasNextLine()) {
					System.out.println("Sai định dạng. Vui lòng nhập lại !");
					sc.next();
				}
				double dinhMuc = sc.nextDouble();
				kh = new KhachHangVietNam(maKh, hoTen, ngayNhap, soLuong, donGia, doiTuong, dinhMuc);
				break;
			case 2:
				System.out.println("Nhập quốc tịch: ");
				String quocTich = sc.nextLine();
				kh = new KhachHangNuocNgoai(maKh, hoTen, ngayNhap, soLuong, donGia, quocTich);
				break;
		}
		return kh;
	}

	public static void xuatKhVn() {
		for (KhachHang obj : dsKh.xuatAllDS()) {
			if (obj instanceof KhachHangVietNam) {
				System.out.println(obj);
			}
		}
	}

	public static void xuatKhNn() {
		for (KhachHang obj : dsKh.xuatAllDS()) {
			if (obj instanceof KhachHangNuocNgoai) {
				System.out.println(obj);
			}
		}
	}

	public static void titleKhVn() {
		System.out.println(String.format(
				"\n|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s"
						+ "|",
				"Mã KH", "Họ tên", "Ngày ra HD", "Số lượng(kw)", "Đơn giá", "Đối tượng KH", "Định mức(kw)"));
	}

	public static void titleKhNn() {
		System.out.println(String.format(
				"\n|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|",
				"Mã KH", "Họ tên", "Ngày ra HD", "Số lượng(kw)", "Đơn giá", "Quốc tịch"));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar ngayNhap = null;
		dsKh = new DanhSachKhachHang();
		menu();
		int choise = sc.nextInt();
		while (choise != 11) {
			switch (choise) {
				case 1:
					nhapcung();
					KhachHang newGd = InputGD();
					boolean status = dsKh.addGiaoDich(newGd);
					if (status) {
						System.out.println("Thêm thành công !");
						System.out.println("Danh sách khách hàng Viet Nam:");
						titleKhVn();
						xuatKhVn();
						System.out.println("\nDanh sách khách hàng nước ngoài:");
						titleKhNn();
						xuatKhNn();
					} else
						System.out.println("Thêm thất bại !");
					break;
				case 2:
					System.out.println("Danh sách khách hàng trước khi xóa:");
					System.out.println("Danh sách khách hàng Viet Nam:");
					titleKhVn();
					xuatKhVn();
					System.out.println("Danh sách khách hàng nước ngoài:");
					titleKhNn();
					xuatKhNn();
					sc.nextLine();
					System.out.println("Nhập mã khách hàng để xóa:");
					String maGd = sc.nextLine();
					status = dsKh.deleteGiaoDich(maGd);
					if (status) {
						System.out.println("Đã xóa thành công.");
					} else
						System.out.println("Fail !");
					System.out.println("Danh sách khách hàng sau khi xóa:");
					System.out.println("Danh sách khách hàng Viet Nam:");
					titleKhVn();
					xuatKhVn();
					System.out.println("Danh sách khách hàng nước ngoài:");
					titleKhNn();
					xuatKhNn();
					break;
				case 3:
					System.out.println("Danh sách khách hàng trước khi sửa:");
					System.out.println("Danh sách khách hàng Viet Nam:");
					titleKhVn();
					xuatKhVn();
					System.out.println("Danh sách khách hàng nước ngoài:");
					titleKhNn();
					xuatKhNn();
					sc.nextLine();
					System.out.println("Nhập mã khách hàng để sửa:");
					String maKhS = sc.nextLine();
					KhachHang object = dsKh.searchGiaoDich(maKhS);
					if (object != null) {
						System.out.println("Nhập họ tên: ");
						String hoTen = sc.nextLine();
						try {
							System.out.println("Ngày nhập(dd/MM/yyyy):");
							String time = sc.next();
							while (dsKh.CheckValidate(time) == false) {
								time = sc.next();
							}
							Date date = dateFormat.parse(time); // Convert String to Date
							ngayNhap = dsKh.dateToCalendar(date); // Convert Date to Calendar
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Nhập số lượng:");
						while (!sc.hasNextDouble()) {
							System.out.println("Vui lòng nhập đúng định dạng !");
							sc.next();
						}
						double soLuong = sc.nextDouble();
						while (soLuong <= 0) {
							System.out.println("Số lượng > 0. Vui lòng nhập lại !");
							soLuong = sc.nextDouble();
						}
						System.out.println("Nhập đơn giá:");
						while (!sc.hasNextDouble()) {
							System.out.println("Vui lòng nhập đúng định dạng !");
							sc.next();
						}
						double donGia = sc.nextDouble();
						while (donGia <= 0) {
							System.out.println("đơn giá > 0. Vui lòng nhập lại !");
							donGia = sc.nextDouble();
						}
						System.out.println("Nhập loại khách hàng:\n" + "1.Khách hàng Viet Nam.\n"
								+ "2.Khách hàng nước ngoài.\n" + "Lựa chọn: ");
						while (!sc.hasNextInt()) {
							System.out.println("Sai định dạng. Vui lòng nhập lại !");
							sc.next();
						}
						// KhachHang kh = null;
						choise = sc.nextInt();
						switch (choise) {
							case 1:
								sc.nextLine();
								System.out.println("Nhập đối tượng kh((sinh hoạt, kinh doanh, sản xuất): ");
								while (!sc.hasNextLine()) {
									System.out.println("Sai định dạng. Vui lòng nhập lại !");
									sc.next();
								}
								String doiTuong = sc.nextLine();
								System.out.println("Nhập định mức: ");
								while (!sc.hasNextLine()) {
									System.out.println("Sai định dạng. Vui lòng nhập lại !");
									sc.next();
								}
								double dinhMuc = sc.nextDouble();
								if (object instanceof KhachHangVietNam) {
									KhachHangVietNam kh = (KhachHangVietNam) object;
									kh.setHoTen(hoTen);
									kh.setNgayRaHD(ngayNhap);
									kh.setSoLuong(soLuong);
									kh.setDonGia(donGia);
									kh.setDoiTuongKh(doiTuong);
									kh.setDinhMuc(dinhMuc);
								}
								break;
							case 2:
								System.out.println("Nhập quốc tịch: ");
								String quocTich = sc.nextLine();
								KhachHangNuocNgoai khnn = (KhachHangNuocNgoai) object;
								khnn.setHoTen(hoTen);
								khnn.setNgayRaHD(ngayNhap);
								khnn.setSoLuong(soLuong);
								khnn.setDonGia(donGia);
								khnn.setQuocTich(quocTich);
								break;
						}
						System.out.println("Danh sách khách hàng sau khi sửa:");
						System.out.println("Danh sách khách hàng Viet Nam:");
						titleKhVn();
						xuatKhVn();
						System.out.println("Danh sách khách hàng nước ngoài:");
						titleKhNn();
						xuatKhNn();
					}
					break;
				case 4:
					sc.nextLine();
					System.out.println("Nhập mã khách hàng tìm kiếm:");
					String maGD = sc.nextLine();
					KhachHang obj = dsKh.searchGiaoDich(maGD);
					if (obj != null && obj instanceof KhachHangVietNam) {
						System.out.println("Danh sách khách hàng Viet Nam:");
						titleKhVn();
						System.out.println(obj);
					} else if (obj != null && obj instanceof KhachHangNuocNgoai) {
						System.out.println("Danh sách khách hàng nước ngoài:");
						titleKhNn();
						System.out.println(obj);
					} else {
						System.out.println("Không tìm thấy khách hàng nào.");
					}
					break;
				case 5:
					System.out.println("Danh sách toàn bộ khách hàng:");
					System.out.println("Danh sách khách hàng Viet Nam:");
					titleKhVn();
					xuatKhVn();
					System.out.println("Danh sách khách hàng nước ngoài:");
					titleKhNn();
					xuatKhNn();
					break;
				case 9:
					dsKh.sapXepTheoNgay();
					System.out.println("Danh sách toàn bộ giao dịch:");
					System.out.println("Danh sách khách hàng Viet Nam:");
					titleKhVn();
					xuatKhVn();
					System.out.println("Danh sách khách hàng nước ngoài:");
					titleKhNn();
					xuatKhNn();
					break;
				case 10:
					dsKh.sapXepTheoDonGia();
					System.out.println("Danh sách toàn bộ giao dịch:");
					System.out.println("Danh sách khách hàng Viet Nam:");
					titleKhVn();
					xuatKhVn();
					System.out.println("Danh sách khách hàng nước ngoài:");
					titleKhNn();
					xuatKhNn();
					break;

			}
			menu();
			choise = sc.nextInt();
			if (choise < 0 || choise > 11) {
				System.out.println("Chọn sai. Vui lòng nhập lại !");
				choise = sc.nextInt();
			} else if (choise == 11)
				break;
		}
	}
}
