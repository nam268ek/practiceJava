package tuan4GiaoDich;

import java.util.Calendar;

public class GiaoDichVang extends GiaoDich {
	private String loaiVang;

	public String getLoaiVang() {
		return loaiVang;
	}

	public void setLoaiVang(String loaiVang) {
		this.loaiVang = loaiVang;
	}

	public GiaoDichVang(String maGaoDich, Calendar ngayNhap, double donGia, int soLuong, String loaiVang) {
		super(maGaoDich, ngayNhap, donGia, soLuong);
		this.loaiVang = loaiVang;
	}

	public GiaoDichVang() {
		super();
		// TODO Auto-generated constructor stub

	}

	public GiaoDichVang(String maGaoDich, Calendar ngayNhap, double donGia, int soLuong) {
		super(maGaoDich, ngayNhap, donGia, soLuong);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double thanhTien() {
		double thanhTien = getSoLuong() * getDonGia();
		return thanhTien;
	}

	@Override
	public String toString() {
		String s = String.format("%15s" + "|", getLoaiVang());
		return super.toString() + s;
	}

}
