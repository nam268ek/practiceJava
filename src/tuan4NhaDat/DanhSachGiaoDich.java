package tuan4NhaDat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class DanhSachGiaoDich {
	ArrayList<tuan4NhaDat.GiaoDich> listGD = new ArrayList<tuan4NhaDat.GiaoDich>();

	public boolean addGiaoDich(tuan4NhaDat.GiaoDich obj) {
		if (!listGD.contains(obj)) {
			listGD.add(obj);
			return true;
		}
		return false;

	}

	public boolean deleteGiaoDich(String maGiaoDich) {
		tuan4NhaDat.GiaoDich obj = searchGiaoDich(maGiaoDich);
		if (obj != null) {
			listGD.remove(obj);
			return true;
		}
		return false;
	}

	public boolean suaGiaoDich(tuan4NhaDat.GiaoDich obj) {
		if (listGD.contains(obj) && listGD.indexOf(obj) != -1) {
			listGD.set(listGD.indexOf(obj), obj);
			return true;
		}
		return false;
	}

	public tuan4NhaDat.GiaoDich searchGiaoDich(String maGiaoDich) {
		for (tuan4NhaDat.GiaoDich obj : listGD) {
			if (obj.getMaGaoDich().equalsIgnoreCase(maGiaoDich))
				return obj;
		}
		return null;
	}

	public ArrayList<tuan4NhaDat.GiaoDich> xuatAllDS() {
		return listGD;
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

	public int sumGiaoDichDat() {
		int sum = 0;
		for (tuan4NhaDat.GiaoDich obj : listGD) {
			if (obj instanceof GiaoDichDat) {
				sum++;
			}
		}
		return sum;
	}

	public int sumGiaoDichNha() {
		int sum = 0;
		for (tuan4NhaDat.GiaoDich obj : listGD) {
			if (obj instanceof GiaoDichNha) {
				sum++;
			}
		}
		return sum;
	}

	public long trungBinhThanhTienGdDat() {
		long tb = 0;
		int count = 0;
		for (tuan4NhaDat.GiaoDich obj : listGD) {
			if (obj instanceof GiaoDichDat) {
				tb += obj.thanhTien();
				count++;
			}
		}
		return tb / count;
	}

	public void sapXepTheoNgay() {
		Collections.sort(listGD, new Comparator<GiaoDich>() {
			public int compare(GiaoDich o1, GiaoDich o2) {
				return o2.getNgayGiaoDich().compareTo(o1.getNgayGiaoDich());
			}
		});
	}

	public void sapXepTheoDonGia() {
		Collections.sort(listGD, new Comparator<GiaoDich>() {
			public int compare(GiaoDich o1, GiaoDich o2) {
				Double obj1 = o1.getDonGia();
				Double obj2 = o2.getDonGia();
				return obj1.compareTo(obj2);
			}
		});
	}
}
