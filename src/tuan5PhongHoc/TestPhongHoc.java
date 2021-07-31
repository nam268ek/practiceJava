package tuan5PhongHoc;

import java.util.Scanner;

public class TestPhongHoc {
	static DanhSachPhongHoc dsPh;

	public static void nhapcung() {
		PhongHoc ph1 = new PhongHocLyThuyet("11a", "d1", 50, 10, true);
		PhongHoc ph2 = new PhongHocLyThuyet("12a", "d2", 20, 15, true);
		PhongHoc ph3 = new PhongHocMayTinh("13a", "d5", 20, 10, 10);
		PhongHoc ph4 = new PhongHocMayTinh("14a", "d2", 20, 15, 5);
		PhongHoc ph7 = new PhongHocMayTinh("16a", "d2", 20, 15, 60);
		PhongHoc ph5 = new PhongHocThiNghiem("15a", "d7", 20, 10, "Hoá học", 30, true);
		PhongHoc ph6 = new PhongHocThiNghiem("16a", "d4", 40, 10, "Sinh học", 30, false);

		dsPh.addPhong(ph1);
		dsPh.addPhong(ph2);
		dsPh.addPhong(ph3);
		dsPh.addPhong(ph4);
		dsPh.addPhong(ph5);
		dsPh.addPhong(ph6);
		dsPh.addPhong(ph7);
	}

