package tuan3ChuyenXe;

public class NoiThanh extends ChuyenXe {
	private String soTuyen;
	private int soKm;

	public String getSoTuyen() {
		return soTuyen;
	}

	public void setSoTuyen(String soTuyen) {
		this.soTuyen = soTuyen;
	}

	public int getSoKm() {
		return soKm;
	}
		
	public void setSoKm(int soKm) {
		this.soKm = soKm;
	}

	public NoiThanh(String maSoChuyen, int soXe, long doanhThu, String hoTen, String soTuyen, int soKm) {
		super(maSoChuyen, soXe, doanhThu, hoTen);
		this.soTuyen = soTuyen;
		this.soKm = soKm;
	}

	public NoiThanh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoiThanh(String maSoChuyen, int soXe, long doanhThu, String hoTen) {
		super(maSoChuyen, soXe, doanhThu, hoTen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String s = String.format("%15s" + "|" + "%15d" + "|", getSoTuyen(), getSoKm());
		return super.toString() + s;
	}

}
