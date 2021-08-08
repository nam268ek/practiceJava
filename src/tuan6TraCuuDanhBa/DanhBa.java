package tuan6TraCuuDanhBa;

import java.util.Objects;

public class DanhBa {
	private String soDienThoai;
	private String hoTen, diaChi;

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(soDienThoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DanhBa other = (DanhBa) obj;
		return soDienThoai == other.soDienThoai;
	}

	public DanhBa(String soDienThoai, String hoTen, String diaChi) {
		super();
		this.soDienThoai = soDienThoai;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
	}

	public DanhBa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format("|" + "%12s" + "|" + "%15s" + "|" + "%12s" + "|", getSoDienThoai(), getHoTen(),
				getDiaChi());
	}

}
