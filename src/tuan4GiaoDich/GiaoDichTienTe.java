package tuan4GiaoDich;

import java.util.Calendar;

public class GiaoDichTienTe extends GiaoDich {

	private double tiGia;
	private String loaiTienTe;

	public double getTiGia() {
		return tiGia;
	}

	public void setTiGia(double tiGia) {
		this.tiGia = tiGia;
	}

	public String getLoaiTienTe() {
		return loaiTienTe;
	}

	public void setLoaiTienTe(String loaiTienTe) {
		this.loaiTienTe = loaiTienTe;
	}

	public GiaoDichTienTe(String maGaoDich, Calendar ngayNhap, double donGia, int soLuong, double tiGia,
			String loaiTienTe) {
		super(maGaoDich, ngayNhap, donGia, soLuong);
		this.tiGia = tiGia;
		this.loaiTienTe = loaiTienTe;
	}

	public GiaoDichTienTe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiaoDichTienTe(String maGaoDich, Calendar ngayNhap, double donGia, int soLuong) {
		super(maGaoDich, ngayNhap, donGia, soLuong);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double thanhTien() {
		// TODO Auto-generated method stub
		double thanhTien = 0;
		if (getLoaiTienTe() == "USD" || getLoaiTienTe() == "Euro")
			thanhTien = getSoLuong() * getDonGia() * getTiGia();
		else
			thanhTien = getSoLuong() * getDonGia();
		return thanhTien;
	}

	@Override
	public String toString() {
		String s = String.format( "%15s" + "|"+ "%15.1f" + "|" + "%15s" + "|", "",getTiGia(), getLoaiTienTe());
		return super.toString() + s;
	}

}
