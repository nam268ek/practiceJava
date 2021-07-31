package tuan5HangHoaSanhSu;

import java.util.Objects;

public abstract class HangHoa {
	protected String maHang, tenHang;
	protected int soLuongTon;
	protected double donGia;

	abstract public String mucDoBanBuon();

	abstract public double tienVATHangHoa();

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangHoa other = (HangHoa) obj;
		return Objects.equals(maHang, other.maHang);
	}

	public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.soLuongTon = soLuongTon;
		this.donGia = donGia;
	}

	public HangHoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format("|" + "%-8s" + "|" + "%15s" + "|" + "%,15d" + "|" + "%,15.1f" + "|", getMaHang(),
				getTenHang(), getSoLuongTon(), getDonGia());
	}

}
