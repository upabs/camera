package com.oop_lab.model.khong_gian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HinhChop {
    public static final String DINH_A       = "A";
    public static final String DINH_B       = "B";
    public static final String DINH_C       = "C";
    public static final String DINH_D       = "D";
    public static final String DINH_CHOP_E  = "E";

    public static final String MAT_EAB      = "EAB";
    public static final String MAT_EAD      = "EAD";
    public static final String MAT_EDC      = "EDC";
    public static final String MAT_ECB      = "ECB";
    public static final String MAT_DAY_ABCD = "ABCD";

    private Map<String, ToaDo> cacDinh = new HashMap<String, ToaDo>();
    private Map<String, MatPhang> cacMat = new HashMap<String, MatPhang>();

    public HinhChop() {

    }

    public HinhChop(ToaDo... danhSachDinh) {
        String[] tenDinh = {"E", "A", "B", "C", "D"};

        for (int i = 0; i < 5; i++) {
            this.cacDinh.put(tenDinh[i], danhSachDinh[i]);
        }
        this.setupCacMat();
    }

    private void setupCacMat() {
        this.cacMat.put(MAT_DAY_ABCD, new MatPhang(
                this.cacDinh.get(DINH_A),
                this.cacDinh.get(DINH_B),
                this.cacDinh.get(DINH_C)
        ));

        this.cacMat.put(MAT_EAB, new MatPhang(
                this.cacDinh.get(DINH_A),
                this.cacDinh.get(DINH_B),
                this.cacDinh.get(DINH_CHOP_E)
        ));

        this.cacMat.put(MAT_EAD, new MatPhang(
                this.cacDinh.get(DINH_A),
                this.cacDinh.get(DINH_D),
                this.cacDinh.get(DINH_CHOP_E)
        ));

        this.cacMat.put(MAT_EDC, new MatPhang(
                this.cacDinh.get(DINH_D),
                this.cacDinh.get(DINH_C),
                this.cacDinh.get(DINH_CHOP_E)
        ));

        this.cacMat.put(MAT_ECB, new MatPhang(
                this.cacDinh.get(DINH_B),
                this.cacDinh.get(DINH_C),
                this.cacDinh.get(DINH_CHOP_E)
        ));
    }

    public float theTich() {
        ToaDo dinhE = this.cacDinh.get(DINH_CHOP_E);
        ToaDo dinhA = this.cacDinh.get(DINH_A);
        ToaDo dinhB = this.cacDinh.get(DINH_B);
        ToaDo dinhD = this.cacDinh.get(DINH_D);

        return dinhE.khoangCach(dinhE.hinhChieuTrenMatPhang(this.cacMat.get(MAT_DAY_ABCD)))
            * dinhA.khoangCach(dinhB) * dinhA.khoangCach(dinhD) / 3;
    }

    public boolean chuaDiem(ToaDo diemM) {
        ToaDo dinhChopE = this.cacDinh.get(DINH_CHOP_E);
        DuongThang duongThangNoiDinhChopVoiDiemM = new DuongThang(
                dinhChopE, new Vector(dinhChopE, diemM), true
        );
        ToaDo giaoDiem = duongThangNoiDinhChopVoiDiemM.giaoDiemVoiMatPhang(this.cacMat.get(MAT_DAY_ABCD));

        if (giaoDiem == null)
            return false;

        return new HinhChuNhat(
                this.cacDinh.get(DINH_A),
                this.cacDinh.get(DINH_B),
                this.cacDinh.get(DINH_C),
                this.cacDinh.get(DINH_D)
        ).chuaDiem(giaoDiem) && new DoanThang(dinhChopE, giaoDiem).chuaDiem(diemM);
    }

    public List<MatPhang> danhSachCacMat() {
        return new ArrayList<>(this.cacMat.values());
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

    @Override
    public String toString() {
        return "HinhChop{\n\t" +
                this.cacDinh.get(DINH_CHOP_E) +
                ", \n\t" + this.cacDinh.get(DINH_A) +
                ", \n\t" + this.cacDinh.get(DINH_B) +
                ", \n\t" + this.cacDinh.get(DINH_C) +
                ", \n\t" + this.cacDinh.get(DINH_D) +
                "\n}";
    }
}
