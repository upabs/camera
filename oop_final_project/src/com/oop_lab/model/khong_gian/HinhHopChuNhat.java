package com.oop_lab.model.khong_gian;

import java.util.List;
import java.util.Map;

public class HinhHopChuNhat {

    public static final String MAT_DAY_DUOI_ABCD = "ABDC";
    public static final String MAT_DAY_TREN_EFGH = "EFGH";
    public static final String MAT_AEFB = "AEFB";
    public static final String MAT_ADHE = "ADHE";
    public static final String MAT_BCGF = "BCGF";
    public static final String MAT_CDHG = "CDHG";

    public static final String DINH_A   = "A";
    public static final String DINH_B   = "B";
    public static final String DINH_C   = "C";
    public static final String DINH_D   = "D";
    public static final String DINH_E   = "E";
    public static final String DINH_F   = "F";
    public static final String DINH_G   = "G";
    public static final String DINH_H   = "H";

    private Map<String, ToaDo> cacDinh;
    private Map<String, MatPhang> cacMat;
    private double chieuCao;

    public HinhHopChuNhat() {

    }

    public HinhHopChuNhat(List<ToaDo> danhSachCacDinh) {
        String[] tenDinh = {
                "A", "B", "C", "D",
                "E", "F", "G", "H"
        };
        for (int i = 0; i < 8; i++) {
            this.cacDinh.put(tenDinh[i], danhSachCacDinh.get(i));
        }
        this.chieuCao = this.cacDinh.get("A").khoangCach(this.cacDinh.get("E"));
        this.setCacMatPhang();
    }

    private void setCacMatPhang() {
        this.cacMat.put(MAT_DAY_DUOI_ABCD, new MatPhang(
                new ToaDo(
                        this.cacDinh.get(DINH_E).getX() - this.cacDinh.get(DINH_A).getX(),
                        this.cacDinh.get(DINH_E).getY() - this.cacDinh.get(DINH_A).getY(),
                        this.cacDinh.get(DINH_E).getZ() - this.cacDinh.get(DINH_A).getZ()
                ), this.cacDinh.get(DINH_A)));
        this.cacMat.put(MAT_DAY_TREN_EFGH, new MatPhang(
                new ToaDo(
                        this.cacDinh.get(DINH_E).getX() - this.cacDinh.get(DINH_A).getX(),
                        this.cacDinh.get(DINH_E).getY() - this.cacDinh.get(DINH_A).getY(),
                        this.cacDinh.get(DINH_E).getZ() - this.cacDinh.get(DINH_A).getZ()
                ), this.cacDinh.get(DINH_E)));
        this.cacMat.put(MAT_AEFB, new MatPhang(
                new ToaDo(
                        this.cacDinh.get(DINH_D).getX() - this.cacDinh.get(DINH_A).getX(),
                        this.cacDinh.get(DINH_D).getY() - this.cacDinh.get(DINH_A).getY(),
                        this.cacDinh.get(DINH_D).getZ() - this.cacDinh.get(DINH_A).getZ()
                ), this.cacDinh.get(DINH_A)));
        this.cacMat.put(MAT_ADHE, new MatPhang(
                new ToaDo(
                        this.cacDinh.get(DINH_B).getX() - this.cacDinh.get(DINH_A).getX(),
                        this.cacDinh.get(DINH_B).getY() - this.cacDinh.get(DINH_A).getY(),
                        this.cacDinh.get(DINH_B).getZ() - this.cacDinh.get(DINH_A).getZ()
                ), this.cacDinh.get(DINH_A)));
        this.cacMat.put(MAT_BCGF, new MatPhang(
                new ToaDo(
                        this.cacDinh.get(DINH_B).getX() - this.cacDinh.get(DINH_A).getX(),
                        this.cacDinh.get(DINH_B).getY() - this.cacDinh.get(DINH_A).getY(),
                        this.cacDinh.get(DINH_B).getZ() - this.cacDinh.get(DINH_A).getZ()
                ), this.cacDinh.get(DINH_B)));
        this.cacMat.put(MAT_CDHG, new MatPhang(
                new ToaDo(
                        this.cacDinh.get(DINH_D).getX() - this.cacDinh.get(DINH_A).getX(),
                        this.cacDinh.get(DINH_D).getY() - this.cacDinh.get(DINH_A).getY(),
                        this.cacDinh.get(DINH_D).getZ() - this.cacDinh.get(DINH_A).getZ()
                ), this.cacDinh.get(DINH_C)));
    }

    public double theTich() {
        // TO DO
        return 0;
    }

    public boolean chuaDiem(ToaDo toaDo) {
        // TO DO
        return true;
    }

    public List<MatPhang> getDanhSachCacMat() {
        return (List<MatPhang>) this.cacMat.values();
    }

    public Map<String, ToaDo> getCacDinh() {
        return cacDinh;
    }

    public void setCacDinh(Map<String, ToaDo> cacDinh) {
        this.cacDinh = cacDinh;
    }

    public Map<String, MatPhang> getCacMat() {
        return cacMat;
    }

    public void setCacMat(Map<String, MatPhang> cacMat) {
        this.cacMat = cacMat;
    }

    public double getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(double chieuCao) {
        this.chieuCao = chieuCao;
    }
}
