package tuan3QuanLySach;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public abstract class Sach {
	protected int maSach, soLuong;
	protected Calendar ngayNhap;
	protected double donGia;
	protected String nhaXuatBan;

	abstract public double thanhTien();

	public int getMaSach() {
		return maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Calendar getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Calendar ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return maSach == other.maSach;
	}

	public Sach(int maSach, int soLuong, Calendar ngayNhap, double donGia, String nhaXuatBan) {
		super();
		this.maSach = maSach;
		this.soLuong = soLuong;
		this.ngayNhap = ngayNhap;
		this.donGia = donGia;
		this.nhaXuatBan = nhaXuatBan;
	}

	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("|" + "%-8d" + "|" + "%-8d" + "|" + "%15s" + "|" + "%,12.1f" + "|" + "%20s" + "|",
				getMaSach(), getSoLuong(), formater.format(getNgayNhap().getTime()), getDonGia(), getNhaXuatBan());
	}

}
