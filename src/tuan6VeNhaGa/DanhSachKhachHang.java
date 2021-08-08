package tuan6VeNhaGa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DanhSachKhachHang implements Serializable {
    private static final long serialVersionUID = 1L;
    Queue<KhachHang> listKh = new LinkedList<KhachHang>();
    List<KhachHang> listKhMuaVe = new LinkedList<KhachHang>();
    Map<String, Integer> mapGa = new HashMap<String, Integer>();
    private static final String filepath = "DanhSachKhachHangDaMuaVe.txt";
    int khMuaVe = 0;

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
            khMuaVe++;
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

    public KhachHang searchKhachHangQueue(String soCmnd) {
        for (KhachHang obj : listKh) {
            if (obj.getSoCmnd().equalsIgnoreCase(soCmnd))
                return obj;
        }
        return null;
    }

    public boolean huyKhachHang(String soCmnd) {
        KhachHang obj = searchKhachHangQueue(soCmnd);
        if (obj != null) {
            listKh.remove(obj);
            return true;
        }
        return false;
    }

    public double doanhThu() {
        double doanhThu = 0;
        for (KhachHang obj : listKhMuaVe) {
            doanhThu += obj.getGiaTien();
        }
        return doanhThu;
    }

    public Set<String> dsNhaGa() {
        Set<String> listGa = new LinkedHashSet<String>();
        for (KhachHang obj : listKh) {
            listGa.add(obj.getGaDen());
        }
        return listGa;
    }

    public void countVe() {
        for (KhachHang kh : listKh) {
            if (mapGa.containsKey(kh.getGaDen())) {
                mapGa.put(kh.getGaDen(), mapGa.get(kh.getGaDen()) + 1);
            } else {
                mapGa.put(kh.getGaDen(), 1);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Queue<KhachHang> danhSachKh() {
        if (new File(filepath).exists()) {
            listKh = (Queue<KhachHang>) ReadObjectFromFile();
        } else {
            listKh = new LinkedList<KhachHang>();
        }
        return listKh;
    }

    public boolean saveToFileKhChoMuaVe() {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(listKh);
            objectOut.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Object ReadObjectFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            objectIn.close();
            return obj;
        } catch (Exception ex) {
            return null;
        }
    }
}
