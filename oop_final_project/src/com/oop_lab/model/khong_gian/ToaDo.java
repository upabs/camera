package com.oop_lab.model.khong_gian;

public class ToaDo {
    private float x;
    private float y;
    private float z;

    public ToaDo(){

    }
    public ToaDo(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float khoangCach(ToaDo other) {
        if (other == null) return -1;
        return (float) (Math.sqrt(Math.pow(other.getX() - this.x, 2) +
                Math.pow(other.getY() - this.y, 2) + Math.pow(other.getZ() - this.z, 2)));
    }

    public float khoangCachToiDuongThang(DuongThang duongThang) {
        ToaDo tmp = new ToaDo(
                duongThang.getDiemThuoc().getX() - this.x,
                duongThang.getDiemThuoc().getY() - this.y,
                duongThang.getDiemThuoc().getZ() - this.z
        );

        float m = tmp.tichCoHuong(duongThang.getVectorChiPhuong()).khoangCachToiGocToaDo();
        float n = duongThang.getVectorChiPhuong().khoangCachToiGocToaDo();

        return m / n;
    }

    public ToaDo hinhChieuTrenMatPhang(MatPhang matPhang) {
        // (P): Ax + By + Cz + D = 0
        float A = matPhang.getVectorPhapTuyen().getX();
        float B = matPhang.getVectorPhapTuyen().getY();
        float C = matPhang.getVectorPhapTuyen().getZ();
        float D = - (A * matPhang.getDiemThuoc().getX() +
                        B * matPhang.getDiemThuoc().getY() +
                    C * matPhang.getDiemThuoc().getZ());

        float k = - (A * this.x + B * this.y + C * this.z + D)
                / (float) (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));

        return new ToaDo(
            this.x + A * k,
            this.y + B * k,
            this.z + C * k
        );
    }

    public float khoangCachDenMatPhang(MatPhang matPhang) {
        if (matPhang.chuaDiem(this))
            return 0;
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

    public float khoangCachToiGocToaDo() {
        return (float) (Math.sqrt(Math.pow(this.x, 2) +
                Math.pow(this.y, 2) + Math.pow(this.z, 2)));
    }
///////////////////////////////
    public static ToaDo vector(ToaDo a, ToaDo b) {
        // vector ab;
        ToaDo x = new ToaDo();
        x.setX(b.getX() - a.getX());
        x.setY(b.getY() - a.getY());
        x.setZ(b.getZ() - a.getZ());
        return x;
    }
    public float tichVoHuong(ToaDo other) {
        return this.x*other.getX() + this.y*other.getY() + this.z*other.getZ();
    }
    public float doDaiVector() {
        return (float) Math.sqrt(this.x*this.x + this.y*this.y +this.z*this.z);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
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
