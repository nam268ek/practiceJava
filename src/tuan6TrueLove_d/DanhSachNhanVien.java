package tuan6TrueLove_d;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class DanhSachNhanVien {
    ArrayList<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();
    Set<NhanVien> listNv = new LinkedHashSet<NhanVien>();

    public boolean addNhanVien(NhanVien obj) {
        if (!danhSachNhanVien.contains(obj)) {
            danhSachNhanVien.add(obj);
            return true;
        }
        return false;
    }

    public boolean addNhanVienDk(NhanVien obj) {
        if (!listNv.contains(obj)) {
            listNv.add(obj);
            return true;
        }
        return false;
    }
    public NhanVien searchNhanVien(String maNv) {
		for (NhanVien obj : danhSachNhanVien) {
			if (obj.getMaNv().equalsIgnoreCase(maNv))
				return obj;
		}
		return null;
	}
}
