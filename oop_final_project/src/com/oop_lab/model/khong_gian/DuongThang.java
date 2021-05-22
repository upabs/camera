package com.oop_lab.model.khong_gian;

import java.util.ArrayList;
import java.util.List;

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

    // nhieu nhat 4 diem
    public List<ToaDo> giaoDiemVoiHinhHopChuNhat(HinhHopChuNhat hinhHopChuNhat) {
        List<ToaDo> dsGiaoDiem = new ArrayList<ToaDo>();
        ToaDo giaoDiem = null;

        giaoDiem = this.giaoDiemVoiMatPhang(hinhHopChuNhat.getCacMat()
                .get(HinhHopChuNhat.MAT_DAY_DUOI_ABCD));
        if (giaoDiem != null &&
                new HinhChuNhat(
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_A),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_B),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_C),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_D)
                ).chuaDiem(giaoDiem)
        ) dsGiaoDiem.add(giaoDiem.clone());

        giaoDiem = this.giaoDiemVoiMatPhang(hinhHopChuNhat.getCacMat()
                .get(HinhHopChuNhat.MAT_DAY_TREN_EFGH));
        if (giaoDiem != null &&
                new HinhChuNhat(
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_E),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_F),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_G),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_H)
                ).chuaDiem(giaoDiem) && !dsGiaoDiem.contains(giaoDiem)
        ) dsGiaoDiem.add(giaoDiem.clone());

        giaoDiem = this.giaoDiemVoiMatPhang(hinhHopChuNhat.getCacMat()
                .get(HinhHopChuNhat.MAT_CDHG));
        if (giaoDiem != null &&
                new HinhChuNhat(
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_C),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_D),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_H),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_G)
                ).chuaDiem(giaoDiem) && !dsGiaoDiem.contains(giaoDiem)
        ) dsGiaoDiem.add(giaoDiem.clone());

        giaoDiem = this.giaoDiemVoiMatPhang(hinhHopChuNhat.getCacMat()
                .get(HinhHopChuNhat.MAT_ADHE));
        if (giaoDiem != null &&
                new HinhChuNhat(
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_A),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_D),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_H),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_E)
                ).chuaDiem(giaoDiem) && !dsGiaoDiem.contains(giaoDiem)
        ) dsGiaoDiem.add(giaoDiem.clone());

        giaoDiem = this.giaoDiemVoiMatPhang(hinhHopChuNhat.getCacMat()
                .get(HinhHopChuNhat.MAT_AEFB));
        if (giaoDiem != null &&
                new HinhChuNhat(
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_A),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_E),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_F),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_B)
                ).chuaDiem(giaoDiem) && !dsGiaoDiem.contains(giaoDiem)
        ) dsGiaoDiem.add(giaoDiem.clone());

        giaoDiem = this.giaoDiemVoiMatPhang(hinhHopChuNhat.getCacMat()
                .get(HinhHopChuNhat.MAT_BCGF));
        if (giaoDiem != null &&
                new HinhChuNhat(
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_B),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_C),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_G),
                        hinhHopChuNhat.getCacDinh().get(HinhHopChuNhat.DINH_F)
                ).chuaDiem(giaoDiem) && !dsGiaoDiem.contains(giaoDiem)
        ) dsGiaoDiem.add(giaoDiem.clone());
        return dsGiaoDiem;
    }

    public boolean chuaDiem(ToaDo toaDo) {
        if (toaDo.equals(this.diemThuoc))
            return true;

        Vector vector = new Vector(this.diemThuoc, toaDo);

        return vector.tichCoHuong(this.vectorChiPhuong)
                .equals(new Vector(0, 0, 0));
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
