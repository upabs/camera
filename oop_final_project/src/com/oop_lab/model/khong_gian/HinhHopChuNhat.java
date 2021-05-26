package com.oop_lab.model.khong_gian;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HinhHopChuNhat {

    public static final String MAT_DAY_DUOI_ABCD = "ABCD";
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

    private Map<String, ToaDo> cacDinh = new HashMap<String, ToaDo>();
    private Map<String, MatPhang> cacMat = new HashMap<String, MatPhang>();

    private float chieuCao;
    private float chieuDai;
    private float chieuRong;

    public HinhHopChuNhat() {

    }

    public HinhHopChuNhat(float chieuCao, float chieuDai, float chieuRong) {
        this.chieuCao = chieuCao;
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public HinhHopChuNhat(List<ToaDo> danhSachCacDinh) {
        String[] tenDinh = {
                "A", "B", "C", "D",
                "E", "F", "G", "H"
        };
        for (int i = 0; i < 8; i++) {
            this.cacDinh.put(tenDinh[i], danhSachCacDinh.get(i));
        }
        this.chieuCao = this.cacDinh.get(DINH_A).khoangCach(this.cacDinh.get(DINH_E));
        this.chieuDai = this.cacDinh.get(DINH_A).khoangCach(this.cacDinh.get(DINH_B));
        this.chieuRong = this.cacDinh.get(DINH_A).khoangCach(this.cacDinh.get(DINH_D));
        this.setCacMatPhang();
    }

    public static boolean hopLe(List<ToaDo> dsCacDinh) {
        int A = 0, B = 1, C = 2, D = 3,
                E = 4, F = 5, G = 6, H = 7;

        Vector AB = new Vector(dsCacDinh.get(A), dsCacDinh.get(B));
        Vector DC = new Vector(dsCacDinh.get(D), dsCacDinh.get(C));
        Vector EF = new Vector(dsCacDinh.get(E), dsCacDinh.get(F));
        Vector HG = new Vector(dsCacDinh.get(H), dsCacDinh.get(G));

        Vector AE = new Vector(dsCacDinh.get(A), dsCacDinh.get(E));
        Vector CG = new Vector(dsCacDinh.get(C), dsCacDinh.get(G));

        Vector AD = new Vector(dsCacDinh.get(A), dsCacDinh.get(D));

        if ( (float) Math.round(AD.doDai() * 1000) / 1000 == 0)     return false;

        if (!AB.equals(DC) || (float) Math.round(AB.doDai() *1000)/1000 == 0)     return false;   // ABCD <> hbh
        if (!EF.equals(HG) || (float) Math.round(EF.doDai() *1000)/1000 == 0)     return false;   // EFGH <> hbh
        if (!AE.equals(CG) || (float) Math.round(AE.doDai() *1000)/1000 == 0)     return false;   // AEDH <> hbh

        // AB ⊥ AD ⊥ AE
        if (AB.tichVoHuong(AD) != 0)    return false;
        if (AE.tichVoHuong(AB) != 0)    return false;
        if (AE.tichVoHuong(AD) != 0)    return false;

        return true;
    }

    private void setCacMatPhang() {
        this.cacMat.put(MAT_DAY_DUOI_ABCD, new MatPhang(
                new Vector(this.cacDinh.get(DINH_A), this.cacDinh.get(DINH_E)), 
                this.cacDinh.get(DINH_A)));
                
        this.cacMat.put(MAT_DAY_TREN_EFGH, new MatPhang(
                new Vector(this.cacDinh.get(DINH_A), this.cacDinh.get(DINH_E)), 
                this.cacDinh.get(DINH_E)));

        this.cacMat.put(MAT_AEFB, new MatPhang(
                new Vector(this.cacDinh.get(DINH_A), this.cacDinh.get(DINH_D)), 
                this.cacDinh.get(DINH_A)));

        this.cacMat.put(MAT_ADHE, new MatPhang(
                new Vector(this.cacDinh.get(DINH_A), this.cacDinh.get(DINH_B)), 
                this.cacDinh.get(DINH_A)));

        this.cacMat.put(MAT_BCGF, new MatPhang(
                new Vector(this.cacDinh.get(DINH_A), this.cacDinh.get(DINH_B)), 
                this.cacDinh.get(DINH_B)));

        this.cacMat.put(MAT_CDHG, new MatPhang(
                new Vector(this.cacDinh.get(DINH_A), this.cacDinh.get(DINH_D)), 
                this.cacDinh.get(DINH_C)));
    }

    public float theTich() {
        return this.chieuCao * this.chieuDai * this.chieuRong;
    }

    public boolean chuaDiem(ToaDo toaDo) {
        for (MatPhang matPhang : this.getDanhSachCacMat())
            if (matPhang.chuaDiem(toaDo))
                return false;

        if ((toaDo.khoangCachDenMatPhang(this.cacMat.get(MAT_DAY_DUOI_ABCD))
            + toaDo.khoangCachDenMatPhang(this.cacMat.get(MAT_DAY_TREN_EFGH)))
                != this.chieuCao
        ) return false;
        if ((toaDo.khoangCachDenMatPhang(this.cacMat.get(MAT_CDHG))
                + toaDo.khoangCachDenMatPhang(this.cacMat.get(MAT_AEFB)))
                != this.chieuRong
        ) return false;

        return (toaDo.khoangCachDenMatPhang(this.cacMat.get(MAT_ADHE))
                + toaDo.khoangCachDenMatPhang(this.cacMat.get(MAT_BCGF))) == this.chieuDai;
    }

    public ToaDo getTamDay() {
        Vector vectorAC = new Vector(this.cacDinh.get(DINH_A), this.cacDinh.get(DINH_C));
        float k = vectorAC.doDai() / 2;
        ToaDo tmp = this.cacDinh.get(DINH_A).clone();
        tmp.tinhTien(vectorAC.nhanFloat(k));
        return tmp;
    }

    public List<MatPhang> getDanhSachCacMat() {
        return new ArrayList<MatPhang>(this.getCacMat().values());
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

    public float getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(float chieuCao) {
        this.chieuCao = chieuCao;
    }

    public float getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(float chieuDai) {
        this.chieuDai = chieuDai;
    }

    public float getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(float chieuRong) {
        this.chieuRong = chieuRong;
    }
}
