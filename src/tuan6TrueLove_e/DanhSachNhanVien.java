package tuan6TrueLove_e;

import java.util.Set;
import java.util.TreeSet;

public class DanhSachNhanVien {
    Set<NhanVien> listNv = new TreeSet<NhanVien>();

    public boolean addNhanVien(NhanVien obj) {
        if (!listNv.contains(obj)) {
            listNv.add(obj);
            return true;
        }
        return false;
    }
}
