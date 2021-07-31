package tuan3QuanLySach;

import java.util.Calendar;

public class SachThamKhao extends Sach {
	private double thue;

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = getDonGia() * getSoLuong() * (thue / 100);
	}

	public SachThamKhao(int maSach, int soLuong, Calendar ngayNhap, double donGia, String nhaXuatBan, double thue) {
		super(maSach, soLuong, ngayNhap, donGia, nhaXuatBan);
		this.thue = thue;
	}

	public SachThamKhao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SachThamKhao(int maSach, int soLuong, Calendar ngayNhap, double donGia, String nhaXuatBan) {
		super(maSach, soLuong, ngayNhap, donGia, nhaXuatBan);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double thanhTien() {
		double thanhTien = getSoLuong() * getDonGia() + getThue();
		return thanhTien;
	}

	@Override
	public String toString() {
		String thue = getThue() + "%";
		String s = String.format("%20s" + "|" + "%20s" + "|", "", thue);
		return super.toString() + s;
	}

}
