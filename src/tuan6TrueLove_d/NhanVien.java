package tuan6TrueLove_d;

import java.util.Objects;

public class NhanVien {
    private String maNv;
    private String tenNv;

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

    public NhanVien(String maNv, String tenNv) {
        this.maNv = maNv;
        this.tenNv = tenNv;
    }

    public NhanVien() {
    }

    @Override
    public String toString() {
        return String.format("|" + "%-8s" + "|" + "%15s" + "|", getMaNv(), getTenNv());
    }
}
