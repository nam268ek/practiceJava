package tuan5PhongHoc;

public class PhongHocThiNghiem extends PhongHoc {
	private String thongTinChuyenNganh;
	private double sucChua;
	private boolean bonRua;

	public String getThongTinChuyenNganh() {
		return thongTinChuyenNganh;
	}

	public void setThongTinChuyenNganh(String thongTinChuyenNganh) {
		this.thongTinChuyenNganh = thongTinChuyenNganh;
	}

	public double getSucChua() {
		return sucChua;
	}

	public void setSucChua(double sucChua) {
		this.sucChua = sucChua;
	}

	public boolean isBonRua() {
		return bonRua;
	}

	public void setBonRua(boolean bonRua) {
		this.bonRua = bonRua;
	}

	public PhongHocThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String thongTinChuyenNganh,
			double sucChua, boolean bonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.thongTinChuyenNganh = thongTinChuyenNganh;
		this.sucChua = sucChua;
		this.bonRua = bonRua;
	}

	public PhongHocThiNghiem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongHocThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean datChuan() {
		if (getSoBongDen() >= getDienTich() * 1 / 10 && isBonRua()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String bonRua;
		if (isBonRua())
			bonRua = "Có";
		else
			bonRua = "Không";
		String s = String.format("%15s" + "|" + "%15.1f" + "|" + "%15s" + "|"+ "%15s" + "|", getThongTinChuyenNganh(), getSucChua(),
				bonRua, datChuan());
		return super.toString() + s;
	}

}
