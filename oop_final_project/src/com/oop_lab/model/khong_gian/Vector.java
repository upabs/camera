package com.oop_lab.model.khong_gian;

public class Vector {
    private float x;
    private float y;
    private float z;

    public Vector() {

    }

    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector(ToaDo a, ToaDo b) {
        this.x = b.getX() - a.getX();
        this.y = b.getY() - a.getY();
        this.z = b.getZ() - a.getZ();
    }

    public Vector(Vector v) {
        this.x = v.getX();
        this.y = v.getY();
        this.z = v.getZ();
    }

    public float doDai() {
        return (float) (Math.sqrt(Math.pow(this.x, 2) +
                                    Math.pow(this.y, 2) + 
                                    Math.pow(this.z, 2)));
    }

    public void congVector(Vector v) {
        this.x += v.getX();
        this.y += v.getY();
        this.z += v.getZ();
    }

    public Vector nhanFloat(float f) {
        return new Vector(
            this.x * f, 
            this.y * f, 
            this.z * f
        );
    }

    public float tichVoHuong(Vector v) {
        return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ();
    }

    public Vector tichCoHuong(Vector v) {
        return new Vector(
            v.getY() * this.z - v.getZ() * this.y,
            v.getZ() * this.x - v.getX() * this.z,
            v.getX() * this.y - v.getY() * this.x
        );
    }

    public void setTo(Vector v) {
        this.x = v.getX();
        this.y = v.getY();
        this.z = v.getZ();
    }

    public Vector clone() {
        return new Vector(this.x, this.y, this.z);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        Vector v = (Vector) obj;
        return this.x == v.getX() && 
                this.y == v.getY() &&
                this.z == v.getZ();
    }

    @Override
    public String toString() {
        return "Vector(" + this.x + "; "
                        + this.y + "; "
                        + this.z + ")";
    }
}
