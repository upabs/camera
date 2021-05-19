package com.oop_lab.app;

import com.oop_lab.model.Room;

public class CameraApp {

    private String name;
    private boolean running;

    private Room room;

    public CameraApp(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
