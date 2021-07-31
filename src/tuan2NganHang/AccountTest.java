package tuan2NganHang;

import java.util.Scanner;

public class AccountTest {
	static Account[] accList;

	public static void Menu() {
		System.out.println("CHUONG TRING NGAN HANG");
		System.out.println("1.Them tai khoan.");
		System.out.println("2.So TK hien co.");
		System.out.println("3.In thong tin tat ca TK.");
		System.out.println("4.Nap tien vao TK.");
		System.out.println("5.Rut tien.");
		System.out.println("6.Chuyen tien.");
		System.out.println("7.Ket thuc.");
		System.out.println("Choise:");
	}

	public static void main(String[] args) {
		Account acc = new Account();
		AccountList dsAcc = new AccountList(10);
		Scanner input = new Scanner(System.in);
		int chon = -1;
		long soTaiKhoan;
		double soTienNap = 0;
		double soTienRut = 0;
		double soTienChuyen = 0;		
		boolean status;		
		Account accTim;
		Menu();
		chon = input.nextInt();
		if (chon == 0) {
			System.out.println("Xin Cam on!!!");
		}
		while (chon != 0) {
			switch (chon) {
			case 1:
				acc = nhapThongTin();
				status = dsAcc.ThemAcc(acc);
				if (status)
					System.out.println("Thanh cong");
				System.out.println("Fail !");
				break;
			case 2:
				int sl = dsAcc.SoLuongTK(accList);
				if (sl != 0)
					System.out.println("So luong TK la:" + sl);
				System.out.println("Emperty !");
				break;
			case 3:
				tieude();
				dsAcc.XuatDS(accList);
				break;
			case 4:
				System.out.println("Nhập số tài khoản cần nạp:");
				soTaiKhoan = input.nextLong();
				accTim = dsAcc.timAcc(soTaiKhoan);
				if (accTim != null) {
					while (soTienNap < 0) {
						System.out.println("Số tiền nạp:");
						soTienNap = input.nextDouble();
					}
					accTim.napTienTK(accTim, soTienNap);
				} else
					System.out.println("Tài khoản không tồn tại");
				break;
			case 5:
				System.out.println("Nhập tài khoản cần rút:");
				soTaiKhoan = input.nextLong();
				accTim = dsAcc.timAcc(soTaiKhoan);
				if (accTim != null) {
					while (soTienRut < 0) {
						System.out.println("Số tiền rut:");
						soTienRut = input.nextDouble();
					}
					accTim.rutTienTK(accTim, soTienRut);
				} else
					System.out.println("Tài khoản không tồn tại");
				break;
			case 6:
				System.out.println("Nhập tài khoản cần chuyển:");
				soTaiKhoan = input.nextLong();
				accTim = dsAcc.timAcc(soTaiKhoan);
				if (accTim != null) {
					Account accTo = null;
					while (accTo == null) {
						System.out.println("Nhập tài khoản đến:");
						soTaiKhoan = input.nextLong();
						accTo = dsAcc.timAcc(soTaiKhoan);
					}
					while (soTienChuyen < 0) {
						System.out.println("Số tiền chuyển:");
						soTienChuyen = input.nextDouble();
					}
					status = accTim.chuyenKhoan(accTim, accTo, soTienChuyen);
					if (status)
						System.out.println("Thành công !");
					System.out.println("Thất bại");
				} else
					System.out.println("Tài khoản không tồn tại");
				break;
			case 7:
				break;
			default:
				System.out.println("Lua chon sai");
				break;
			}
			Menu();
			chon = input.nextInt();
			if (chon == 0) {
				System.out.println("Xin cam on!!!");
				break;
			}
		}
	}

	public static void nhapCung(AccountList accList) {
		Account acc = new Account();

		acc = new Account(101, "\t Nguyễn Văn Hùng", 30000000);
		accList.ThemAcc(acc);
		acc = new Account(102, "\t Lý Huy Vân", 15000000);
		accList.ThemAcc(acc);
		acc = new Account(103, "\t Phan Sang Vô", 25000000);
		accList.ThemAcc(acc);
		acc = new Account(104, "\t Đoàn Văn Đức", 50000000);
		accList.ThemAcc(acc);
		acc = new Account(105, "\t Trương Công", 400000);
		accList.ThemAcc(acc);
	}

	public static void tieude() {
		System.out.println(String.format(
				"|" + "%-8d" + "|" + "%-20s" + "|" + "%-8s" + "|" + "%12.1f" + "|" + "%20.1f" + "|" + "%20.1f" + "|",
				"soTK", "tenTK", "trangThai", "So du"));
	}

	public static Account nhapThongTin() {
		long sTK;
		String tTK;
		double mTK;

		Scanner input = new Scanner(System.in);
		Account acc = new Account();

		System.out.println("Số tài khoản: ");
		sTK = input.nextLong();
		System.out.println("Tên tài khoản: ");
		input.nextLine();
		tTK = input.nextLine();
		System.out.println("Số tiền trong tài khoản: ");
		mTK = input.nextDouble();
		acc.setsTK(sTK);
		acc.setTenTK(tTK);
		acc.setMoney(mTK);
		return acc;
	}
}
