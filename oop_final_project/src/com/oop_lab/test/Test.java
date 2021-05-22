package com.oop_lab.test;

import com.oop_lab.model.Camera;
import com.oop_lab.model.DoVat;
import com.oop_lab.model.Room;
import com.oop_lab.model.khong_gian.*;
import com.oop_lab.service.CameraService;
import com.oop_lab.service.DoVatService;
import com.oop_lab.service.RoomService;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        RoomService roomService = new RoomService();
        List<ToaDo> dsDinh = new ArrayList<ToaDo>();

        dsDinh.add(new ToaDo(0, 0, 0));
        dsDinh.add(new ToaDo(2, 0, 0));
        dsDinh.add(new ToaDo(2, 1, 0));
        dsDinh.add(new ToaDo(0, 1, 0));
        dsDinh.add(new ToaDo(0, 0, 1));
        dsDinh.add(new ToaDo(2, 0, 1));
        dsDinh.add(new ToaDo(2, 1, 1));
        dsDinh.add(new ToaDo(0, 1, 1));

        Room room = roomService.createRoom(dsDinh);
        CameraService cameraService = new CameraService();
        Camera camera = cameraService.createCamera(new ToaDo(0f, 0.5f, 0.5f), 90, 90);

        roomService.themCamera(room, camera);

        DoVatService doVatService = new DoVatService();
        List<ToaDo> cacDinh = new ArrayList<ToaDo>();
        cacDinh.add(new ToaDo(0.5f, 0.25f, 0));
        cacDinh.add(new ToaDo(1.5f, 0.25f, 0));
        cacDinh.add(new ToaDo(1.5f, 0.75f, 0));
        cacDinh.add(new ToaDo(0.5f, 0.75f, 0));
        cacDinh.add(new ToaDo(0.5f, 0.25f, 0.5f));
        cacDinh.add(new ToaDo(1.5f, 0.25f, 0.5f));
        cacDinh.add(new ToaDo(1.5f, 0.75f, 0.5f));
        cacDinh.add(new ToaDo(0.5f, 0.75f, 0.5f));

        DoVat doVat = doVatService.createDoVat(cacDinh);
        roomService.themDoVat(room, doVat);

        float f = roomService.theTichVungNhinThay(room, 200, 200, 100);
        System.out.println(f);
    }
}
