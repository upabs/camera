package com.oop_lab.service;

import com.oop_lab.model.Camera;
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

}
