package com.oop_lab;

import com.oop_lab.app.CameraApp;
import com.oop_lab.controller.AppController;
import com.oop_lab.service.CameraService;
import com.oop_lab.service.DoVatService;
import com.oop_lab.service.RoomService;
import com.oop_lab.view.AppView;

public class Main {

    public static void main(String[] args) {

        CameraApp app = new CameraApp("Camera app");
        AppController controller = new AppController(
                app, new AppView(),
                new CameraService(),
                new DoVatService(),
                new RoomService());

        controller.runApp();
    }
}
