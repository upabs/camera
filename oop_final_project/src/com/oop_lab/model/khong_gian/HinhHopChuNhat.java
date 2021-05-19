package com.oop_lab.model.khong_gian;

import java.util.List;
import java.util.Map;

public class HinhHopChuNhat {
    private Map<String, ToaDo> cacDinh;
    private Map<String, MatPhang> cacMat;
    private double chieuCao;

    public HinhHopChuNhat() {

    }

    public HinhHopChuNhat(List<ToaDo> danhSachCacDinh) {
        // TO DO
    }

    public double theTich() {
        // TO DO
        return 0;
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
