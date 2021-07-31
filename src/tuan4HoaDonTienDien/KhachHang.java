package tuan4HoaDonTienDien;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public abstract class KhachHang {
    protected String maKhachHang, hoTen;
    protected Calendar ngayRaHD;
    protected double soLuong;
    protected double donGia;

    abstract public double thanhTien();

    public String getMaKhachHang() {
        return this.maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Calendar getNgayRaHD() {
        return this.ngayRaHD;
    }

    public void setNgayRaHD(Calendar ngayRaHD) {
        this.ngayRaHD = ngayRaHD;
    }

    public double getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return this.donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKhachHang);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        KhachHang other = (KhachHang) obj;
        return Objects.equals(maKhachHang, other.maKhachHang);
    }

    public KhachHang(String maKhachHang, String hoTen, Calendar ngayRaHD, double soLuong, double donGia) {
        super();
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.ngayRaHD = ngayRaHD;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public KhachHang() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("|" + "%-8s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15.1f" + "|" + "%15.1f" + "|",
                getMaKhachHang(), getHoTen(), formater.format(getNgayRaHD().getTime()), getSoLuong(), getDonGia());
    }

}
