package com.oop_lab.model.khong_gian;

import java.util.List;
import java.util.Map;

public class HinhChop {
    public static final String DINH_A   = "A";
    public static final String DINH_B   = "B";
    public static final String DINH_C   = "C";
    public static final String DINH_D   = "D";
    public static final String DINH_E   = "E";


    public static final String MAT_EAB = "EAB";
    public static final String MAT_EAD = "EAD";
    public static final String MAT_EDC = "EDC";
    public static final String MAT_ECB = "ECB";
    public static final String MAT_DAY_ABCD = "ABCD";


    private Map<String, ToaDo> cacDinh;
    private Map<String, MatPhang> cacMat;

    public double theTich() {
        // TO DO
        return 0;
    }

    public boolean chuaDiem(ToaDo toaDo) {
        // TO DO
        return true;
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
}
