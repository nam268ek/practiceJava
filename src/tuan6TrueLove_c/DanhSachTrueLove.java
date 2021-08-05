package tuan6TrueLove_c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collections;

public class DanhSachTrueLove {
	ArrayList<NhanVien> listNv = new ArrayList<NhanVien>();
	ArrayList<SanPham> listSp = new ArrayList<SanPham>();
	Map<String, Integer> mapTenSanPham = new HashMap<String, Integer>();

	public void countNv() {
		for (NhanVien nv : listNv) {
			if (mapTenSanPham.containsKey(nv.getTenNv())) {
				mapTenSanPham.put(nv.getTenNv(), mapTenSanPham.get(nv.getTenNv()) + 1);
			} else {
				mapTenSanPham.put(nv.getTenNv(), 1);
			}
		}
	}

	public String tenSanPham() {
		Set<String> set = mapTenSanPham.keySet();
		for (String key : set) {
			if (mapTenSanPham.get(key) == Collections.max(mapTenSanPham.values())) {
				return key;
			}
		}
		return null;
	}

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
