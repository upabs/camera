package com.oop_lab.model.graphic2d;

import com.oop_lab.model.Camera;
import com.oop_lab.model.DoVat;
import com.oop_lab.model.Room;
import com.oop_lab.model.khong_gian.HinhHopChuNhat;
import com.oop_lab.model.khong_gian.ToaDo;
import com.oop_lab.service.CameraService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class RoomDrawer extends JPanel {
    private Room room;
    private int phongTo;

    public RoomDrawer(Room room, int phongTo) {
        this.room = room;
        this.phongTo = phongTo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;

        // drawing room
        graphics2D.setColor(Color.RED);
        graphics2D.draw(new Rectangle2D.Float(
                this.room.getCacDinh().get(HinhHopChuNhat.DINH_A).getX() * this.phongTo,
                this.room.getCacDinh().get(HinhHopChuNhat.DINH_A).getY() * this.phongTo,
                this.room.getChieuDai() * this.phongTo, this.room.getChieuRong() * this.phongTo
        ));


        // drawing do vat
        // TO DO
        graphics2D.setColor(Color.BLACK);
        for (DoVat doVat : this.room.getDanhSachDoVat()) {
            if (doVat.getDsDoVatNamTren().isEmpty()) {
                ToaDo dinhA = doVat.getCacDinh().get(HinhHopChuNhat.DINH_A);

                graphics2D.draw(new Rectangle2D.Float(
                        dinhA.getX() * this.phongTo, dinhA.getY() * this.phongTo,
                        doVat.getChieuDai() * this.phongTo, doVat.getChieuRong() * this.phongTo
                ));
            }
        }

        // drawing camera
        graphics2D.setColor(Color.BLUE);
        CameraService cameraService = new CameraService();
        for (Camera camera : room.getDanhSachCamera()) {
            ToaDo dinhE = camera.getToaDo();
            List<ToaDo> dsDiemCuoi = cameraService.toaDoChieuCameraLenOxy(camera, this.room);
            for (ToaDo toaDo : dsDiemCuoi) {
                graphics2D.draw(new Line2D.Float(
                        dinhE.getX() * this.phongTo,
                        dinhE.getY() * this.phongTo,
                        toaDo.getX() * this.phongTo,
                        toaDo.getY() * this.phongTo
                ));
            }
        }

    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
