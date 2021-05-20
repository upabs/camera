package com.oop_lab.model.khong_gian;

public class MatPhang {
    private ToaDo vectorPhapTuyen;
    private ToaDo diemThuoc;

    public MatPhang(ToaDo vectorPhapTuyen, ToaDo diemThuoc) {
        this.vectorPhapTuyen = vectorPhapTuyen;
        this.diemThuoc = diemThuoc;
    }

    public ToaDo toaDoHinhChieuDiemTrenMat(ToaDo toaDo) {
        // (P): Ax + By + Cz + D = 0
        double A = this.vectorPhapTuyen.getX();
        double B = this.vectorPhapTuyen.getY();
        double C = this.vectorPhapTuyen.getZ();
        double D = - (A * this.diemThuoc.getX() + B * this.diemThuoc.getY() + C * this.diemThuoc.getZ());

        double k = (A * toaDo.getX() + B * toaDo.getY() + C * toaDo.getZ() + D)
                / (Math.pow(A, 2) + Math.pow(B, 2) + Math.pow(C, 2));

        return new ToaDo(
                toaDo.getX() + A * k,
                toaDo.getY() + B * k,
                toaDo.getZ() + C * k
        );
    }

    public double khoangCachDiemToiMat(ToaDo toaDoDiemM) {
        ToaDo toaDoDiemH = this.toaDoHinhChieuDiemTrenMat(toaDoDiemM);
        return toaDoDiemM.khoangCach(toaDoDiemH);
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
