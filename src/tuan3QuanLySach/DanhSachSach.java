package tuan3QuanLySach;

import java.util.ArrayList;

public class DanhSachSach {
	static ArrayList<Sach> listSach = new ArrayList<Sach>();

	public void addSach(Sach book) {
		if (!listSach.equals(book)) {
			listSach.add(book);
		}
	}

	public double sumMoneySGK() {
		double sum = 0;
		for (Sach book : listSach) {
			if (book instanceof SachGiaoKhoa) {
				sum += book.getDonGia();
			}
		}
		return sum;
	}

	public double sumMoneySTK() {
		double sum = 0;
		for (Sach book : listSach) {
			if (book instanceof SachThamKhao) {
				sum += book.getDonGia();
			}
		}
		return sum;
	}

	public ArrayList<Sach> xuatDS() {
		return listSach;
	}

	public double trungBinhCong() {
		double sum = 0;
		int count = 0;
		for (Sach book : listSach) {
			if (book instanceof SachThamKhao) {
				sum += book.getDonGia();
				count++;
			}
		}
		return sum / count;
	}
	
}
