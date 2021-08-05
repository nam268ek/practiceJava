package tuan6VeNhaGa;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DanhSachKhachHang {
    Queue<KhachHang> listKh = new LinkedList<KhachHang>();
    List<KhachHang> listKhMuaVe = new LinkedList<KhachHang>();

    public boolean addKhachHang(KhachHang obj) {
        if (!listKh.contains(obj)) {
            listKh.add(obj);
            return true;
        }
        return false;
    }

    public boolean banVeKhachHang() {
        if (listKh.peek() != null) {
            listKhMuaVe.add(listKh.peek());
            listKh.poll();
            return true;
        }
        return false;
    }

    public KhachHang searchKhachHang(String soCmnd) {
        for (KhachHang obj : listKhMuaVe) {
            if (obj.getSoCmnd().equalsIgnoreCase(soCmnd))
                return obj;
        }
        return null;
    }
}
