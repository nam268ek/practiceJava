package tuan4NhaDat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public abstract class GiaoDich {
	protected String maGaoDich;
	protected Calendar ngayGiaoDich;
	protected double donGia;
	protected double dienTich;

	abstract public double thanhTien();

	public String getMaGaoDich() {
		return maGaoDich;
	}

	public void setMaGaoDich(String maGaoDich) {
		this.maGaoDich = maGaoDich;
	}

	public Calendar getNgayGiaoDich() {
		return ngayGiaoDich;
	}

	public void setNgayGiaoDich(Calendar ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
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

	public GiaoDich(String maGaoDich, Calendar ngayGiaoDich, double donGia, double dienTich) {
		super();
		this.maGaoDich = maGaoDich;
		this.ngayGiaoDich = ngayGiaoDich;
		this.donGia = donGia;
		this.dienTich = dienTich;
	}

	public GiaoDich() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("|" + "%-8s" + "|" + "%15s" + "|" + "%,15.1f" + "|" + "%12.1f" + "|", getMaGaoDich(),
				formater.format(getNgayGiaoDich().getTime()), getDonGia(), getDienTich());
	}

}
