package tuan5HangHoaSanhSu;

public class HangDienMay extends HangHoa {
    private double thoiGianBh;
    private double congXuat;

    public double getThoiGianBh() {
        return this.thoiGianBh;
    }

    public void setThoiGianBh(int thoiGianBh) {
        this.thoiGianBh = thoiGianBh;
    }

    public double getCongXuat() {
        return this.congXuat;
    }

    public void setCongXuat(double congXuat) {
        this.congXuat = congXuat;
    }

    public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia, double thoiGianBh,
            double congXuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.thoiGianBh = thoiGianBh;
        this.congXuat = congXuat;
    }

    public HangDienMay(int thoiGianBh, double congXuat) {
        this.thoiGianBh = thoiGianBh;
        this.congXuat = congXuat;
    }

    public HangDienMay() {
    }

    @Override
    public String mucDoBanBuon() {
        if (getSoLuongTon() < 3) {
            return "Bán được";
        } else
            return "N/A";
    }

    @Override
    public double tienVATHangHoa() {
        return getDonGia() * getSoLuongTon() * 0.1;
    }

    @Override
    public String toString() {
        String s = String.format("%15s" + "|" + "%15s" + "|" + "%17s" + "|", getThoiGianBh(), getCongXuat(),
                mucDoBanBuon());
        return super.toString() + s;
    }

}
