package tuan6TrueLove_e;

import java.util.Objects;

public class NhanVien implements Comparable<NhanVien> {
    private String maNv;
    private String tenNv;
    private long doanhSo;

    public long getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(long doanhSo) {
        this.doanhSo = doanhSo;
    }

    public String getMaNv() {
        return this.maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getTenNv() {
        return this.tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNv);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NhanVien other = (NhanVien) obj;
        return Objects.equals(maNv, other.maNv);
    }

    public NhanVien(String maNv, String tenNv, long doanhSo) {
        this.maNv = maNv;
        this.tenNv = tenNv;
        this.doanhSo = doanhSo;
    }

    public NhanVien() {
    }

    @Override
    public int compareTo(NhanVien o) {
        Long l1 = getDoanhSo();
        Long l2 = o.getDoanhSo();
        return l1.compareTo(l2);
    }

    @Override
    public String toString() {
        return String.format("|" + "%-8s" + "|" + "%15s" + "|" + "%,15d" + "|", getMaNv(), getTenNv(), getDoanhSo());
    }

}
