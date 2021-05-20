package com.oop_lab.service;

import com.oop_lab.model.Camera;
import com.oop_lab.model.khong_gian.HinhChop;
import com.oop_lab.model.khong_gian.MatPhang;
import com.oop_lab.model.khong_gian.ToaDo;

public class CameraService {

    public Camera createCamera(ToaDo toaDo, double gocCao, double gocRong) {
        if (cameraHopLe(gocCao, gocRong))
            return new Camera(toaDo, gocCao, gocRong);
        return null;
    }

    public boolean cameraHopLe(double gocCao, double gocRong) {
        // TO DO
        return true;
    }

    public double theTichNhinThay(Camera camera) {
        return camera.getVungNhin().theTich();
    }

    public boolean diemNamTrongVungNhinDuocCuaCamera(Camera camera, ToaDo toaDo) {
        return camera.getVungNhin().chuaDiem(toaDo);
    }
}
