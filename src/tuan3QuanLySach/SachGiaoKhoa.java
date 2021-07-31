package tuan3QuanLySach;

import java.util.Calendar;

public class SachGiaoKhoa extends Sach {
	private String tinhTrang;

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public SachGiaoKhoa(int maSach, int soLuong, Calendar ngayNhap, double donGia, String nhaXuatBan,
			String tinhTrang) {
		super(maSach, soLuong, ngayNhap, donGia, nhaXuatBan);
		this.tinhTrang = tinhTrang;
	}

	public SachGiaoKhoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SachGiaoKhoa(int maSach, int soLuong, Calendar ngayNhap, double donGia, String nhaXuatBan) {
		super(maSach, soLuong, ngayNhap, donGia, nhaXuatBan);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double thanhTien() {
		double thanhTien = 0;
		if (getTinhTrang() == "new") {
			thanhTien = getSoLuong() * getDonGia();
		} else {
			thanhTien = getSoLuong() * getDonGia() * 0.5;
		}
		return thanhTien;
	}

	@Override
	public String toString() {
		String s = String.format("%20s" + "|" + "%20s" + "|", getTinhTrang(), "");
		return super.toString() + s;
	}

}
