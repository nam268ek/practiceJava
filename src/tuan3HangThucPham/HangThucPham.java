package tuan3HangThucPham;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class HangThucPham {
	private int maHang;
	private String tenHang;
	private double donGia;

	private Calendar ngaySanXuat, ngayHetHan;

	public int getMaHang() {
		return maHang;
	}

	public void setMaHang(int maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public Calendar getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(Calendar ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public Calendar getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(Calendar ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public HangThucPham(int maHang, String tenHang, double donGia, Calendar ngaySanXuat, Calendar ngayHetHan) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHetHan = ngayHetHan;
	}

	public HangThucPham(int maHang) {
		super();
		// TODO Auto-generated constructor stub
	}

	public HangThucPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Return số ngày còn hạn(vd: +10) hoặc số ngày quá hạn(vd: -10)
	public long ExpiryDate() {
		Calendar today = Calendar.getInstance();
		long betWeenDates = ChronoUnit.DAYS.between(today.toInstant(), getNgayHetHan().toInstant());
		return betWeenDates;
	}

	public boolean CheckExpProducts() {
		long date = ExpiryDate();
		if (date >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String exp;
		if (ExpiryDate() < 0) {
			exp = "Quá hạn " + ExpiryDate() * (-1) + " ngày";
		} else {
			exp = "Còn hạn " + ExpiryDate() + " ngày";
		}
		return String.format(
				"|" + "%-8d" + "|" + "%-17s" + "|" + "%,15.1f" + "|" + "%15s" + "|" + "%15s" + "|" + "%17s" + "|",
				getMaHang(), getTenHang(), getDonGia(), formatter.format(getNgaySanXuat().getTime()),
				formatter.format(getNgayHetHan().getTime()), exp);
	}

}
