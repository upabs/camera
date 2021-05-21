package com.oop_lab.model.khong_gian;

public class ToaDo {
    private double x;
    private double y;
    private double z;

    public ToaDo(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double khoangCach(ToaDo other) {
        if (other == null) return -1;
        return Math.sqrt(Math.pow(other.x - this.x, 2) +
                Math.pow(other.y - this.y, 2) + Math.pow(other.z - this.z, 2));
    }

    public double khoangCachToiDuongThang(DuongThang duongThang) {
        ToaDo tmp = new ToaDo(
                duongThang.getDiemThuoc().getX() - this.x,
                duongThang.getDiemThuoc().getY() - this.y,
                duongThang.getDiemThuoc().getZ() - this.z
        );

        double m = tmp.tichCoHuong(duongThang.getVectorChiPhuong()).khoangCachToiGocToaDo();
        double n = duongThang.getVectorChiPhuong().khoangCachToiGocToaDo();

        return m / n;
    }

    public ToaDo hinhChieuTrenMatPhang(MatPhang matPhang) {
        // (P): Ax + By + Cz + D = 0
        double A = matPhang.getVectorPhapTuyen().getX();
        double B = matPhang.getVectorPhapTuyen().getY();
        double C = matPhang.getVectorPhapTuyen().getZ();
        double D = - (A * matPhang.getDiemThuoc().getX() +
                        B * matPhang.getDiemThuoc().getY() +
                    C * matPhang.getDiemThuoc().getZ());

        double k = - (A * this.x + B * this.y + C * this.z + D)
                / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));

        return new ToaDo(
            this.x + A * k,
            this.y + B * k,
            this.z + C * k
        );
    }

    public double khoangCachDenMatPhang(MatPhang matPhang) {
        ToaDo hinhChieu = this.hinhChieuTrenMatPhang(matPhang);
        return this.khoangCach(hinhChieu);
    }

    public ToaDo tichCoHuong(ToaDo other) {
        return new ToaDo(
            other.getY() * this.z - other.getZ() * this.y,
            other.getZ() * this.x - other.getX() * this.z,
            other.getX() * this.y - other.getY() * this.x
        );
    }

    public double khoangCachToiGocToaDo() {
        return Math.sqrt(Math.pow(this.x, 2) +
                Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        ToaDo other = (ToaDo) obj;
        return (other.getX() == this.x &&
                other.getY() == this.y &&
                other.getZ() == this.z);
    }

    @Override
    public String toString() {
        return "ToaDo{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
