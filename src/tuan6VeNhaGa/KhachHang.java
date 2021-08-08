package tuan6VeNhaGa;

import java.io.Serializable;
import java.util.Objects;

public class KhachHang implements Serializable {
	private String soCmnd, tenKh, gaDen;
	private double giaTien;
	private static final long serialVersionUID = 1L;

	public String getSoCmnd() {
		return soCmnd;
	}

	public void setSoCmnd(String soCmnd) {
		this.soCmnd = soCmnd;
	}

	public String getTenKh() {
		return tenKh;
	}

	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}

	public String getGaDen() {
		return gaDen;
	}

	public void setGaDen(String gaDen) {
		this.gaDen = gaDen;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(soCmnd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(soCmnd, other.soCmnd);
	}

	public KhachHang(String soCmnd, String tenKh, String gaDen, double giaTien) {
		super();
		this.soCmnd = soCmnd;
		this.tenKh = tenKh;
		this.gaDen = gaDen;
		this.giaTien = giaTien;
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format("|" + "%-12s" + "|" + "%15s" + "|" + "%15s" + "|" + "%,15.1f" + "|", getSoCmnd(),
				getTenKh(), getGaDen(), getGiaTien());
	}

}
