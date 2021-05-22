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

        return (
            toaDo.khoangCachToiDuongThang(ab)
                    + toaDo.khoangCachToiDuongThang(cd)
                    == this.dinhA.khoangCach(this.dinhD) &&
            toaDo.khoangCachToiDuongThang(ad)
                    + toaDo.khoangCachToiDuongThang(bc)
                    == this.dinhA.khoangCach(this.dinhB)
        );
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
