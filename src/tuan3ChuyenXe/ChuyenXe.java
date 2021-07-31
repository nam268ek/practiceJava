package tuan3ChuyenXe;

import java.util.Objects;

public class ChuyenXe {
	protected int soXe;
	protected long doanhThu;
	protected String hoTen, maSoChuyen;

	public String getMaSoChuyen() {
		return maSoChuyen;
	}

	public void setMaSoChuyen(String maSoChuyen) {
		this.maSoChuyen = maSoChuyen;
	}

	public int getSoXe() {
		return soXe;
	}

	public void setSoXe(int soXe) {
		this.soXe = soXe;
	}

	public long getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(long doanhThu) {
		this.doanhThu = doanhThu;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public ChuyenXe(String maSoChuyen, int soXe, long doanhThu, String hoTen) {
		super();
		this.maSoChuyen = maSoChuyen;
		this.soXe = soXe;
		this.doanhThu = doanhThu;
		this.hoTen = hoTen;
	}

	public ChuyenXe() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSoChuyen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuyenXe other = (ChuyenXe) obj;
		return maSoChuyen == other.maSoChuyen;
	}

	@Override
	public String toString() {
		return String.format("|" + "%-8s" + "|" + "%15s" + "|" + "%,15d" + "|" + "%15s" + "|", getMaSoChuyen(),
				getSoXe(), getDoanhThu(), getHoTen());
	}

}