	public static PhongHoc InputGD() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập mã phòng: ");
		String maPh = sc.nextLine();
		System.out.println("Nhập dãy nhà: ");
		String dayNha = sc.nextLine();

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
		System.out.println("Nhập số bóng đèn:");
		while (!sc.hasNextInt()) {
			System.out.println("Vui lòng nhập đúng định dạng !");
			sc.next();
		}
		int soLuong = sc.nextInt();
		while (soLuong <= 0) {
			System.out.println("Số lượng > 0. Vui lòng nhập lại !");
			soLuong = sc.nextInt();
		}
		System.out.println("Nhập loại phòng:\n" + "1.Phòng học lý thuyết.\n" + "2.Phòng học Máy tính.\n"
				+ "3.Phòng học Thí nghiệm.\n" + "Lựa chọn: ");
		while (!sc.hasNextInt()) {
			System.out.println("Sai định dạng. Vui lòng nhập lại !");
			sc.next();
		}
		PhongHoc ph = null;
		int choise = sc.nextInt();
		switch (choise) {
			case 1:
				sc.nextLine();
				System.out.println("Phòng có máy chiếu hay không ?(Y/N): ");
				while (!sc.hasNextLine()) {
					System.out.println("Sai định dạng. Vui lòng nhập lại !");
					sc.next();
				}
				String isMayChieu = sc.nextLine();
				boolean mayChieu = false;
				if (isMayChieu.equalsIgnoreCase("Y")) {
					mayChieu = true;
				} else if (isMayChieu.equalsIgnoreCase("N"))
					mayChieu = false;
				ph = new PhongHocLyThuyet(maPh, dayNha, dienTich, soLuong, mayChieu);
				break;
			case 2:
				System.out.println("Nhập số máy tính: ");
				int soMayTinh = sc.nextInt();
				ph = new PhongHocMayTinh(maPh, dayNha, dienTich, soLuong, soMayTinh);
				break;
			case 3:
				sc.nextLine();
				System.out.println("Thông tin chuyên ngành: ");
				String chuyenNganh = sc.nextLine();
				System.out.println("Sức chứa: ");
				double sucChua = sc.nextDouble();
				System.out.println("Phòng có bồn rửa không ?(Y/N): ");
				String isBonRua = sc.nextLine();
				boolean bonRua = false;
				if (isBonRua.equalsIgnoreCase("Y")) {
					bonRua = true;
				} else if (isBonRua.equalsIgnoreCase("N")) {
					bonRua = false;
				}
				ph = new PhongHocThiNghiem(maPh, dayNha, dienTich, soLuong, chuyenNganh, sucChua, bonRua);
		}
		return ph;
	}

	public static void menu() {
		System.out.println("\nCHƯƠNG TRÌNG QUẢN LÝ PHÒNG HỌC");
		System.out.println("1.Thêm phòng học.");
		System.out.println("2.Tìm kiếm phòng học.");
		System.out.println("3.In danh sách phòng học.");
		System.out.println("4.In danh sách các phòng học đạt chuẩn.");
		System.out.println("5.Sắp xếp danh sách tăng dần theo cột dãy nhà.");
		System.out.println("6.Sắp xếp danh sách giảm dần theo cột diện tích.");
		System.out.println("7.Sắp xếp danh sách tăng dần theo cột số bóng đèn.");
		System.out.println("8.Cập nhật số máy tính cho một phòng máy tính.");
		System.out.println("9.Xóa một phòng học.");
		System.out.println("10.Tổng số phòng học.");
		System.out.println("11.Danh sách các phòng máy có 60 máy.");
		System.out.println("12.Thoát.");
		System.out.println("Lựa chọn:");
	}

	public static void xuatPhLyThuyet() {
		for (PhongHoc obj : dsPh.xuatAllDS()) {
			if (obj instanceof PhongHocLyThuyet) {
				System.out.println(obj);
			}
		}
	}

	public static void xuatPhMayTinh() {
		for (PhongHoc obj : dsPh.xuatAllDS()) {
			if (obj instanceof PhongHocMayTinh) {
				System.out.println(obj);
			}
		}
	}

	public static void xuatPhThiNghiem() {
		for (PhongHoc obj : dsPh.xuatAllDS()) {
			if (obj instanceof PhongHocThiNghiem) {
				System.out.println(obj);
			}
		}
	}

	public static void titleLyThuyet() {
		System.out.println(String.format(
				"\n|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|",
				"Mã phòng", "Dãy nhà", "Diện tích", "Số bóng đèn", "Máy chiếu", "Đạt chuẩn"));
	}

	public static void titleMayTinh() {
		System.out.println(String.format(
				"\n|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|",
				"Mã phòng", "Dãy nhà", "Diện tích", "Số bóng đèn", "Số máy tính", "Đạt chuẩn"));
	}

	public static void titleThiNghiem() {
		System.out.println(String.format(
				"\n|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s"
						+ "|" + "%15s" + "|",
				"Mã phòng", "Dãy nhà", "Diện tích", "Số bóng đèn", "TT chuyên ngành", "Sức chứa", "Bồn rữa",
				"Đạt chuẩn"));
	}

	public static void lyThuyetDatChuan() {
		for (PhongHoc ph : dsPh.listPh) {
			if (ph instanceof PhongHocLyThuyet && ph.datChuan()) {
				System.out.println(ph);
			}
		}
	}

	public static void mayTinhDatChuan() {
		for (PhongHoc ph : dsPh.listPh) {
			if (ph instanceof PhongHocMayTinh && ph.datChuan()) {
				System.out.println(ph);
			}
		}
	}

	public static void thiNghiemDatChuan() {
		for (PhongHoc ph : dsPh.listPh) {
			if (ph instanceof PhongHocThiNghiem && ph.datChuan()) {
				System.out.println(ph);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dsPh = new DanhSachPhongHoc();
		menu();
		int choise = sc.nextInt();
		while (choise != 12) {
			switch (choise) {
				case 1:
					nhapcung();
					PhongHoc newPh = InputGD();
					boolean status = dsPh.addPhong(newPh);
					if (status) {
						System.out.println("Thêm thành công !");
						System.out.println("Danh sách phòng học lý thuyết:");
						titleLyThuyet();
						xuatPhLyThuyet();
						System.out.println("Danh sách phòng học máy tính:");
						titleMayTinh();
						xuatPhMayTinh();
						System.out.println("Danh sách phòng học thi nghiệm:");
						titleThiNghiem();
						xuatPhThiNghiem();
					} else
						System.out.println("Thêm thất bại !");
					break;
				case 2:
					sc.nextLine();
					System.out.println("Nhập mã phòng học tìm kiếm:");
					String maPh = sc.nextLine();
					PhongHoc obj = dsPh.searchPhong(maPh);
					if (obj != null && obj instanceof PhongHocLyThuyet) {
						System.out.println("Danh sách phòng học lý thuyết:");
						titleLyThuyet();
						System.out.println(obj);
					} else if (obj != null && obj instanceof PhongHocMayTinh) {
						System.out.println("Danh sách phòng học nhà:");
						titleMayTinh();
						System.out.println(obj);
					} else if (obj != null && obj instanceof PhongHocThiNghiem) {
						System.out.println("Danh sách phòng học thi nghiệm:");
						titleThiNghiem();
						System.out.println(obj);
					} else {
						System.out.println("Không tìm thấy phòng học nào.");
					}
					break;
				case 3:
					System.out.println("Danh sách tất cả phòng học:");
					System.out.println("Danh sách phòng học lý thuyết:");
					titleLyThuyet();
					xuatPhLyThuyet();
					System.out.println("Danh sách phòng học máy tính:");
					titleMayTinh();
					xuatPhMayTinh();
					System.out.println("Danh sách phòng học thi nghiệm:");
					titleThiNghiem();
					xuatPhThiNghiem();
					break;
				case 4:
					System.out.println("Danh sách các phòng học đạt chuẩn: ");
					System.out.println("Danh sách phòng học lý thuyết:");
					titleLyThuyet();
					lyThuyetDatChuan();
					System.out.println("Danh sách phòng học máy tính:");
					titleMayTinh();
					mayTinhDatChuan();
					System.out.println("Danh sách phòng học thi nghiệm:");
					titleThiNghiem();
					thiNghiemDatChuan();
					break;
				case 5:
					System.out.println("Danh sách đã sắp xếp theo dãy: ");
					dsPh.sapXepTheoDay();
					System.out.println("Danh sách phòng học lý thuyết:");
					titleLyThuyet();
					xuatPhLyThuyet();
					System.out.println("Danh sách phòng học máy tính:");
					titleMayTinh();
					xuatPhMayTinh();
					System.out.println("Danh sách phòng học thi nghiệm:");
					titleThiNghiem();
					xuatPhThiNghiem();
					break;
				case 6:
					System.out.println("Danh sách đã sắp xếp theo diện tích: ");
					dsPh.sapXepTheoDienTich();
					System.out.println("Danh sách phòng học lý thuyết:");
					titleLyThuyet();
					xuatPhLyThuyet();
					System.out.println("Danh sách phòng học máy tính:");
					titleMayTinh();
					xuatPhMayTinh();
					System.out.println("Danh sách phòng học thi nghiệm:");
					titleThiNghiem();
					xuatPhThiNghiem();
					break;
				case 7:
					System.out.println("Danh sách đã sắp xếp theo số bóng đèn: ");
					dsPh.sapXepTheoSoBongDen();
					System.out.println("Danh sách phòng học lý thuyết:");
					titleLyThuyet();
					xuatPhLyThuyet();
					System.out.println("Danh sách phòng học máy tính:");
					titleMayTinh();
					xuatPhMayTinh();
					System.out.println("Danh sách phòng học thi nghiệm:");
					titleThiNghiem();
					xuatPhThiNghiem();
					break;
				case 8:
					System.out.println("Danh sách phòng học máy tính:");
					titleMayTinh();
					xuatPhMayTinh();
					sc.nextLine();
					System.out.println("Nhập mã phòng: ");
					String maPhong = sc.nextLine();
					PhongHoc ph = dsPh.searchPhong(maPhong);
					if (ph != null && ph instanceof PhongHocMayTinh) {
						System.out.println("Nhập số máy tính mới: ");
						int soMayTinh = sc.nextInt();
						PhongHocMayTinh p = (PhongHocMayTinh) ph;
						p.setSoMayTinh(soMayTinh);
					} else
						System.out.println("Mã phòng không thuộc phòng máy tính.");
					System.out.println("Danh sách phòng học máy tính đã update:");
					titleMayTinh();
					xuatPhMayTinh();
					break;
				case 9:
					System.out.println("Danh sách phòng học máy tính:");
					titleMayTinh();
					xuatPhMayTinh();
					sc.nextLine();
					System.out.println("Nhập mã phòng: ");
					maPhong = sc.nextLine();
					status = dsPh.deletePhong(maPhong);
					if (status) {
						System.out.println("Đã xóa thành công");
					} else
						System.out.println("Fail !");

					System.out.println("Danh sách phòng học máy tính sau khi xóa:");
					titleMayTinh();
					xuatPhMayTinh();
					break;
				case 10:
					int lt = 0;
					int mt = 0;
					int tn = 0;
					for (PhongHoc p : dsPh.listPh) {
						if (p instanceof PhongHocLyThuyet) {
							lt++;
						} else if (p instanceof PhongHocMayTinh) {
							mt++;
						} else if (p instanceof PhongHocThiNghiem) {
							tn++;
						}
					}
					System.out.println("Tổng số phòng học: ");
					System.out.println("\nPhòng lý thuyết: " + lt + " phòng");
					System.out.println("Phòng máy tính: " + mt + " phòng");
					System.out.println("Phòng thi nghiệm: " + tn + " phòng");
					break;
				case 11:
					System.out.println("Danh sách phòng máy tính có 60 máy: ");
					titleMayTinh();
					for (PhongHoc p : dsPh.listPh) {
						if (p instanceof PhongHocMayTinh && ((PhongHocMayTinh) p).getSoMayTinh() == 60) {
							System.out.println(p);
						}
					}
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
