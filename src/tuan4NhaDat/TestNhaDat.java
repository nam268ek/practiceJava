package tuan4NhaDat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestNhaDat {
	static ArrayList<tuan4NhaDat.GiaoDich> listGD = new ArrayList<tuan4NhaDat.GiaoDich>();
	static DanhSachGiaoDich dsNhaDat;

	public static void nhapcung() {
		Calendar ngayNhap1 = new GregorianCalendar(2021, 2, 12);
		Calendar ngayNhap2 = new GregorianCalendar(2019, 3, 24);
		Calendar ngayNhap3 = new GregorianCalendar(2013, 8, 24);

		tuan4NhaDat.GiaoDich gd1 = new GiaoDichDat("11a", ngayNhap1, 200000000, 12, "A");
		tuan4NhaDat.GiaoDich gd2 = new GiaoDichDat("12a", ngayNhap2, 300000000, 34, "A");
		tuan4NhaDat.GiaoDich gd3 = new GiaoDichDat("13a", ngayNhap1, 40000000, 6, "B");
		tuan4NhaDat.GiaoDich gd4 = new GiaoDichDat("14a", ngayNhap2, 56000000, 12, "C");
		tuan4NhaDat.GiaoDich gd5 = new GiaoDichNha("15a", ngayNhap1, 200234000, 12, "cao cấp", "Long An");
		tuan4NhaDat.GiaoDich gd6 = new GiaoDichNha("16a", ngayNhap2, 35685700, 22, "cao cấp", "Bình Phước");
		tuan4NhaDat.GiaoDich gd7 = new GiaoDichNha("17a", ngayNhap1, 256546740, 122, "thường", "Kon Tum");
		tuan4NhaDat.GiaoDich gd8 = new GiaoDichNha("18a", ngayNhap2, 678678444, 566, "thường", "Dak Nông");
		tuan4NhaDat.GiaoDich gd9 = new GiaoDichNha("19a", ngayNhap3, 678678444, 566, "thường", "Dak Nông");

		dsNhaDat.addGiaoDich(gd1);
		dsNhaDat.addGiaoDich(gd2);
		dsNhaDat.addGiaoDich(gd3);
		dsNhaDat.addGiaoDich(gd4);
		dsNhaDat.addGiaoDich(gd5);
		dsNhaDat.addGiaoDich(gd6);
		dsNhaDat.addGiaoDich(gd7);
		dsNhaDat.addGiaoDich(gd8);
		dsNhaDat.addGiaoDich(gd9);

	}

	public static tuan4NhaDat.GiaoDich InputGD() {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar ngayNhap = null;
		tuan4NhaDat.GiaoDich gd = null;
		System.out.println("Nhập mã giao dịch: ");
		String maGD = sc.nextLine();
		try {
			System.out.println("Ngày nhập(dd/MM/yyyy):");
			String time = sc.next();
			while (dsNhaDat.CheckValidate(time) == false) {
				time = sc.next();
			}
			Date date = dateFormat.parse(time); // Convert String to Date
			ngayNhap = dsNhaDat.dateToCalendar(date); // Convert Date to Calendar
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
		System.out.println("Nhập diện tích:");
		while (!sc.hasNextDouble()) {
			System.out.println("Vui lòng nhập đúng định dạng !");
			sc.next();
		}
		double dienTich = sc.nextDouble();
		while (dienTich <= 0) {
			System.out.println("Diện tích > 0. Vui lòng nhập lại !");
			dienTich = sc.nextDouble();
		}
		System.out.println("Nhập loại giao dịch:\n" + "1.Giao dịch đất.\n" + "2.Giao dịch nhà.\n" + "Lựa chọn: ");
		while (!sc.hasNextInt()) {
			System.out.println("Sai định dạng. Vui lòng nhập lại !");
			sc.next();
		}
		int choise = sc.nextInt();
		switch (choise) {
			case 1:
				sc.nextLine();
				System.out.println("Nhập loại đất(A,B,C): ");
				while (!sc.hasNextLine()) {
					System.out.println("Sai định dạng. Vui lòng nhập lại !");
					sc.next();
				}
				String loaiDat = sc.nextLine();
				gd = new GiaoDichDat(maGD, ngayNhap, donGia, dienTich, loaiDat);
				break;
			case 2:
				System.out.println("Nhập loại nhà(cao cấp, thường): ");
				String loaiNha = sc.nextLine();
				System.out.println("Nhập địa chỉ: ");
				String diaChi = sc.nextLine();
				gd = new GiaoDichNha(maGD, ngayNhap, donGia, dienTich, loaiNha, diaChi);
				break;
		}
		return gd;
	}

	public static void xuatGdDat() {
		for (tuan4NhaDat.GiaoDich obj : dsNhaDat.xuatAllDS()) {
			if (obj instanceof GiaoDichDat) {
				System.out.println(obj);
			}
		}
	}

	public static void xuatGdNha() {
		for (tuan4NhaDat.GiaoDich obj : dsNhaDat.xuatAllDS()) {
			if (obj instanceof GiaoDichNha) {
				System.out.println(obj);
			}
		}
	}

	public static void menu() {
		System.out.println("\nCHƯƠNG TRÌNG QUẢN LÝ GIAO DỊCH NHÀ ĐẤT");
		System.out.println("1.Thêm giao dịch.");
		System.out.println("2.Xóa giao dịch.");
		System.out.println("3.Sửa giao dịch.");
		System.out.println("4.Tìm kiếm giao dịch.");
		System.out.println("5.Xuất danh sách.");
		System.out.println("6.Tổng số lượng cho từng loại.");
		System.out.println("7.Trung bình thành tiền của giao dịch đất.");
		System.out.println("8.Xuất ra các giao dịch của tháng 9/2013");
		System.out.println("9.Sắp xếp giao dịch theo ngày.");
		System.out.println("10.Sắp xếp giao dịch theo đơn giá.");
		System.out.println("11.Sắp xếp giao dịch theo loại đất.");
		System.out.println("12.Thoát.");
		System.out.println("Lựa chọn:");
	}

	public static void titleDat() {
		System.out
				.println(String.format("\n|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%12s" + "|" + "%15s" + "|",
						"Mã GD", "Ngày giao dịch", "Đơn giá", "Diện tích", "Loại đất"));
	}

	public static void titleNha() {
		System.out.println(String.format(
				"\n|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%12s" + "|" + "%15s" + "|" + "%15s" + "|",
				"Mã GD", "Ngày giao dịch", "Đơn giá", "Diện tích", "Loại nhà", "Địa chỉ"));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar ngayNhap = null;
		dsNhaDat = new DanhSachGiaoDich();
		menu();
		int choise = sc.nextInt();
		while (choise != 12) {
			switch (choise) {
				case 1:
					nhapcung();
					tuan4NhaDat.GiaoDich newGd = InputGD();
					boolean status = dsNhaDat.addGiaoDich(newGd);
					if (status) {
					System.out.println("Thêm thành công !");
					System.out.println("Danh sách giao dịch nhà:");
					titleNha();
					xuatGdNha();
					System.out.println("\nDanh sách giao dịch đất:");
					titleDat();
					xuatGdDat();
					} else
					System.out.println("Thêm thất bại !");
					break;
				case 2:
					System.out.println("Danh sách giao dịch trước khi xóa:");
					System.out.println("Danh sách giao dịch nhà:");
					titleNha();
					xuatGdNha();
					System.out.println("Danh sách giao dịch đất:");
					titleDat();
					xuatGdDat();
					sc.nextLine();
					System.out.println("Nhập mã giao dịch để xóa:");
					String maGd = sc.nextLine();
					status = dsNhaDat.deleteGiaoDich(maGd);
					if (status) {
						System.out.println("Đã xóa thành công.");
					} else
						System.out.println("Fail !");
					System.out.println("Danh sách giao dịch sau khi xóa:");
					System.out.println("Danh sách giao dịch nhà:");
					titleNha();
					xuatGdNha();
					System.out.println("Danh sách giao dịch đất:");
					titleDat();
					xuatGdDat();
					break;
				case 3:
					System.out.println("Danh sách giao dịch trước khi sửa:");
					System.out.println("Danh sách giao dịch nhà:");
					titleNha();
					xuatGdNha();
					System.out.println("Danh sách giao dịch đất:");
					titleDat();
					xuatGdDat();
					sc.nextLine();
					System.out.println("Nhập mã giao dịch để sửa:");
					String maGdS = sc.nextLine();
					tuan4NhaDat.GiaoDich object = dsNhaDat.searchGiaoDich(maGdS);
					if (object != null) {
						try {
							System.out.println("Ngày nhập(dd/MM/yyyy):");
							String time = sc.next();
							while (dsNhaDat.CheckValidate(time) == false) {
								time = sc.next();
							}
							Date date = dateFormat.parse(time); // Convert String to Date
							ngayNhap = dsNhaDat.dateToCalendar(date); // Convert Date to Calendar
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
						System.out.println("Nhập diện tích:");
						while (!sc.hasNextDouble()) {
							System.out.println("Vui lòng nhập đúng định dạng !");
							sc.next();
						}
						double dienTich = sc.nextDouble();
						while (dienTich <= 0) {
							System.out.println("Diện tích > 0. Vui lòng nhập lại !");
							dienTich = sc.nextDouble();
						}
						System.out.println(
								"Nhập loại giao dịch:\n" + "1.Giao dịch đất.\n" + "2.Giao dịch nhà.\n" + "Lựa chọn: ");
						while (!sc.hasNextInt()) {
							System.out.println("Sai định dạng. Vui lòng nhập lại !");
							sc.next();
						}
						choise = sc.nextInt();
						switch (choise) {
							case 1:
								sc.nextLine();
								System.out.println("Nhập loại đất(A,B,C): ");
								while (!sc.hasNextLine()) {
									System.out.println("Sai định dạng. Vui lòng nhập lại !");
									sc.next();
								}
								String loaiDat = sc.nextLine();
								if (object instanceof GiaoDichDat) {
									GiaoDichDat gd = (GiaoDichDat) object;
									gd.setDienTich(dienTich);
									gd.setDonGia(donGia);
									gd.setNgayGiaoDich(ngayNhap);
									gd.setLoaiDat(loaiDat);
								}
								break;
							case 2:
								sc.nextLine();
								System.out.println("Nhập loại nhà(cao cấp, thường): ");
								String loaiNha = sc.nextLine();
								System.out.println("Nhập địa chỉ: ");
								String diaChi = sc.nextLine();
								if (object instanceof GiaoDichNha) {
									GiaoDichNha gd = (GiaoDichNha) object;
									gd.setDienTich(dienTich);
									gd.setDonGia(donGia);
									gd.setNgayGiaoDich(ngayNhap);
									gd.setLoaiNha(loaiNha);
									gd.setDiaChi(diaChi);
								}
								break;
						}
						System.out.println("Danh sách giao dịch sau khi sửa:");
						System.out.println("Danh sách giao dịch nhà:");
						titleNha();
						xuatGdNha();
						System.out.println("Danh sách giao dịch đất:");
						titleDat();
						xuatGdDat();
					}
					break;
				case 4:
					System.out.println("Nhập mã giao dịch tìm kiếm:");
					String maGD = sc.nextLine();
					tuan4NhaDat.GiaoDich obj = dsNhaDat.searchGiaoDich(maGD);
					if (obj != null && obj instanceof GiaoDichDat) {
						System.out.println("Danh sách giao dịch đất:");
						titleDat();
						System.out.println(obj);
					} else if (obj != null && obj instanceof GiaoDichNha) {
						System.out.println("Danh sách giao dịch nhà:");
						titleNha();
						System.out.println(obj);
					} else {
						System.out.println("Không tìm thấy giao dịch nào.");
					}
					break;
				case 5:
					System.out.println("Danh sách toàn bộ giao dịch:");
					System.out.println("Danh sách giao dịch nhà:");
					titleNha();
					xuatGdNha();
					System.out.println("Danh sách giao dịch đất:");
					titleDat();
					xuatGdDat();
					break;
				case 6:
					System.out.println("Tổng số lượng giao dịch Đất: " + dsNhaDat.sumGiaoDichDat());
					System.out.println("Tổng số lượng giao dịch Nhà: " + dsNhaDat.sumGiaoDichNha());
					break;
				case 7:
					long money = dsNhaDat.trungBinhThanhTienGdDat();
					//String result = money.toString();
					System.out.println("Trung bình thành tiền của giao dịch đất: " + String.format("%,2d", money) + "đ");
					break;
				case 8:
					System.out.println("Danh sách giao dịch trong 9/2013:");
					for (tuan4NhaDat.GiaoDich gd : dsNhaDat.listGD) {
						if (gd.getNgayGiaoDich().get(Calendar.MONTH) == 8
								&& gd.getNgayGiaoDich().get(Calendar.YEAR) == 2013 && gd instanceof GiaoDichDat) {
							titleDat();
							System.out.println(gd);
						} else if (gd.getNgayGiaoDich().get(Calendar.MONTH) == 8
								&& gd.getNgayGiaoDich().get(Calendar.YEAR) == 2013 && gd instanceof GiaoDichNha) {
							titleNha();
							System.out.println(gd);
						}
					}
					break;
				case 9:
					dsNhaDat.sapXepTheoNgay();
					System.out.println("Danh sách toàn bộ giao dịch:");
					System.out.println("Danh sách giao dịch nhà:");
					titleNha();
					xuatGdNha();
					System.out.println("Danh sách giao dịch đất:");
					titleDat();
					xuatGdDat();
					break;
				case 10:
					dsNhaDat.sapXepTheoDonGia();
					System.out.println("Danh sách toàn bộ giao dịch:");
					System.out.println("Danh sách giao dịch nhà:");
					titleNha();
					xuatGdNha();
					System.out.println("Danh sách giao dịch đất:");
					titleDat();
					xuatGdDat();
					break;
			}
			menu();
			choise = sc.nextInt();
			if (choise < 0 || choise > 12) {
				System.out.println("Chọn sai. Vui lòng nhập lại !");
				choise = sc.nextInt();
			} else if (choise == 12)
				break;
		}
	}
}
