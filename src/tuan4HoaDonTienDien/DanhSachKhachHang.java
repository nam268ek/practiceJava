package tuan4HoaDonTienDien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class DanhSachKhachHang {
	ArrayList<KhachHang> listKh = new ArrayList<KhachHang>();

	public boolean addGiaoDich(KhachHang obj) {
		if (!listKh.contains(obj)) {
			listKh.add(obj);
			return true;
		}
		return false;

	}

	public boolean deleteGiaoDich(String maKh) {
		KhachHang obj = searchGiaoDich(maKh);
		if (obj != null) {
			listKh.remove(obj);
			return true;
		}
		return false;
	}

	public boolean suaGiaoDich(KhachHang obj) {
		if (listKh.contains(obj) && listKh.indexOf(obj) != -1) {
			listKh.set(listKh.indexOf(obj), obj);
			return true;
		}
		return false;
	}

	public KhachHang searchGiaoDich(String maKh) {
		for (KhachHang obj : listKh) {
			if (obj.getMaKhachHang().equalsIgnoreCase(maKh))
				return obj;
		}
		return null;
	}

	public ArrayList<KhachHang> xuatAllDS() {
		return listKh;
	}

	public boolean CheckValidate(String date) {
		if (date == null) {
			return false;
		} else {
			SimpleDateFormat checkDate = new SimpleDateFormat("dd/MM/yyyy");
			checkDate.setLenient(false);
			try {
				checkDate.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				return false;
			}
			return true;
		}
	}

	public Calendar dateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	public int sumKhachHangVn() {
		int sum = 0;
		for (KhachHang obj : listKh) {
			if (obj instanceof KhachHangVietNam) {
				sum++;
			}
		}
		return sum;
	}

	public int sumGiaoDichNha() {
		int sum = 0;
		for (KhachHang obj : listKh) {
			if (obj instanceof KhachHangNuocNgoai) {
				sum++;
			}
		}
		return sum;
	}

	public long trungBinhThanhTienKhNuocNgoai() {
		long tb = 0;
		int count = 0;
		for (KhachHang obj : listKh) {
			if (obj instanceof KhachHangNuocNgoai) {
				tb += obj.thanhTien();
				count++;
			}
		}
		return tb / count;
	}

	public void sapXepTheoNgay() {
		Collections.sort(listKh, new Comparator<KhachHang>() {
			public int compare(KhachHang o1, KhachHang o2) {
				return o2.getNgayRaHD().compareTo(o1.getNgayRaHD());
			}
		});
	}

	public void sapXepTheoDonGia() {
		Collections.sort(listKh, new Comparator<KhachHang>() {
			public int compare(KhachHang o1, KhachHang o2) {
				Double obj1 = o1.getDonGia();
				Double obj2 = o2.getDonGia();
				return obj1.compareTo(obj2);
			}
		});
	}
}
