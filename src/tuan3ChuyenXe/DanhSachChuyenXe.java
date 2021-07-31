package tuan3ChuyenXe;

import java.util.ArrayList;

public class DanhSachChuyenXe {

	ArrayList<ChuyenXe> listCx = new ArrayList<ChuyenXe>();

	public boolean addChuyenXe(ChuyenXe obj) {
		if (!listCx.contains(obj)) {
			listCx.add(obj);
			return true;
		}
		return false;

	}

	public boolean deleteChuyenXe(String maChuyenXe) {
		ChuyenXe obj = searchChuyenXe(maChuyenXe);
		if (obj != null) {
			listCx.remove(obj);
			return true;
		}
		return false;
	}

	public boolean suaChuyenXe(ChuyenXe obj) {
		if (listCx.contains(obj) && listCx.indexOf(obj) != -1) {
			listCx.set(listCx.indexOf(obj), obj);
			return true;
		}
		return false;
	}

	public ChuyenXe searchChuyenXe(String maChuyenXe) {
		for (ChuyenXe obj : listCx) {
			if (obj.getMaSoChuyen().equalsIgnoreCase(maChuyenXe))
				return obj;
		}
		return null;
	}

	public ArrayList<ChuyenXe> xuatAllDS() {
		return listCx;
	}
}
