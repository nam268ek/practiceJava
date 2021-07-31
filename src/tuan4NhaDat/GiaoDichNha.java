package tuan4NhaDat;

import java.util.Calendar;

public class GiaoDichNha extends GiaoDich {
	private String loaiNha, diaChi;

	public String getLoaiNha() {
		return loaiNha;
	}

	public void setLoaiNha(String loaiNha) {
		this.loaiNha = loaiNha;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public GiaoDichNha(String maGaoDich, Calendar ngayGiaoDich, double donGia, double dienTich, String loaiNha,
			String diaChi) {
		super(maGaoDich, ngayGiaoDich, donGia, dienTich);
		this.loaiNha = loaiNha;
		this.diaChi = diaChi;
	}

	public GiaoDichNha() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiaoDichNha(String maGaoDich, Calendar ngayGiaoDich, double donGia, double dienTich) {
		super(maGaoDich, ngayGiaoDich, donGia, dienTich);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double thanhTien() {
		double thanhTien = 0;
		if (getLoaiNha() == "cao cấp") {
			thanhTien = getDienTich() * getDonGia();
		} else
			thanhTien = getDienTich() * getDonGia() * 0.9;
		return thanhTien;
	}

	@Override
	public String toString() {
		String s = String.format("%15s" + "|" + "%15s" + "|", getLoaiNha(), getDiaChi());
		return super.toString() + s;
	}
}
