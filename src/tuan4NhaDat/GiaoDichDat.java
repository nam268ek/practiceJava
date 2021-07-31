package tuan4NhaDat;

import java.util.Calendar;

public class GiaoDichDat extends GiaoDich {
	private String loaiDat;

	public String getLoaiDat() {
		return loaiDat;
	}

	public void setLoaiDat(String loaiDat) {
		this.loaiDat = loaiDat;
	}

	public GiaoDichDat(String maGaoDich, Calendar ngayGiaoDich, double donGia, double dienTich, String loaiDat) {
		super(maGaoDich, ngayGiaoDich, donGia, dienTich);
		this.loaiDat = loaiDat;
	}

	public GiaoDichDat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiaoDichDat(String maGaoDich, Calendar ngayGiaoDich, double donGia, double dienTich) {
		super(maGaoDich, ngayGiaoDich, donGia, dienTich);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double thanhTien() {
		double thanhTien = 0;
		// TODO Auto-generated method stub
		if (getLoaiDat() == "A") {
			thanhTien = getDienTich() * getDonGia() * 1.5;
		} else if (getLoaiDat() == "B" || getLoaiDat() == "C")
			thanhTien = getDienTich() * getDonGia();
		return thanhTien;
	}

	@Override
	public String toString() {
		String s = String.format("%15s" + "|", getLoaiDat());
		return super.toString() + s;
	}

}
