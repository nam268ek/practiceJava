package tuan5PhongHocInterface;

import java.util.Objects;

public abstract class PhongHoc {
	protected String maPhong, dayNha;
	protected double dienTich;
	protected int soBongDen;

	abstract public boolean datChuan();

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getDayNha() {
		return dayNha;
	}

	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	public int getSoBongDen() {
		return soBongDen;
	}

	public void setSoBongDen(int soBongDen) {
		this.soBongDen = soBongDen;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongHoc other = (PhongHoc) obj;
		return Objects.equals(maPhong, other.maPhong);
	}

	public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super();
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.dienTich = dienTich;
		this.soBongDen = soBongDen;
	}

	public PhongHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean duSang() {
		if (getSoBongDen() >= getDienTich() * 1 / 10) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("|" + "%-8s" + "|" + "%15s" + "|" + "%,15.1f" + "|" + "%15d" + "|", getMaPhong(),
				getDayNha(), getDienTich(), getSoBongDen());
	}

}
