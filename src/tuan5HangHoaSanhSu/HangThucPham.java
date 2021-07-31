package tuan5HangHoaSanhSu;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class HangThucPham extends HangHoa {
    private Calendar ngaySanXuat, ngayHethan;
    private String nhaCungCap;

    public Calendar getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Calendar ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public Calendar getNgayHethan() {
        return ngayHethan;
    }

    public void setNgayHethan(Calendar ngayHethan) {
        this.ngayHethan = ngayHethan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia, Calendar ngaySanXuat,
            Calendar ngayHethan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHethan = ngayHethan;
        this.nhaCungCap = nhaCungCap;
    }

    public HangThucPham(Calendar ngaySanXuat, Calendar ngayHethan, String nhaCungCap) {
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHethan = ngayHethan;
        this.nhaCungCap = nhaCungCap;
    }

    public HangThucPham() {
    }

    public long ngayHH() {
        Calendar today = Calendar.getInstance();
        long betWeenDates = ChronoUnit.DAYS.between(today.toInstant(), getNgayHethan().toInstant());
        return betWeenDates;
    }

    @Override
    public String mucDoBanBuon() {
        if (getSoLuongTon() > 0 && ngayHH() < 0) {
            return "Khó bán";
        } else
            return "N/A";
    }

    @Override
    public double tienVATHangHoa() {
        return getSoLuongTon() * getDonGia() * 0.05;
    }

    @Override
    public String toString() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        String s = String.format("%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%15s" + "|" + "%17s" + "|",
                formater.format(getNgaySanXuat().getTime()), formater.format(getNgayHethan().getTime()),
                getNhaCungCap(), ngayHH() + " ngày", mucDoBanBuon());
        return super.toString() + s;
    }

}
