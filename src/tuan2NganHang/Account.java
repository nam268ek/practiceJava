package tuan2NganHang;

public class Account {
	private long sTK;
	private String tenTK, trangThai;
	private double money;
	final double LAISUAT = 0.035;

	public long getsTK() {
		return sTK;
	}

	public void setsTK(long sTK) {
		if (this.sTK > 0 && this.sTK != 999999) {
			this.sTK = sTK;
		} else {
			this.sTK = 123456;
			this.trangThai = "Khong hop le";
		}
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		if (this.tenTK != null) {
			this.tenTK = tenTK;
		} else
			this.tenTK = "default";
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		if (this.money > 50) {
			this.money = money;
		} else
			this.money = 20000;
	}

	public Account(long sTK, String tenTK, double money) {
		super();
		this.sTK = sTK;
		this.tenTK = tenTK;
		this.money = money;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean napTienTK(Account acc, double money) {
		if (money > 0 && acc != null) {
			acc.setMoney(money + acc.getMoney());
			return true;
		} else
			return false;
	}

	public boolean rutTienTK(Account acc, double tienRut) {
		double currentMoney = acc.getMoney();
		if (currentMoney >= tienRut && acc != null && tienRut > 0) {
			acc.setMoney(currentMoney - acc.getMoney());
			return true;
		}
		return false;
	}

	public boolean chuyenKhoan(Account acc1, Account acc2, double tienChuyen) {
		if (acc1.getMoney() > tienChuyen && tienChuyen > 0 && acc1 != null && acc2 != null) {
			acc1.setMoney(acc1.getMoney() - tienChuyen);
			acc2.setMoney(acc2.getMoney() + tienChuyen);
			return true;
		}
		return false;
	}

	public boolean daoHan(Account acc) {
		if (acc != null) {
			acc.setMoney(acc.getMoney() + (acc.getMoney() * LAISUAT));
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format(
				"|" + "%-8d" + "|" + "%-20s" + "|" + "%-8s" + "|" + "%12.1f" + "|" + "%20.1f" + "|" + "%20.1f" + "|",
				getsTK(), getTenTK(), getTrangThai(), getMoney());
	}

}
