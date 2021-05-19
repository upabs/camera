package com.oop_lab.model;

import com.oop_lab.model.khong_gian.HinhHopChuNhat;
import com.oop_lab.model.khong_gian.ToaDo;

import java.util.List;

public class Room extends HinhHopChuNhat {

    private double chieuDai;
    private double chieuRong;
    private double chieuCao;

    private List<DoVat> danhSachDoVat;
    private List<Camera> danhSachCamera;

    public Room(List<ToaDo> danhSachCacDinh) {
        super(danhSachCacDinh);
        // TO DO
        // tinh cao, dai, rong
    }

    public Room(double chieuDai, double chieuRong, double chieuCao) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
        this.chieuCao = chieuCao;
    }

    public void themDoVat(DoVat doVat) {
        this.danhSachDoVat.add(doVat);
    }

    public void themCamera(Camera camera) {
        this.danhSachCamera.add(camera);
    }

    public double getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(double chieuDai) {
        this.chieuDai = chieuDai;
    }

    public double getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(double chieuRong) {
        this.chieuRong = chieuRong;
    }

    @Override
    public double getChieuCao() {
        return chieuCao;
    }

    @Override
    public void setChieuCao(double chieuCao) {
        this.chieuCao = chieuCao;
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
