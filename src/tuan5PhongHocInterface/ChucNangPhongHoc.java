package tuan5PhongHocInterface;

public interface ChucNangPhongHoc {
	
	void sapXepTheoDay();
	void sapXepTheoDienTich();
	void sapXepTheoSoBongDen();
	boolean addPhong(PhongHoc obj);
	boolean deletePhong(String maPh);
	boolean suaPhong(PhongHoc obj);
	PhongHoc searchPhong(String maPh);
}
