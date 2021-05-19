package com.oop_lab.model;

import com.oop_lab.model.khong_gian.HinhHopChuNhat;
import com.oop_lab.model.khong_gian.ToaDo;

import java.util.List;

public class DoVat extends HinhHopChuNhat {
    private String ten;
    private String mauSac;

    public DoVat(String ten, String mauSac) {
        this.ten = ten;
        this.mauSac = mauSac;
    }

    public DoVat(List<ToaDo> danhSachCacDinh) {
        super(danhSachCacDinh);
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
}
