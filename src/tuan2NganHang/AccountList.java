package tuan2NganHang;

public class AccountList {
	public int count;
	Account[] dsAcc;

	public AccountList(int n) {
		if (n > 0)
			dsAcc = new Account[n];
		else {
			count = 0;
			dsAcc = new Account[10];
		}
	}

	public Account timAcc(long soTK) {
		for (int i = 0; i < count; i++) {
			if (dsAcc[i].getsTK() == soTK)
				return dsAcc[i];
		}
		return null;
	}

	public int timViTriAcc(long soTk) {
		int i;
		for (i = 0; i < count; i++) {
			if (dsAcc[i].getsTK() == soTk)
				break;
		}
		return i;
	}

	public boolean ThemAcc(Account acc) {
		if (timAcc(acc.getsTK()) != null)
			return false;
		else if (count == dsAcc.length)
			MangTangKichThuoc();
		dsAcc[count] = acc;
		count++;
		return true;
	}

	public void XoaAcc(Account acc) {
		int vitri = timViTriAcc(acc.getsTK());
		for (int i = vitri; i < dsAcc.length - 1; i++) {
			dsAcc[i] = dsAcc[i + 1];
		}
		count--;

	}

	public int SoLuongTK(Account dsAccount[]) {
		int sl = 0;
		for (int i = 0; i < dsAccount.length; i++) {
			sl += i;
		}
		return sl;
	}

	public void XuatDS(Account dsAcc[]) {

		for (int i = 0; i < count; i++) {
			System.out.println(dsAcc[i]);
		}
	}

	private void MangTangKichThuoc() {
		Account temp[] = new Account[(int) (dsAcc.length * 2)];
		for (int i = 0; i < dsAcc.length; i++)
			temp[i] = dsAcc[i];
		dsAcc = temp;
	}
}
