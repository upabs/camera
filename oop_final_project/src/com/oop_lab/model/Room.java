package com.oop_lab.model;

import com.oop_lab.model.khong_gian.HinhHopChuNhat;
import com.oop_lab.model.khong_gian.ToaDo;

import java.util.ArrayList;
import java.util.List;

public class Room extends HinhHopChuNhat {

    private List<DoVat> danhSachDoVat = new ArrayList<DoVat>();
    private List<Camera> danhSachCamera = new ArrayList<Camera>();

    public Room(List<ToaDo> danhSachCacDinh) {
        super(danhSachCacDinh);
    }

    public Room(double chieuCao, double chieuDai, double chieuRong) {
        super(chieuCao, chieuDai, chieuRong);
    }

    public void themDoVat(DoVat doVat) {
        this.danhSachDoVat.add(doVat);
    }

    public void themCamera(Camera camera) {
        this.danhSachCamera.add(camera);
    }


    public List<DoVat> getDanhSachDoVat() {
        return danhSachDoVat;
    }

    public void setDanhSachDoVat(List<DoVat> danhSachDoVat) {
        this.danhSachDoVat = danhSachDoVat;
    }

    public List<Camera> getDanhSachCamera() {
        return danhSachCamera;
    }

    public void setDanhSachCamera(List<Camera> danhSachCamera) {
        this.danhSachCamera = danhSachCamera;
    }
}
