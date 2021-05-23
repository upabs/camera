package com.oop_lab.test;

import com.oop_lab.app.CameraApp;
import com.oop_lab.controller.AppController;
import com.oop_lab.service.CameraService;
import com.oop_lab.service.DoVatService;
import com.oop_lab.service.RoomService;
import com.oop_lab.view.AppView;

public class Test {
    public static void main(String[] args) {
        CameraApp app = new CameraApp("Camera test app");
        AppController controller = new AppController(
                app, new AppView(),
                new CameraService(),
                new DoVatService(),
                new RoomService()
        );
        controller.readDataFromInputFile();
        controller.showResult();
    }
}
