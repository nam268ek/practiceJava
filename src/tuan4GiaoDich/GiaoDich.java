package tuan4GiaoDich;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public abstract class GiaoDich {
	protected String maGaoDich;
	protected Calendar ngayNhap;
	protected double donGia;
	protected int soLuong;

	abstract public double thanhTien();

	public String getMaGaoDich() {
		return maGaoDich;
	}

	public void setMaGaoDich(String maGaoDich) {
		this.maGaoDich = maGaoDich;
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

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maGaoDich);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaoDich other = (GiaoDich) obj;
		return Objects.equals(maGaoDich, other.maGaoDich);
	}

	public GiaoDich(String maGaoDich, Calendar ngayNhap, double donGia, int soLuong) {
		super();
		this.maGaoDich = maGaoDich;
		this.ngayNhap = ngayNhap;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	public GiaoDich() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("|" + "%-8s" + "|" + "%15s" + "|" + "%,15.1f" + "|" + "%12d" + "|", getMaGaoDich(),
				formater.format(getNgayNhap().getTime()), getDonGia(), getSoLuong());
	}

}
