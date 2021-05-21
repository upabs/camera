package com.oop_lab.model.khong_gian;

public class MatPhang {
    private ToaDo vectorPhapTuyen;
    private ToaDo diemThuoc;

    private ToaDo[] capVectorChiPhuong = new ToaDo[2];

    public MatPhang() {

    }

    public MatPhang(ToaDo vectorPhapTuyen, ToaDo diemThuoc) {
        this.vectorPhapTuyen = vectorPhapTuyen;
        this.diemThuoc = diemThuoc;
    }

    public MatPhang(ToaDo diemThuoc, ToaDo... capVectorChiPhuong) {
        this.diemThuoc = diemThuoc;
        this.capVectorChiPhuong[0] = capVectorChiPhuong[0];
        this.capVectorChiPhuong[1] = capVectorChiPhuong[1];
        this.vectorPhapTuyen = this.capVectorChiPhuong[0].tichCoHuong(this.capVectorChiPhuong[1]);
    }

    public double khoangCachDiemToiMat(ToaDo toaDoDiemM) {
        if (this.chuaDiem(toaDoDiemM))
            return 0;
        ToaDo toaDoDiemH = toaDoDiemM.hinhChieuTrenMatPhang(this);
        return toaDoDiemM.khoangCach(toaDoDiemH);
    }

    public boolean chuaDiem(ToaDo toaDo) {
        return (
            this.getVectorPhapTuyen().getX() * toaDo.getX() +
            this.getVectorPhapTuyen().getY() * toaDo.getY() +
            this.getVectorPhapTuyen().getZ() * toaDo.getZ() +
            this.giaTriHangSoD() == 0
        );
    }

    public double giaTriHangSoD() {
        double A = this.vectorPhapTuyen.getX();
        double B = this.vectorPhapTuyen.getY();
        double C = this.vectorPhapTuyen.getZ();

        return - (A * this.diemThuoc.getX() + B * this.diemThuoc.getY() + C * this.diemThuoc.getZ());
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

    public ToaDo[] getCapVectorChiPhuong() {
        return capVectorChiPhuong;
    }

    public void setCapVectorChiPhuong(ToaDo[] capVectorChiPhuong) {
        this.capVectorChiPhuong = capVectorChiPhuong;
    }

    @Override
    public boolean equals(Object obj) {
        MatPhang other = (MatPhang) obj;
        ToaDo tichCoHuong = this.vectorPhapTuyen.tichCoHuong(other.getVectorPhapTuyen());
        return (
            other.chuaDiem(this.diemThuoc) &&
            tichCoHuong.getX() == 0 &&
            tichCoHuong.getY() == 0 &&
            tichCoHuong.getZ() == 0
        );
    }
}
