package com.oop_lab.model.graphic2d;

import javax.swing.*;

public class RoomPicture extends JFrame {
    private RoomDrawer roomDrawer;

    public RoomPicture(RoomDrawer roomDrawer) {
        this.setSize(roomDrawer.getWidth() + 100, roomDrawer.getHeight() + 100);
        this.setLocationRelativeTo(null);
        this.setContentPane(roomDrawer);
        this.roomDrawer = roomDrawer;
    }

    public void exportImage() {
        this.roomDrawer.exportImage();
    }

    public RoomDrawer getRoomDrawer() {
        return roomDrawer;
    }

    public void setRoomDrawer(RoomDrawer roomDrawer) {
        this.roomDrawer = roomDrawer;
    }
}
