package tuan5PhongHocInterface;

public class PhongHocMayTinh extends PhongHoc {
	private int soMayTinh;

	public int getSoMayTinh() {
		return soMayTinh;
	}

	public void setSoMayTinh(int soMayTinh) {
		this.soMayTinh = soMayTinh;
	}

	public PhongHocMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soMayTinh = soMayTinh;
	}

	public PhongHocMayTinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongHocMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean datChuan() {
		if (duSang() && getSoMayTinh() <= getDienTich() / 1.5) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String s = String.format("%15d" + "|"+ "%15s" + "|", getSoMayTinh(), datChuan());
		return super.toString() + s;
	}

}
