package com.oop_lab.model;

import com.oop_lab.model.khong_gian.HinhChop;
import com.oop_lab.model.khong_gian.ToaDo;

public class Camera {

    private ToaDo toaDo;
    private double tamNhin;
    private double gocCao;
    private double gocRong;
    private HinhChop vungNhin;

    public Camera (ToaDo toaDo, double gocCao, double gocRong) {
        this.toaDo = toaDo;
        this.gocCao = gocCao;
        this.gocRong = gocRong;
        this.tamNhin = 100;
        this.vungNhin = null; // TO DO
    }

    public ToaDo getToaDo() {
        return toaDo;
    }

    public void setToaDo(ToaDo toaDo) {
        this.toaDo = toaDo;
    }

    public double getTamNhin() {
        return tamNhin;
    }

    public void setTamNhin(double tamNhin) {
        this.tamNhin = tamNhin;
    }

    public double getGocCao() {
        return gocCao;
    }

    public void setGocCao(double gocCao) {
        this.gocCao = gocCao;
    }

    public double getGocRong() {
        return gocRong;
    }

    public void setGocRong(double gocRong) {
        this.gocRong = gocRong;
    }

    public HinhChop getVungNhin() {
        return vungNhin;
    }

    public void setVungNhin(HinhChop vungNhin) {
        this.vungNhin = vungNhin;
    }
}
