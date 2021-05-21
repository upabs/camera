package com.oop_lab.model.khong_gian;

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
                new ToaDo(
                        this.cacDinh.get(DINH_B).getX() - this.cacDinh.get(DINH_A).getX(),
                        this.cacDinh.get(DINH_B).getY() - this.cacDinh.get(DINH_A).getY(),
                        this.cacDinh.get(DINH_B).getZ() - this.cacDinh.get(DINH_A).getZ()
                ),
                new ToaDo(
                        this.cacDinh.get(DINH_C).getX() - this.cacDinh.get(DINH_A).getX(),
                        this.cacDinh.get(DINH_C).getY() - this.cacDinh.get(DINH_A).getY(),
                        this.cacDinh.get(DINH_C).getZ() - this.cacDinh.get(DINH_A).getZ()
                )
        ));
        this.cacMat.put(MAT_EAB, new MatPhang(
                this.cacDinh.get(DINH_A),
                new ToaDo(
                        this.cacDinh.get(DINH_B).getX() - this.cacDinh.get(DINH_A).getX(),
                        this.cacDinh.get(DINH_B).getY() - this.cacDinh.get(DINH_A).getY(),
                        this.cacDinh.get(DINH_B).getZ() - this.cacDinh.get(DINH_A).getZ()
                ),
                new ToaDo(
                        this.cacDinh.get(DINH_CHOP_E).getX() - this.cacDinh.get(DINH_A).getX(),
                        this.cacDinh.get(DINH_CHOP_E).getY() - this.cacDinh.get(DINH_A).getY(),
                        this.cacDinh.get(DINH_CHOP_E).getZ() - this.cacDinh.get(DINH_A).getZ()
                )
        ));
        this.cacMat.put(MAT_EAD, new MatPhang(
                this.cacDinh.get(DINH_A),
                new ToaDo(
                        this.cacDinh.get(DINH_D).getX() - this.cacDinh.get(DINH_A).getX(),
                        this.cacDinh.get(DINH_D).getY() - this.cacDinh.get(DINH_A).getY(),
                        this.cacDinh.get(DINH_D).getZ() - this.cacDinh.get(DINH_A).getZ()
                ),
                new ToaDo(
                        this.cacDinh.get(DINH_CHOP_E).getX() - this.cacDinh.get(DINH_A).getX(),
                        this.cacDinh.get(DINH_CHOP_E).getY() - this.cacDinh.get(DINH_A).getY(),
                        this.cacDinh.get(DINH_CHOP_E).getZ() - this.cacDinh.get(DINH_A).getZ()
                )
        ));
        this.cacMat.put(MAT_EDC, new MatPhang(
                this.cacDinh.get(DINH_C),
                new ToaDo(
                        this.cacDinh.get(DINH_D).getX() - this.cacDinh.get(DINH_CHOP_E).getX(),
                        this.cacDinh.get(DINH_D).getY() - this.cacDinh.get(DINH_CHOP_E).getY(),
                        this.cacDinh.get(DINH_D).getZ() - this.cacDinh.get(DINH_CHOP_E).getZ()
                ),
                new ToaDo(
                        this.cacDinh.get(DINH_C).getX() - this.cacDinh.get(DINH_CHOP_E).getX(),
                        this.cacDinh.get(DINH_C).getY() - this.cacDinh.get(DINH_CHOP_E).getY(),
                        this.cacDinh.get(DINH_C).getZ() - this.cacDinh.get(DINH_CHOP_E).getZ()
                )
        ));
        this.cacMat.put(MAT_ECB, new MatPhang(
                this.cacDinh.get(DINH_C),
                new ToaDo(
                        this.cacDinh.get(DINH_B).getX() - this.cacDinh.get(DINH_CHOP_E).getX(),
                        this.cacDinh.get(DINH_B).getY() - this.cacDinh.get(DINH_CHOP_E).getY(),
                        this.cacDinh.get(DINH_B).getZ() - this.cacDinh.get(DINH_CHOP_E).getZ()
                ),
                new ToaDo(
                        this.cacDinh.get(DINH_C).getX() - this.cacDinh.get(DINH_CHOP_E).getX(),
                        this.cacDinh.get(DINH_C).getY() - this.cacDinh.get(DINH_CHOP_E).getY(),
                        this.cacDinh.get(DINH_C).getZ() - this.cacDinh.get(DINH_CHOP_E).getZ()
                )
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
                dinhChopE, new ToaDo(diemM.getX() - dinhChopE.getX(),
                diemM.getY() - dinhChopE.getY(), diemM.getZ() - dinhChopE.getZ()
        ), true);
        ToaDo giaoDiem = duongThangNoiDinhChopVoiDiemM.giaoDiemVoiMatPhang(this.cacMat.get(MAT_DAY_ABCD));

        if (giaoDiem == null)
            return false;

        if ((diemM.khoangCach(dinhChopE) + diemM.khoangCach(giaoDiem))
            != dinhChopE.khoangCach(giaoDiem)
        ) return false;

        ToaDo dinhA = this.cacDinh.get(DINH_A);
        ToaDo dinhB = this.cacDinh.get(DINH_B);
        ToaDo dinhC = this.cacDinh.get(DINH_C);
        ToaDo dinhD = this.cacDinh.get(DINH_D);

        DuongThang duongThangAB = new DuongThang(
                dinhA,
                new ToaDo(
                    dinhB.getX() - dinhA.getX(),
                    dinhB.getY() - dinhA.getY(),
                    dinhB.getZ() - dinhA.getZ()
                ), true
        );
        DuongThang duongThangAD = new DuongThang(
                dinhA,
                new ToaDo(
                        dinhD.getX() - dinhA.getX(),
                        dinhD.getY() - dinhA.getY(),
                        dinhD.getZ() - dinhA.getZ()
                ), true
        );
        DuongThang duongThangBC = new DuongThang(
                dinhB,
                new ToaDo(
                        dinhC.getX() - dinhB.getX(),
                        dinhC.getY() - dinhB.getY(),
                        dinhC.getZ() - dinhB.getZ()
                ), true
        );
        DuongThang duongThangDC = new DuongThang(
                dinhD,
                new ToaDo(
                        dinhC.getX() - dinhD.getX(),
                        dinhC.getY() - dinhD.getY(),
                        dinhC.getZ() - dinhD.getZ()
                ), true
        );

        if ((giaoDiem.khoangCachToiDuongThang(duongThangAB)
            + giaoDiem.khoangCachToiDuongThang(duongThangDC))
            != dinhA.khoangCach(dinhD)
        ) return false;

        return (giaoDiem.khoangCachToiDuongThang(duongThangAD)
                + giaoDiem.khoangCachToiDuongThang(duongThangBC)) == dinhA.khoangCach(dinhB);
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
