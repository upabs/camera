package com.oop_lab.model.khong_gian;

public class HinhChuNhat {
    private ToaDo dinhA;
    private ToaDo dinhB;
    private ToaDo dinhC;
    private ToaDo dinhD;

    private MatPhang matPhang;

    public HinhChuNhat(ToaDo dinhA, ToaDo dinhB, ToaDo dinhC, ToaDo dinhD) {
        this.dinhA = dinhA;
        this.dinhB = dinhB;
        this.dinhC = dinhC;
        this.dinhD = dinhD;
        this.matPhang = new MatPhang(dinhA, dinhB, dinhC);
    }

    public boolean chuaDiem(ToaDo toaDo) {
        if (!this.matPhang.chuaDiem(toaDo))
            return false;

        DuongThang ab = new DuongThang(
                dinhA, new Vector(dinhA, dinhB), true);
        DuongThang ad = new DuongThang(
                dinhA, new Vector(dinhA, dinhD), true);
        DuongThang bc = new DuongThang(
                dinhB, new Vector(dinhB, dinhC), true);
        DuongThang cd = new DuongThang(
                dinhC, new Vector(dinhC, dinhD), true);

        float tong1 = (float) (Math.round((toaDo.khoangCachToiDuongThang(ab)
                    + toaDo.khoangCachToiDuongThang(cd)) * 1000000.0) / 1000000.0);
        float doDaiAD = (float) (Math.round(this.dinhA.khoangCach(this.dinhD)*1000000.0)/1000000.0);

        float tong2 = (float) (Math.round((toaDo.khoangCachToiDuongThang(ad)
                + toaDo.khoangCachToiDuongThang(bc)) * 1000000.0) / 1000000.0);
        float doDaiAB = (float) (Math.round(this.dinhA.khoangCach(this.dinhB)*1000000.0)/1000000.0);

        return (tong1 == doDaiAD && tong2 == doDaiAB);
    }

    public ToaDo getDinhA() {
        return dinhA;
    }

    public void setDinhA(ToaDo dinhA) {
        this.dinhA = dinhA;
    }

    public ToaDo getDinhB() {
        return dinhB;
    }

    public void setDinhB(ToaDo dinhB) {
        this.dinhB = dinhB;
    }

    public ToaDo getDinhC() {
        return dinhC;
    }

    public void setDinhC(ToaDo dinhC) {
        this.dinhC = dinhC;
    }

    public ToaDo getDinhD() {
        return dinhD;
    }

    public void setDinhD(ToaDo dinhD) {
        this.dinhD = dinhD;
    }

    public MatPhang getMatPhang() {
        return matPhang;
    }

    public void setMatPhang(MatPhang matPhang) {
        this.matPhang = matPhang;
    }
}
