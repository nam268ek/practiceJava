package tuan5PhongHoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachPhongHoc {
	ArrayList<PhongHoc> listPh = new ArrayList<PhongHoc>();

	public boolean addPhong(PhongHoc obj) {
		if (!listPh.contains(obj)) {
			listPh.add(obj);
			return true;
		}
		return false;

	}

	public boolean deletePhong(String maPh) {
		PhongHoc obj = searchPhong(maPh);
		if (obj != null) {
			listPh.remove(obj);
			return true;
		}
		return false;
	}

	public boolean suaPhong(PhongHoc obj) {
		if (listPh.contains(obj) && listPh.indexOf(obj) != -1) {
			listPh.set(listPh.indexOf(obj), obj);
			return true;
		}
		return false;
	}

	public PhongHoc searchPhong(String maPh) {
		for (PhongHoc obj : listPh) {
			if (obj.getMaPhong().equalsIgnoreCase(maPh))
				return obj;
		}
		return null;
	}

	public ArrayList<PhongHoc> xuatAllDS() {
		return listPh;
	}

	public void sapXepTheoDay() {
		Collections.sort(listPh, new Comparator<PhongHoc>() {
			public int compare(PhongHoc o1, PhongHoc o2) {
				return o1.getDayNha().compareTo(o2.getDayNha());
			}
		});
	}

	public void sapXepTheoDienTich() {
		Collections.sort(listPh, new Comparator<PhongHoc>() {
			public int compare(PhongHoc o1, PhongHoc o2) {
				Double d1 = o1.getDienTich();
				Double d2 = o2.getDienTich();
				return d2.compareTo(d1);
			}
		});
	}

	public void sapXepTheoSoBongDen() {
		Collections.sort(listPh, new Comparator<PhongHoc>() {
			public int compare(PhongHoc o1, PhongHoc o2) {
				Integer b1 = o1.getSoBongDen();
				Integer b2 = o2.getSoBongDen();
				return b1.compareTo(b2);
			}
		});
	}
}
