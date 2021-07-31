package tuan5PhongHocInterface;

public class PhongHocLyThuyet extends PhongHoc {
	private boolean mayChieu;

	public boolean isMayChieu() {
		return mayChieu;
	}

	public void setMayChieu(boolean mayChieu) {
		this.mayChieu = mayChieu;
	}

	public PhongHocLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean mayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.mayChieu = mayChieu;
	}

	public PhongHocLyThuyet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongHocLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean datChuan() {
		if (duSang() && isMayChieu()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String mayChieu;
		if (isMayChieu())
			mayChieu = "có";
		else
			mayChieu = "Không";
		String s = String.format("%15s" + "|" + "%15s" + "|", mayChieu, datChuan());
		return super.toString() + s;
	}

}
