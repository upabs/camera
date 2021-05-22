package com.oop_lab.model.khong_gian;

public class DuongThang {
    private ToaDo diemThuoc;
    private Vector vectorPhapTuyen;
    private Vector vectorChiPhuong;

    public DuongThang(ToaDo diemThuoc, Vector vector, boolean chiPhuong) {
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

        float A = matPhang.getVectorPhapTuyen().getX();
        float B = matPhang.getVectorPhapTuyen().getY();
        float C = matPhang.getVectorPhapTuyen().getZ();
        float D = matPhang.giaTriHangSoD();
        float t = - (
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
        float N = (toaDo.getX() - this.diemThuoc.getX()) / this.vectorChiPhuong.getX();

        return (
                ((toaDo.getY() - this.diemThuoc.getY()) / this.vectorChiPhuong.getY()) == N &&
                ((toaDo.getZ() - this.diemThuoc.getZ()) / this.vectorChiPhuong.getZ()) == N
        );
    }

    public boolean vuongGocVoiMatPhang(MatPhang matPhang) {
        Vector tichCoHuong = this.vectorChiPhuong.tichCoHuong(matPhang.getVectorPhapTuyen());

        return tichCoHuong.equals(new Vector(0, 0, 0));

    }

    public boolean catMatPhang(MatPhang matPhang) {
        if (this.vectorChiPhuong == null)
            return false;
        // (P): Ax + By + Cz + D = 0
        float A = matPhang.getVectorPhapTuyen().getX();
        float B = matPhang.getVectorPhapTuyen().getY();
        float C = matPhang.getVectorPhapTuyen().getZ();

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

    public Vector getVectorPhapTuyen() {
        return vectorPhapTuyen;
    }

    public void setVectorPhapTuyen(Vector vectorPhapTuyen) {
        this.vectorPhapTuyen = vectorPhapTuyen;
    }

    public Vector getVectorChiPhuong() {
        return vectorChiPhuong;
    }

    public void setVectorChiPhuong(Vector vectorChiPhuong) {
        this.vectorChiPhuong = vectorChiPhuong;
    }

    @Override
    public String toString() {
        return "DuongThang: " + "\n\t" +
                "x = " + this.diemThuoc.getX() + " + " + this.vectorChiPhuong.getX() + "t\n\t" + 
                "y = " + this.diemThuoc.getY() + " + " + this.vectorChiPhuong.getY() + "t\n\t" +
                "z = " + this.diemThuoc.getZ() + " + " + this.vectorChiPhuong.getZ() + "t\n\t";    
    }
}
