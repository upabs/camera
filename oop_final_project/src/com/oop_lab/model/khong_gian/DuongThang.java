package com.oop_lab.model.khong_gian;

public class DuongThang {
    private ToaDo diemThuoc;
    private ToaDo vectorPhapTuyen;
    private ToaDo vectorChiPhuong;

    public DuongThang(ToaDo diemThuoc, ToaDo vector, boolean chiPhuong) {
        this.diemThuoc = diemThuoc;
        if (chiPhuong)
            this.vectorChiPhuong = vector;
        else
            this.vectorPhapTuyen = vector;
    }

    public ToaDo giaoDiemVoiMatPhang(MatPhang matPhang) {
        if (!this.catMatPhang(matPhang))
            return null;

        if (this.vuongGocVoiMatPhang(matPhang))
            return this.diemThuoc.hinhChieuTrenMatPhang(matPhang);

        double A = matPhang.getVectorPhapTuyen().getX();
        double B = matPhang.getVectorPhapTuyen().getY();
        double C = matPhang.getVectorPhapTuyen().getZ();
        double D = matPhang.giaTriHangSoD();
        double t = - (
                D + this.diemThuoc.getX() * A +
                this.diemThuoc.getY() * B +
                this.diemThuoc.getZ() * C
            ) / (
                this.vectorChiPhuong.getX() * A +
                this.vectorChiPhuong.getY() * B +
                this.vectorChiPhuong.getZ() * C
            );

        return new ToaDo(
            this.diemThuoc.getX() + this.vectorChiPhuong.getX() * t,
            this.diemThuoc.getY() + this.vectorChiPhuong.getY() * t,
            this.diemThuoc.getZ() + this.vectorChiPhuong.getZ() * t
        );
    }

    public boolean chuaDiem(ToaDo toaDo) {
        double N = (toaDo.getX() - this.diemThuoc.getX()) / this.vectorChiPhuong.getX();

        return (
                (toaDo.getY() - this.diemThuoc.getY()) / this.vectorChiPhuong.getY() == N &&
                (toaDo.getZ() - this.diemThuoc.getZ()) / this.vectorChiPhuong.getZ() == N
        );
    }

    public boolean vuongGocVoiMatPhang(MatPhang matPhang) {
        ToaDo tichCoHuong = this.vectorChiPhuong.tichCoHuong(matPhang.getVectorPhapTuyen());

        return (
            tichCoHuong.getX() == 0 &&
            tichCoHuong.getY() == 0 &&
            tichCoHuong.getZ() == 0
        );

    }

    public boolean catMatPhang(MatPhang matPhang) {
        if (this.vectorChiPhuong == null)
            return false;
        // (P): Ax + By + Cz + D = 0
        double A = matPhang.getVectorPhapTuyen().getX();
        double B = matPhang.getVectorPhapTuyen().getY();
        double C = matPhang.getVectorPhapTuyen().getZ();

        return A * this.vectorChiPhuong.getX() +
                B * this.vectorChiPhuong.getY() +
                C * this.vectorChiPhuong.getZ() != 0;
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
