package tuan3ChuyenXe;

import java.util.Scanner;

public class TestChuyenXe {

	static DanhSachChuyenXe dsChuyenXe;

	public static void Menu() {
		System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ CHUYẾN XE");
		System.out.println("1.Thêm chuyến xe.");
		System.out.println("2.Xóa chuyến xe.");
		System.out.println("3.Sửa chuyến xe.");
		System.out.println("4.Danh sách chuyến xe.");
		System.out.println("5.Tổng doanh thu chuyến xe.");
		System.out.println("6.Tìm kiếm chuyến xe.");
		System.out.println("0.Thoát.");
		System.out.println("Choise:");
	}

	public static void nhapcung() {
		ChuyenXe cx1 = new NoiThanh("11a", 12, 1000000, "Nguyen Van A", "D1", 120);
		ChuyenXe cx2 = new NoiThanh("12a", 13, 1340000, "Nguyen Van B", "D2", 120);
		ChuyenXe cx3 = new NoiThanh("13a", 14, 3400000, "Nguyen Van C", "D3", 120);
		ChuyenXe cx4 = new NgoaiThanh("14a", 15, 3400000, "Nguyen Van A", "Hà nội", 90);
		ChuyenXe cx5 = new NgoaiThanh("15a", 16, 3400000, "Nguyen Van B", "Hà nội", 90);
		ChuyenXe cx6 = new NgoaiThanh("16a", 17, 3400000, "Nguyen Van C", "Hà nội", 90);

		dsChuyenXe.addChuyenXe(cx1);
		dsChuyenXe.addChuyenXe(cx2);
		dsChuyenXe.addChuyenXe(cx3);
		dsChuyenXe.addChuyenXe(cx4);
		dsChuyenXe.addChuyenXe(cx5);
		dsChuyenXe.addChuyenXe(cx6);
	}

	public static void titleNoiThanh() {
		System.out.println(String.format(
				"\n|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|",
				"Mã CX", "Số xe", "Doanh thu", "Họ tên", "Số tuyến", "Số Km"));
	}

	public static void titleNgoaiThanh() {
		System.out.println(String.format(
				"\n|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|",
				"Mã CX", "Số xe", "Doanh thu", "Họ tên", "Nơi đến", "Số ngày"));
	}

	public static void xuatNoiThanh() {
		for (ChuyenXe cx : dsChuyenXe.listCx) {
			if (cx instanceof NoiThanh) {
				System.out.println(cx);
			}
		}
	}

	public static void xuatNgoaiThanh() {
		for (ChuyenXe cx : dsChuyenXe.listCx) {
			if (cx instanceof NgoaiThanh) {
				System.out.println(cx);
			}
		}
	}

