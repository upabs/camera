package com.oop_lab.model.khong_gian;

public class DuongThang {
    private ToaDo diemThuoc;
    private ToaDo vectorPhapTuyen;
    private ToaDo vectorChiPhuong;

    public DuongThang(ToaDo diemThuoc, ToaDo vector, boolean chiPhuong) {
        this.diemThuoc = diemThuoc;
        if (chiPhuong)
            this.vectorPhapTuyen = vector;
        else
            this.vectorPhapTuyen = vector;
    }

    public ToaDo giaoDiemVoiMatPhang(MatPhang matPhang) {
        if (this.catMatPhang(matPhang)) {
            // TO DO
        }
        return null;
    }

    public boolean chuaDiem(ToaDo toaDo) {
        double N = (toaDo.getX() - this.diemThuoc.getX()) / this.vectorChiPhuong.getX();

        return (
                (toaDo.getY() - this.diemThuoc.getY()) / this.vectorChiPhuong.getY() == N &&
                (toaDo.getZ() - this.diemThuoc.getZ()) / this.vectorChiPhuong.getZ() == N
        );
    }

    public boolean catMatPhang(MatPhang matPhang) {
        if (this.vectorChiPhuong == null)
            return false;

        // (P): Ax + By + Cz + D = 0
        double A = matPhang.getVectorPhapTuyen().getX();
        double B = matPhang.getVectorPhapTuyen().getY();
        double C = matPhang.getVectorPhapTuyen().getZ();

        return (A * this.vectorChiPhuong.getX() +
                B * this.vectorChiPhuong.getY() +
                C * this.vectorChiPhuong.getZ() != 0);
    }

    public ToaDo getDiemThuoc() {
        return diemThuoc;
    }

    public void setDiemThuoc(ToaDo diemThuoc) {
        this.diemThuoc = diemThuoc;
    }

    public ToaDo getVectorPhapTuyen() {
        return vectorPhapTuyen;
    }

    public void setVectorPhapTuyen(ToaDo vectorPhapTuyen) {
        this.vectorPhapTuyen = vectorPhapTuyen;
    }

    public ToaDo getVectorChiPhuong() {
        return vectorChiPhuong;
    }

    public void setVectorChiPhuong(ToaDo vectorChiPhuong) {
        this.vectorChiPhuong = vectorChiPhuong;
    }
}
