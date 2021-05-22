package com.oop_lab.model;

import com.oop_lab.model.khong_gian.HinhChop;
import com.oop_lab.model.khong_gian.ToaDo;

public class Camera {

    private ToaDo toaDo;
    private float tamNhin = 1;
    private float gocCao;
    private float gocRong;
    private HinhChop vungNhin;

    public Camera (ToaDo toaDo, float gocCao, float gocRong) {
        this.toaDo = toaDo;
        this.gocCao = gocCao;
        this.gocRong = gocRong;
    }

    public ToaDo getToaDo() {
        return toaDo;
    }

    public void setToaDo(ToaDo toaDo) {
        this.toaDo = toaDo;
    }

    public float getTamNhin() {
        return tamNhin;
    }

    public void setTamNhin(float tamNhin) {
        this.tamNhin = tamNhin;
    }

    public float getGocCao() {
        return gocCao;
    }

    public void setGocCao(float gocCao) {
        this.gocCao = gocCao;
    }

    public float getGocRong() {
        return gocRong;
    }

    public void setGocRong(float gocRong) {
        this.gocRong = gocRong;
    }

    public HinhChop getVungNhin() {
        return vungNhin;
    }

    public void setVungNhin(HinhChop vungNhin) {
        this.vungNhin = vungNhin;
    }

    @Override
    public String toString() {
        return "Camera{" + this.getToaDo().getX()
                + ", " + this.getToaDo().getY() + ", " + this.getToaDo().getZ()
                + ", " + this.gocRong + ", " + this.gocCao + "}";
    }
}
