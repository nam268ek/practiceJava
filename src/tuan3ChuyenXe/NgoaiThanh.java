package tuan3ChuyenXe;

public class NgoaiThanh extends ChuyenXe {
	private String noiDen;
	private int soNgay;

	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	public int getSoNgay() {
		return soNgay;
	}

	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}

	public NgoaiThanh(String maSoChuyen, int soXe, long doanhThu, String hoTen, String noiDen, int soNgay) {
		super(maSoChuyen, soXe, doanhThu, hoTen);
		this.noiDen = noiDen;
		this.soNgay = soNgay;
	}

	public NgoaiThanh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NgoaiThanh(String maSoChuyen, int soXe, long doanhThu, String hoTen) {
		super(maSoChuyen, soXe, doanhThu, hoTen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String s = String.format("%15s" + "|" + "%15d" + "|", getNoiDen(), getSoNgay());
		return super.toString() + s;
	}

}