	public static ChuyenXe nhapmem() {
		ChuyenXe cx = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã chuyến xe:");
		String m = sc.nextLine();
		System.out.println("Nhập số xe: ");
		int sx = sc.nextInt();
		System.out.println("Nhập doanh thu: ");
		long dt = sc.nextLong();
		sc.nextLine();
		System.out.println("Nhập họ tên: ");
		String ht = sc.nextLine();
		System.out.println(
				"Nhập loại chuyến xe:\n" + "1.Chuyến xe nội thành\n" + "2.Chuyến xe ngoại thành\n" + "Lựa chọn:");
		int lc = sc.nextInt();
		switch (lc) {
			case 1:
				sc.nextLine();
				System.out.println("Nhập số tuyến:");
				String st = sc.nextLine();
				System.out.println("Nhập số km:");
				int sk = sc.nextInt();
				cx = new NoiThanh(m, sx, dt, ht, st, sk);
				break;
			case 2:
				sc.nextLine();
				System.out.println("Nhập nơi đến:");
				String nd = sc.nextLine();
				System.out.println("Nhập số ngày:");
				int ns = sc.nextInt();
				cx = new NgoaiThanh(m, sx, dt, ht, nd, ns);
				break;
		}
		return cx;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dsChuyenXe = new DanhSachChuyenXe();
		Menu();
		int choise = sc.nextInt();
		while (choise != 0) {
			switch (choise) {
				case 1:
					nhapcung();
					ChuyenXe newCh = nhapmem();
					boolean status = dsChuyenXe.addChuyenXe(newCh);
					if (status) {
						System.out.println("Đã thêm thành công");
						System.out.println("Danh sách chuyến xe nội thành: ");
						titleNoiThanh();
						xuatNoiThanh();
						System.out.println("Danh sách chuyến xe ngoai thành: ");
						titleNgoaiThanh();
						xuatNgoaiThanh();
					} else {
						System.out.println("Đã tồn tại mã chuyến xe");
					}
					break;
				case 2:
					System.out.println("Danh sách chuyến xe trước khi xóa:");
					System.out.println("Danh sách chuyến xe nội thành: ");
					titleNoiThanh();
					xuatNoiThanh();
					System.out.println("Danh sách chuyến xe ngoai thành: ");
					titleNgoaiThanh();
					xuatNgoaiThanh();
					sc.nextLine();
					System.out.println("Nhập mã chuyến:");
					String mdc = sc.nextLine();
					status = dsChuyenXe.deleteChuyenXe(mdc);
					if (status) {
						System.out.println("Đã xóa chuyến thành công.");
						System.out.println("Danh sách chuyến xe sau khi xóa:");
						System.out.println("Danh sách chuyến xe nội thành: ");
						titleNoiThanh();
						xuatNoiThanh();
						System.out.println("Danh sách chuyến xe ngoai thành: ");
						titleNgoaiThanh();
						xuatNgoaiThanh();
					} else {
						System.out.println("Không tìm thấy chuyến này.");
					}
					break;
				case 3:
					System.out.println("Danh sách chuyến xe trước khi sửa:");
					System.out.println("Danh sách chuyến xe nội thành: ");
					titleNoiThanh();
					xuatNoiThanh();
					System.out.println("Danh sách chuyến xe ngoai thành: ");
					titleNgoaiThanh();
					xuatNgoaiThanh();
					sc.nextLine();
					System.out.println("Nhập mã chuyến:");
					String mdc1 = sc.nextLine();
					ChuyenXe obj = dsChuyenXe.searchChuyenXe(mdc1);
					if (obj != null) {
						if (obj instanceof NgoaiThanh) {
							NgoaiThanh ngt = (NgoaiThanh) obj;
							System.out.println("Nhập số xe mới:");
							int nx = sc.nextInt();
							System.out.println("Nhập doanh thu mới:");
							int dtm = sc.nextInt();
							sc.nextLine();
							System.out.println("Nhập họ tên mới: ");
							String ht = sc.nextLine();
							System.out.println("Nhập nơi đến mới: ");
							String nd = sc.nextLine();
							System.out.println("Nhập số ngày mới: ");
							int ns = sc.nextInt();
							ngt.setSoXe(nx);
							ngt.setDoanhThu(dtm);
							ngt.setHoTen(ht);
							ngt.setNoiDen(nd);
							ngt.setSoNgay(ns);
							System.out.println("Danh sách chuyến xe nội thành: ");
							titleNoiThanh();
							xuatNoiThanh();
							System.out.println("Danh sách chuyến xe ngoai thành: ");
							titleNgoaiThanh();
							xuatNgoaiThanh();

						} else if (obj instanceof NoiThanh) {
							NoiThanh nt = (NoiThanh) obj;
							System.out.println("Nhập số xe mới:");
							int nx = sc.nextInt();
							System.out.println("Nhập doanh thu mới:");
							int dtm = sc.nextInt();
							System.out.println("Nhập họ tên mới: ");
							String ht = sc.nextLine();
							System.out.println("Nhập số tuyến mới: ");
							String ntm = sc.nextLine();
							System.out.println("Nhập số km mới: ");
							int nkm = sc.nextInt();
							nt.setSoXe(nx);
							nt.setDoanhThu(dtm);
							nt.setHoTen(ht);
							nt.setSoTuyen(ntm);
							nt.setSoKm(nkm);
							System.out.println("Danh sách chuyến xe nội thành: ");
							titleNoiThanh();
							xuatNoiThanh();
							System.out.println("Danh sách chuyến xe ngoai thành: ");
							titleNgoaiThanh();
							xuatNgoaiThanh();
						}
					} else {
						System.out.println("Không tìm thấy chuyến này.");
					}
					break;
				case 4:
					System.out.println("Danh sách chuyến xe:");
					System.out.println("Danh sách chuyến xe nội thành: ");
					titleNoiThanh();
					xuatNoiThanh();
					System.out.println("Danh sách chuyến xe ngoai thành: ");
					titleNgoaiThanh();
					xuatNgoaiThanh();
					break;
				case 5:
					long doanhThuNoiThanh = 0;
					long doanhThuNgoaiThanh = 0;
					for (ChuyenXe chuyenXe : dsChuyenXe.listCx) {
						if (chuyenXe instanceof NoiThanh) {
							doanhThuNoiThanh += chuyenXe.getDoanhThu();
						} else
							doanhThuNgoaiThanh += chuyenXe.getDoanhThu();
					}
					System.out.println("Tổng doanh thu nội thành: " + String.format("%,2d", doanhThuNoiThanh) + " VNĐ");
					System.out.println(
							"Tổng doanh thu ngoại thành: " + String.format("%,2d", doanhThuNgoaiThanh) + " VNĐ");

					break;
				case 6:
					sc.nextLine();
					System.out.println("Nhập mã chuyến xe:");
					String mCx = sc.nextLine();
					ChuyenXe key = dsChuyenXe.searchChuyenXe(mCx);
					if (key != null && key instanceof NoiThanh) {
						System.out.println("Danh sách chuyến xe nội thành:");
						titleNoiThanh();
						System.out.println(key);
					} else if (key != null && key instanceof NgoaiThanh) {
						System.out.println("Danh sách chuyến xe ngoai thành:");
						titleNgoaiThanh();
						System.out.println(key);
					}
					break;
			}
			Menu();
			choise = sc.nextInt();
			while (choise < 0 || choise > 6) {
				System.out.println("Chọn sai. Vui lòng nhập lại !");
				choise = sc.nextInt();
			}
		}
		System.out.println("Application closed !");
	}
}
