package tuan2Xe;

public class Xe {
	private int maXe;
	private String tenChuXe, loaiXe;
	private float dungTich, triGia, thue;

	public int getMaXe() {
		return maXe;
	}

	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}

	public String getTenChuXe() {
		return tenChuXe;
	}

	public void setTenChuXe(String tenChuXe) {
		this.tenChuXe = tenChuXe;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public float getDungTich() {
		return dungTich;
	}

	public void setDungTich(float dungTich) {
		this.dungTich = dungTich;
	}

	public float getTriGia() {
		return triGia;
	}

	public void setTriGia(float triGia) {
		this.triGia = triGia;
	}

	public float getThue() {
		if (dungTich < 100) {
			thue = (float) (triGia * 0.01);
		}

		else if (dungTich >= 100 && dungTich <= 200) {
			thue = (float) (triGia * 0.03);
		}

		else {
			thue = (float) (triGia * 0.05);
		}
		return thue;
	}

	public Xe(int maXe, String tenChuXe, String loaiXe, float dungTich, float triGia) {
		super();
		this.maXe = maXe;
		this.tenChuXe = tenChuXe;
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.triGia = triGia;
	}

	public Xe() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format(
				"|" + "%-8d" + "|" + "%-20s" + "|" + "%-8s" + "|" + "%12.1f" + "|" + "%,20.1f" + "|" + "%,20.1f" + "|",
				getMaXe(), getTenChuXe(), getLoaiXe(), getDungTich(), getTriGia(), getThue());
	}

}
