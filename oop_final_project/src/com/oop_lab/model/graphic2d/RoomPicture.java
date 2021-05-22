package com.oop_lab.model.graphic2d;

import com.oop_lab.model.Room;

import javax.swing.*;

public class RoomPicture extends JFrame {
    private Room room;

    public RoomPicture(Room room, int phongTo) {
        this.room = room;
        this.setSize(
                (int) this.room.getChieuDai() * phongTo + 100,
                (int) this.room.getChieuRong()  * phongTo + 100
        );
        this.setLocationRelativeTo(null);
        this.setContentPane(new RoomDrawer(this.room, phongTo));
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
