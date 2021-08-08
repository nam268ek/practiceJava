package tuan6TraCuuDanhBa;

import java.util.LinkedList;
import java.util.List;

public class DanhSachDanhBa {
    List<DanhBa> listDb = new LinkedList<DanhBa>();

    public boolean addDanhBa(DanhBa obj) {
        if (!listDb.contains(obj)) {
            listDb.add(obj);
            return true;
        }
        return false;
    }
}
