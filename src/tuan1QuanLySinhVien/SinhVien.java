package tuan1QuanLySinhVien;

public class SinhVien {
	private int mSSV;
	private String hoTen;
	private float diemLT, diemTH;

	public float getDiemTB() {
		return (getDiemLT() + getDiemTH()) / 2;
	}

	public int getmSSV() {
		return mSSV;
	}

	public void setmSSV(int mSSV) {
		this.mSSV = mSSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public float getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}

	public float getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}

	public SinhVien(int mSSV, String hoTen, float diemLT, float diemTH) {
		super();
		this.mSSV = mSSV;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format("%-8s %-20s %10.1f %10.1f %10.1f", getmSSV(), getHoTen(), getDiemLT(), getDiemTH(),
				getDiemTB());
	}

}
