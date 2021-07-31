package tuan4HoaDonTienDien;

import java.util.Calendar;

public class KhachHangNuocNgoai extends KhachHang {
	private String quocTich;

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public KhachHangNuocNgoai(String maKhachHang, String hoTen, Calendar ngayRaHD, double soLuong, double donGia,
			String quocTich) {
		super(maKhachHang, hoTen, ngayRaHD, soLuong, donGia);
		this.quocTich = quocTich;
	}

	public KhachHangNuocNgoai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHangNuocNgoai(String maKhachHang, String hoTen, Calendar ngayRaHD, double soLuong, double donGia) {
		super(maKhachHang, hoTen, ngayRaHD, soLuong, donGia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double thanhTien() {
		// TODO Auto-generated method stub
		return getSoLuong() * getDonGia();
	}

	@Override
	public String toString() {
		String s = String.format("%15s" + "|", getQuocTich());
		return super.toString() + s;
	}

}
