package com.oop_lab.model.khong_gian;

public class DoanThang {
    private ToaDo a;
    private ToaDo b;

    public DoanThang(ToaDo a, ToaDo b) {
        this.a = a;
        this.b = b;
    }

    public ToaDo giaoDiemVoiMatPhang(MatPhang matPhang) {
        DuongThang duongThang = new DuongThang(
                a, new ToaDo(
                b.getX() - a.getX(),
                b.getY() - a.getY(),
                b.getZ() - a.getZ()
        ),true);
        ToaDo giaoDiem = duongThang.giaoDiemVoiMatPhang(matPhang);

        return this.chuaDiem(giaoDiem) ? giaoDiem : null;
    }

    public boolean chuaDiem(ToaDo toaDo) {
        DuongThang duongThang = new DuongThang(
                a, new ToaDo(
                b.getX() - a.getX(),
                b.getY() - a.getY(),
                b.getZ() - a.getZ()
        ),true);

        return (
                duongThang.chuaDiem(toaDo) &&
                this.doDai() == this.a.khoangCach(toaDo) + this.b.khoangCach(toaDo)
        );
    }

    public double doDai() {
        return this.a.khoangCach(this.b);
    }

    public ToaDo getA() {
        return a;
    }

    public void setA(ToaDo a) {
        this.a = a;
    }

    public ToaDo getB() {
        return b;
    }

    public void setB(ToaDo b) {
        this.b = b;
    }
}
