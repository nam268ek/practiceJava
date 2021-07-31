package tuan3QuanLySach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestSach {
	static DanhSachSach dsSach;
	static ArrayList<Sach> allSach = new ArrayList<Sach>();

	public static void nhapcung() {
		Calendar ngayNhap1 = new GregorianCalendar(2021, 2, 12);
		Calendar ngayNhap2 = new GregorianCalendar(2019, 3, 24);

		Sach book1 = new SachGiaoKhoa(111, 20, ngayNhap1, 200000, "KimDong", "new");
		Sach book2 = new SachThamKhao(112, 21, ngayNhap2, 210000, "KimDong", 10);
		Sach book3 = new SachGiaoKhoa(113, 20, ngayNhap1, 200000, "tre", "new");
		Sach book4 = new SachThamKhao(114, 21, ngayNhap2, 210000, "tre", 10);
		Sach book5 = new SachGiaoKhoa(115, 20, ngayNhap1, 200000, "laodong", "new");
		Sach book6 = new SachThamKhao(116, 21, ngayNhap2, 210000, "laodong", 10);
		Sach book7 = new SachGiaoKhoa(117, 20, ngayNhap1, 200000, "tre", "old");
		Sach book8 = new SachGiaoKhoa(118, 20, ngayNhap1, 200000, "tre", "old");

		dsSach.addSach(book1);
		dsSach.addSach(book2);
		dsSach.addSach(book3);
		dsSach.addSach(book4);
		dsSach.addSach(book5);
		dsSach.addSach(book6);
		dsSach.addSach(book7);
		dsSach.addSach(book8);
	}

	public static void title() {
		System.out
				.println(String.format(
						"\n|" + "%-8s" + "|" + "%-8s" + "|" + "%15s" + "|" + "%12s" + "|" + "%20s" + "|" + "%20s" + "|"
								+ "%20s" + "|",
						"mã sách", "số lượng", "ngày nhập", "đơn giá", "nhà xuất bản", "tình trạng", "thuế"));
	}

	public static void xuatNXB() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nXuất ra các sách giáo khoa của nhà xuất bản");
		System.out.println("Nhập tên NXB:");
		String key = sc.nextLine();
		while (key.trim().equals("")) {
			System.out.println("Keyword không được để trống !");
			key = sc.nextLine();
		}
		title();
		for (Sach book : allSach) {
			if (book instanceof SachGiaoKhoa) {
				if (book.getNhaXuatBan().equalsIgnoreCase(key)) {
					System.out.println(book);
				}
			}
		}
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

	public static Sach InputBook() {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar ngayNhap = null;

		System.out.println("Nhập ID: ");
		int maSach = sc.nextInt();
		System.out.println("Nhập số lượng: ");
		int soLuong = sc.nextInt();
		try {
			System.out.println("Ngày nhập(dd/MM/yyyy):");
			String time = sc.next();
			while (CheckValidate(time) == false) {
				time = sc.next();
			}
			Date date = dateFormat.parse(time); // Convert String to Date
			ngayNhap = dateToCalendar(date); // Convert Date to Calendar
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
		sc.nextLine();
		System.out.println("Nhập NXB: ");
		String nhaXB = sc.nextLine();
		while (nhaXB == null) {
			System.out.println("NXB không được để trống. Vui lòng nhập lại !");
			nhaXB = sc.nextLine();
		}
		System.out.println("Nhập loại sách:\n" + "1.Sách Giáo Khoa\n" + "2.Sách Tham Khảo\n" + "Lựa chọn: ");
		while (!sc.hasNextInt()) {
			System.out.println("Sai định dạng. Vui lòng nhập lại !");
			sc.next();
		}
		int choise = sc.nextInt();
		Sach book = null;
		switch (choise) {
		case 1:
			sc.nextLine();
			System.out.println("Tình trạng(new or old): ");
			while (!sc.hasNextLine()) {
				System.out.println("Sai định dạng. Vui lòng nhập lại !");
				sc.next();
			}
			String tinhTrang = sc.nextLine();

			while (!tinhTrang.trim().equalsIgnoreCase("new") && !tinhTrang.trim().equalsIgnoreCase("old")) {
				System.out.println("Sai định dạng. Vui lòng nhập lại !");
				tinhTrang = sc.nextLine();
			}
			book = new SachGiaoKhoa(maSach, soLuong, ngayNhap, donGia, nhaXB, tinhTrang);
			break;
		case 2:
			System.out.println("Nhập Thuế: ");
			double thue = sc.nextDouble();
			book = new SachThamKhao(maSach, soLuong, ngayNhap, donGia, nhaXB, thue);
			break;
		}
		return book;
	}

	public static void main(String[] args) {
		dsSach = new DanhSachSach();
		double sumNew = 0;
		double sumOld = 0;
		double sum = 0;
		nhapcung();

		Sach book = InputBook();
		dsSach.addSach(book);
		System.out.println("Thành Công !");

		allSach = dsSach.xuatDS();
		title();
		for (Sach obj : allSach) {
			System.out.println(obj);
		}

		for (Sach obj : allSach) {
			if (obj instanceof SachGiaoKhoa && ((SachGiaoKhoa) obj).getTinhTrang() == "new")
				sumNew += obj.thanhTien();
			else if (obj instanceof SachGiaoKhoa && ((SachGiaoKhoa) obj).getTinhTrang() == "old")
				sumOld += obj.thanhTien();
			else if (obj instanceof SachThamKhao)
				sum += obj.thanhTien();
		}
		System.out.println("\nTổng tiền sách giáo khoa(new): " + String.format("%,.1f", sumNew) + "đ");
		System.out.println("Tổng tiền sách giáo khoa(old)(giảm 50%): " + String.format("%,.1f", sumOld) + "đ");
		System.out.println("Tổng tiền sách tham khảo: " + String.format("%,.1f", sum) + "đ");
		System.out.println(
				"Trung bình cộng đơn giá sách tham khảo: " + String.format("%,.1f", dsSach.trungBinhCong()) + "đ");
		xuatNXB();
	}
}
