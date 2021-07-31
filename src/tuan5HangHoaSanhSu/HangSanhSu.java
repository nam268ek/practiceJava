package tuan5HangHoaSanhSu;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private Calendar ngayNhapKho;

    public String getNhaSanXuat() {
        return this.nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public Calendar getNgayNhapKho() {
        return this.ngayNhapKho;
    }

    public void setNgayNhapKho(Calendar ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }

    public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia, String nhaSanXuat,
            Calendar ngayNhapKho) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    public HangSanhSu(String nhaSanXuat, Calendar ngayNhapKho) {
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    public HangSanhSu() {
    }

    public long ngayLuuKho() {
        Calendar today = Calendar.getInstance();
        long betWeenDates = ChronoUnit.DAYS.between(today.toInstant(), getNgayNhapKho().toInstant());
        return betWeenDates;
    }

    @Override
    public String mucDoBanBuon() {
        if (getSoLuongTon() > 50 && ngayLuuKho() > 10) {
            return "Bán chậm";
        } else
            return "N/A";
    }

    @Override
    public double tienVATHangHoa() {
        return getSoLuongTon() * getDonGia() * 0.1;
    }

    @Override
    public String toString() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        String s = String.format("%15s" + "|" + "%15s" + "|" + "%17s" + "|", getNhaSanXuat(),
                formater.format(ngayNhapKho.getTime()), mucDoBanBuon());
        return super.toString() + s;
    }

}
