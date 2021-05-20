package com.oop_lab.service;

import com.oop_lab.model.Camera;
import com.oop_lab.model.DoVat;
import com.oop_lab.model.Room;
import com.oop_lab.model.khong_gian.ToaDo;

import java.util.List;

public class RoomService {

    public Room createRoom(double cao, double rong, double dai) {
        if (roomHopLe(cao, rong, dai))
            return new Room(dai, rong, cao);
        return null;
    }

    public Room createRoom(List<ToaDo> danhSachCacDinh) {
        if (roomLaHinhHopChuNhat(danhSachCacDinh))
            return new Room(danhSachCacDinh);

        return null;
    }

    public boolean roomLaHinhHopChuNhat(List<ToaDo> danhSachCacDinh) {
        // TO DO
        return true;
    }

    public boolean roomHopLe(double cao, double rong, double dai) {
        return (cao > 0) && (rong > 0) && (dai > 0);
    }

    public boolean themDoVat(Room room, DoVat doVat) {
        if (!doVatNamTrongPhong(room, doVat)) return false;
        if (!doVatKhongChamTran(room, doVat)) return false;
        if (!doVatKhongBiVuong(room, doVat)) return false;
        if (!doVatNamTrenSanHoacTrenVatKhac(room, doVat)) return false;

        room.themDoVat(doVat);
        return true;
    }

    public boolean doVatNamTrongPhong(Room roomm, DoVat doVat) {
        // TO DO
        return true;
    }

    public boolean doVatKhongChamTran(Room room, DoVat doVat) {
        // TO DO
        return true;
    }

    public boolean doVatKhongBiVuong(Room room, DoVat doVat) {
        // TO DO
        return true;
    }

    public boolean doVatNamTrenSanHoacTrenVatKhac(Room room, DoVat doVat) {
        // TO DO
        return true;
    }

    public boolean themCamera(Room room, Camera camera) {
        if (!cameraNamTrenTuong(room, camera)) return false;
        if (!cameraKhongBiTrung(room, camera)) return false;
        if (!cameraSoiVaoTrongPhong(room, camera)) return false;

        room.themCamera(camera);
        return true;
    }

    public boolean cameraNamTrenTuong(Room room, Camera camera) {
        // TO DO
        return true;
    }

    public boolean cameraKhongBiTrung(Room room, Camera camera) {
        // TO DO
        return true;
    }

    public boolean cameraSoiVaoTrongPhong(Room room, Camera camera) {
        // TO DO
        return true;
    }

    public double theTichPhong(Room room) {
        // TO DO
        return 0;
    }

    public double theTichVungNhinThay(Room room, int x, int y, int z) {
        // TO DO
        return 0;
    }
}
