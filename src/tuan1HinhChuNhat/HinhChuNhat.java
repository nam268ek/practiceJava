package tuan1HinhChuNhat;

public class HinhChuNhat {
	
	private int chieuDai;
	private int chieuRong;
	
	public int getChieuDai() {
		return chieuDai;
	}
	public void setChieuDai(int chieuDai) {
		this.chieuDai = chieuDai;
	}
	public int getChieuRong() {
		return chieuRong;
	}
	public void setChieuRong(int chieuRong) {
		this.chieuRong = chieuRong;
	}
	public HinhChuNhat(int chieuDai, int chieuRong) {
		super();
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	
	public HinhChuNhat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public float Chuvi() {
		
		float Cv = (getChieuDai() + getChieuRong())*2;
		return Cv;
	}
	public float DienTich() {
		return getChieuDai() * getChieuRong();
	}
}
