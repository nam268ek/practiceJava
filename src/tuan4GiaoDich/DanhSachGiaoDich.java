package tuan4GiaoDich;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DanhSachGiaoDich {
	ArrayList<GiaoDich> listGD = new ArrayList<GiaoDich>();

	public boolean addGiaoDich(GiaoDich obj) {
		if (!listGD.contains(obj)) {
			listGD.add(obj);
			return true;
		}
		return false;

	}

	public boolean deleteGiaoDich(GiaoDich obj) {
		if (listGD.contains(obj)) {
			listGD.remove(obj);
			return true;
		}
		return false;
	}

	public boolean suaGiaoDich(GiaoDich obj) {
		if (listGD.contains(obj) && listGD.indexOf(obj) != -1) {
			listGD.set(listGD.indexOf(obj), obj);
			return true;
		}
		return false;
	}

	public GiaoDich searchGiaoDich(String maGiaoDich) {
		for (GiaoDich obj : listGD) {
			if (obj.getMaGaoDich().equalsIgnoreCase(maGiaoDich))
				return obj;
		}
		return null;
	}

	public ArrayList<GiaoDich> xuatAllDS() {
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
				System.out.println("Sai định dạng. Vui lòng nhập lại");
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
}
