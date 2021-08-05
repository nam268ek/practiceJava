package tuan6TrueLove_b;

import java.util.ArrayList;

public class DanhSachTrueLove {
	ArrayList<NhanVien> listNv = new ArrayList<NhanVien>();
	ArrayList<SanPham> listSp = new ArrayList<SanPham>();

	public boolean addNhanVien(NhanVien obj) {
		if (!listNv.contains(obj)) {
			listNv.add(obj);
			return true;
		}
		return false;

	}

	public boolean addSanPham(SanPham obj) {
		if (!listSp.contains(obj)) {
			listSp.add(obj);
			return true;
		}
		return false;

	}

	public NhanVien checkTenSanPham(NhanVien obj) {
		if (!listSp.contains(obj)) {
			return obj;
		}
		return null;
	}

	public boolean deleteNhanVien(String maPh) {
		NhanVien obj = searchNhanVien(maPh);
		if (obj != null) {
			listNv.remove(obj);
			return true;
		}
		return false;
	}

	public boolean suaNhanVien(NhanVien obj) {
		if (listNv.contains(obj) && listNv.indexOf(obj) != -1) {
			listNv.set(listNv.indexOf(obj), obj);
			return true;
		}
		return false;
	}

	public NhanVien searchNhanVien(String tenNv) {
		for (NhanVien obj : listNv) {
			if (obj.getTenNv().equalsIgnoreCase(tenNv))
				return obj;
		}
		return null;
	}

	public ArrayList<NhanVien> xuatAllDS() {
		return listNv;
	}
}
