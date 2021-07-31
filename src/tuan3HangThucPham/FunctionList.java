package tuan3HangThucPham;

public class FunctionList {
	public int count;
	HangThucPham arrList[];

	public FunctionList(int n) {
		if (n > 0)
			arrList = new HangThucPham[n];
		else {
			count = 0;
			arrList = new HangThucPham[10];
		}
	}

	public HangThucPham searchProducts(int maHang) {
		for (int i = 0; i < count; i++) {
			if (arrList[i].getMaHang() == maHang)
				return arrList[i];
		}
		return null;
	}

	public int indexProducts(int maHang) {
		int i;
		for (i = 0; i < count; i++) {
			if (arrList[i].getMaHang() == maHang)
				break;
		}
		return i;
	}

	public boolean addProducts(HangThucPham products) {
		if (searchProducts(products.getMaHang()) != null)
			return false;
		else if (count == arrList.length)
			MangTangKichThuoc();
		arrList[count] = products;
		count++;
		return true;
	}

	public boolean deleteProducts(HangThucPham products) {
		try {
			int vitri = indexProducts(products.getMaHang());
			for (int i = vitri; i < arrList.length - 1; i++) {
				arrList[i] = arrList[i + 1];
			}
			count--;
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public double sumProducts() {
		double sum = 0;
		for (int i = 0; i < count; i++) {
			sum += arrList[i].getDonGia();
		}
		return sum;
	}

	public HangThucPham[] exportAllListProducts() {
		return arrList;
	}

	private void MangTangKichThuoc() {
		HangThucPham temp[] = new HangThucPham[(int) (arrList.length * 2)];
		for (int i = 0; i < arrList.length; i++)
			temp[i] = arrList[i];
		arrList = temp;
	}

}
