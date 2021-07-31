package tuan5HangHoaSanhSu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class DanhSachHangHoa {
	ArrayList<HangHoa> listHh = new ArrayList<HangHoa>();

	public boolean addHangHoa(HangHoa obj) {
		if (!listHh.contains(obj)) {
			listHh.add(obj);
			return true;
		}
		return false;

	}

	public boolean deleteHangHoa(String maPh) {
		HangHoa obj = searchHangHoa(maPh);
		if (obj != null) {
			listHh.remove(obj);
			return true;
		}
		return false;
	}

	public boolean suaHangHoa(HangHoa obj) {
		if (listHh.contains(obj) && listHh.indexOf(obj) != -1) {
			listHh.set(listHh.indexOf(obj), obj);
			return true;
		}
		return false;
	}

	public HangHoa searchHangHoa(String maPh) {
		for (HangHoa obj : listHh) {
			if (obj.getMaHang().equalsIgnoreCase(maPh))
				return obj;
		}
		return null;
	}

	public ArrayList<HangHoa> xuatAllDS() {
		return listHh;
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

	public void sapXepTheoSoLuong() {
		Collections.sort(listHh, new Comparator<HangHoa>() {
			public int compare(HangHoa o1, HangHoa o2) {
				Integer h1 = o1.getSoLuongTon();
				Integer h2 = o2.getSoLuongTon();
				return h1.compareTo(h2);
			}
		});
	}

	public void sapXepTheoDonGia() {
		Collections.sort(listHh, new Comparator<HangHoa>() {
			public int compare(HangHoa o1, HangHoa o2) {
				Double d1 = o1.getDonGia();
				Double d2 = o2.getDonGia();
				return d2.compareTo(d1);
			}
		});
	}
}
