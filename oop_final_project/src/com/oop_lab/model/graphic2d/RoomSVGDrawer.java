package com.oop_lab.model.graphic2d;

import com.oop_lab.model.Room;

import java.awt.*;

public class RoomSVGDrawer extends RoomDrawer {

    private int phongTo;
    private Room room;

    public RoomSVGDrawer(Room room, int phongTo) {
        this.setSize(
                (int) room.getChieuDai() * phongTo,
                (int) room.getChieuRong() * phongTo
        );
        this.phongTo = phongTo;
        this.room = room;
    }

    @Override
    void exportImage() {
        // TO DO
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TO DO
    }

    public int getPhongTo() {
        return phongTo;
    }

    public void setPhongTo(int phongTo) {
        this.phongTo = phongTo;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
