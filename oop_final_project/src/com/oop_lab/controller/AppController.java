package com.oop_lab.controller;

import com.oop_lab.app.CameraApp;
import com.oop_lab.model.Camera;
import com.oop_lab.model.DoVat;
import com.oop_lab.model.Room;
import com.oop_lab.model.khong_gian.ToaDo;
import com.oop_lab.service.CameraService;
import com.oop_lab.service.DoVatService;
import com.oop_lab.service.RoomService;
import com.oop_lab.view.AppView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppController {

    private CameraApp app;
    private AppView view;
    private DoVatService doVatService;
    private CameraService cameraService;
    private RoomService roomService;

    public AppController(
            CameraApp app,
            AppView view,
            CameraService cameraService,
            DoVatService doVatService,
            RoomService roomService
    ) {
        this.app = app;
        this.view = view;
        this.cameraService = cameraService;
        this.doVatService = doVatService;
        this.roomService = roomService;
    }

    public void runApp() {
        this.app.setRunning(true);

        while (this.app.isRunning()) {
            int userOption = this.view.menu(this.app.getName(), "start", "exit");
            switch (userOption) {
                case 1:
                    this.start();
                    break;
                case 2:
                    this.view.notice("message", "goodbye");
                    this.app.setRunning(false);
                    break;
                default:
                    this.view.notice("error", "...");
            }
        }
    }

    public void start() {
        String file = this.view.getDataInputFilePath();
        this.readDataFromInputFile(file);

        Map<String ,String> results = new HashMap<String, String>();

        double theTichCanPhong = this.roomService.theTichPhong(this.app.getRoom());
        results.put("the tich phong", theTichCanPhong + "");

        double theTichVungNhinThay = this.roomService.theTichVungNhinThay(this.app.getRoom());
        results.put("the tich nhin thay", theTichVungNhinThay + "");

        results.put(
                "ty le vung nhin duoc so voi phong",
                (theTichVungNhinThay/theTichCanPhong) + " %"
        );

        this.view.showResult(results);
    }

    public void readDataFromInputFile(String file) {
        // TO DO READ DATA AND CREATE ROOM
        List<ToaDo> cacDinhCuaPhong = null;
        this.app.setRoom(this.createRoom(cacDinhCuaPhong));

        if (this.app.getRoom() == null) return;

        // TO DO READ DATA AND CREATE, ADD DO VAT
        int soLuongDoVat = 0;
        for (int i = 0; i < soLuongDoVat; i++) {
            List<ToaDo> cacDinhCuaDoVat = null;
            DoVat doVat = this.createDoVat(cacDinhCuaDoVat);
            if (doVat != null)
                this.themDoVatVaoPhong(doVat);
        }

        // TO DO READ DATA AND CREATE, ADD CAMERA
        int soLuongCamera = 0;
        for (int i = 0; i < soLuongCamera; i++) {
            ToaDo toaDo = null;
            double gocCao = 0;
            double gocRong = 0;
            Camera camera = this.createCamera(toaDo, gocCao, gocRong);
            if (camera != null)
                this.themCameraVaoPhong(camera);
        }

    }

    public Room createRoom(double chieuCao, double chieuRong, double chieuDai) {
        Room room = this.roomService.createRoom(chieuCao, chieuRong, chieuDai);

        if (room != null)
            this.view.notice("message", "...");
        else
            this.view.notice("error", "...");

        return room;
    }

    public Room createRoom(List<ToaDo> cacDinh) {
        Room room = this.roomService.createRoom(cacDinh);

        if (room != null)
            this.view.notice("message", "...");
        else
            this.view.notice("error", "...");

        return room;
    }

    public DoVat createDoVat(List<ToaDo> cacDinh) {
        DoVat doVat = this.doVatService.createDoVat(cacDinh);

        if (doVat != null)
            this.view.notice("message", "...");
        else
            this.view.notice("error", "...");

        return doVat;
    }

    public Camera createCamera(ToaDo toaDo, double gocCao, double gocRong) {
        Camera camera = this.cameraService.createCamera(toaDo, gocCao, gocRong);

        if (camera != null)
            this.view.notice("message", "...");
        else
            this.view.notice("error", "...");

        return camera;
    }

    public void themDoVatVaoPhong(DoVat doVat) {
        if (this.roomService.themDoVat(this.app.getRoom(), doVat)) {
            this.view.notice("message", "...");
        } else {
            this.view.notice("error", "...");
        }
    }

    public void themCameraVaoPhong(Camera camera) {
        if (this.roomService.themCamera(this.app.getRoom(), camera)) {
            this.view.notice("message", "...");
        } else {
            this.view.notice("error", "...");
        }
    }
}














