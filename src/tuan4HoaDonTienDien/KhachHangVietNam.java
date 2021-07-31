package tuan4HoaDonTienDien;

import java.util.Calendar;

public class KhachHangVietNam extends KhachHang {
    private String doiTuongKh;
    private double dinhMuc;

    public String getDoiTuongKh() {
        return this.doiTuongKh;
    }

    public void setDoiTuongKh(String doiTuongKh) {
        this.doiTuongKh = doiTuongKh;
    }

    public double getDinhMuc() {
        return this.dinhMuc;
    }

    public void setDinhMuc(double dinhMuc) {
        this.dinhMuc = dinhMuc;
    }

    public KhachHangVietNam(String maKhachHang, String hoTen, Calendar ngayRaHD, double soLuong, double donGia,
            String doiTuongKh, double dinhMuc) {
        super(maKhachHang, hoTen, ngayRaHD, soLuong, donGia);
        this.doiTuongKh = doiTuongKh;
        this.dinhMuc = dinhMuc;
    }

    public KhachHangVietNam() {
        super();
        // TODO Auto-generated constructor stub
    }

    public KhachHangVietNam(String maKhachHang, String hoTen, Calendar ngayRaHD, double soLuong, double donGia) {
        super(maKhachHang, hoTen, ngayRaHD, soLuong, donGia);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double thanhTien() {
        // TODO Auto-generated method stub
        double thanhTien = 0;
        if(getSoLuong() <= getDinhMuc())
        thanhTien = getSoLuong() * getDonGia();
        else {
            thanhTien = getSoLuong() * getDonGia() * getDinhMuc() + (getSoLuong() - getDinhMuc()) * getDonGia()* 2.5;
        }
        return thanhTien;
    }

    @Override
    public String toString() {
        String s = String.format("%15s" + "|" + "%15.1f" + "|", getDoiTuongKh(), getDinhMuc());
        return super.toString() + s;
    }

}
