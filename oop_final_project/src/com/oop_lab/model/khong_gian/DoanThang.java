package com.oop_lab.model.khong_gian;

public class DoanThang {
    private ToaDo a;
    private ToaDo b;
    private ToaDo vectorPhapTuyen;

    public DoanThang(ToaDo a, ToaDo b) {
        this.a = a;
        this.b = b;
        this.vectorPhapTuyen = null;
    }

    public ToaDo catMatPhang(MatPhang matPhang) {
        // TO DO
        return null;
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

    public ToaDo getVectorPhapTuyen() {
        return vectorPhapTuyen;
    }

    public void setVectorPhapTuyen(ToaDo vectorPhapTuyen) {
        this.vectorPhapTuyen = vectorPhapTuyen;
    }
}
