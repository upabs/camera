package com.oop_lab.model.khong_gian;

public class MatPhang {
    private ToaDo vectorPhapTuyen;
    private ToaDo diemThuoc;

    public MatPhang(ToaDo vectorPhapTuyen, ToaDo diemThuoc) {
        this.vectorPhapTuyen = vectorPhapTuyen;
        this.diemThuoc = diemThuoc;
    }

    public ToaDo getVectorPhapTuyen() {
        return vectorPhapTuyen;
    }

    public void setVectorPhapTuyen(ToaDo vectorPhapTuyen) {
        this.vectorPhapTuyen = vectorPhapTuyen;
    }

    public ToaDo getDiemThuoc() {
        return diemThuoc;
    }

    public void setDiemThuoc(ToaDo diemThuoc) {
        this.diemThuoc = diemThuoc;
    }
}
