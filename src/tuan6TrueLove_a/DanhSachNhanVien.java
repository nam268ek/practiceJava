package tuan6TrueLove_a;

import java.util.ArrayList;
import java.util.Random;

public class DanhSachNhanVien {
	ArrayList<NhanVien> listNv = new ArrayList<NhanVien>();

	public boolean addNhanVien(NhanVien obj) {
		if (!listNv.contains(obj)) {
			listNv.add(obj);
			return true;
		}
		return false;

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

	public NhanVien searchNhanVien(String maPh) {
		for (NhanVien obj : listNv) {
			if (obj.getMaNv().equalsIgnoreCase(maPh))
				return obj;
		}
		return null;
	}

	public ArrayList<NhanVien> xuatAllDS() {
		return listNv;
	}

	public NhanVien quaTang() {
		Random ramDom = new Random();
		int index = ramDom.nextInt(listNv.size());
		return listNv.get(index);
	}
}
