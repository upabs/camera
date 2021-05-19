package com.oop_lab.model.khong_gian;

public class ToaDo {
    private double x;
    private double y;
    private double z;

    public ToaDo(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double khoangCach(ToaDo other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) +
                Math.pow(other.y - this.y, 2) + Math.pow(other.z - this.z, 2));
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
