package com.oop_lab.model.khong_gian;

import java.util.Map;

public class HinhChop {
    private Map<String, ToaDo> cacDinh;
    private Map<String, MatPhang> cacMat;

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
}
