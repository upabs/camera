package com.oop_lab.service;

import com.oop_lab.model.Camera;
import com.oop_lab.model.DoVat;
import com.oop_lab.model.Room;
import com.oop_lab.model.khong_gian.DoanThang;
import com.oop_lab.model.khong_gian.MatPhang;
import com.oop_lab.model.khong_gian.ToaDo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public double theTichKhongGianPhong(Room room) {
        double tongTheTichVatTrongPhong = 0;

        for (DoVat doVat : room.getDanhSachDoVat())
            tongTheTichVatTrongPhong += doVat.theTich();

        return room.theTich() - tongTheTichVatTrongPhong;
    }

    public double theTichVungNhinThay(Room room, int x, int y, int z) {
        ToaDo dinhA = room.getCacDinh().get(Room.DINH_A);
        ToaDo dinhB = room.getCacDinh().get(Room.DINH_B);
        ToaDo dinhD = room.getCacDinh().get(Room.DINH_D);
        ToaDo dinhE = room.getCacDinh().get(Room.DINH_E);

        double startX = dinhA.getX();
        double startY = dinhA.getY();
        double startZ = dinhA.getZ();
        double endX = dinhB.getX();
        double endY = dinhD.getY();
        double endZ = dinhE.getZ();

        double stepX = (endX - startX + 1) / x;
        double stepY = (endY - startY + 1) / y;
        double stepZ = (endZ - startZ + 1) / z;

        int soLuongDiemXetDuyet = 0;
        int soLuongDiemNhinThay = 0;
        for (double i = startZ; i <= endZ; i += stepZ) {
            for (double j = startY; j < endY; j += stepY) {
                for (double k = startX; k < endX; k += stepX) {
                    ToaDo toaDoDiemDangXet = new ToaDo(k, j, i);

                    if (this.diemNamTrongDoVatNaoDo(room, toaDoDiemDangXet))
                        continue;

                    if (this.diemNamTrongVungNhinDuoc(room, toaDoDiemDangXet))
                        soLuongDiemNhinThay += 1;

                    soLuongDiemXetDuyet += 1;
                }
            }
        }

        return theTichKhongGianPhong(room) * soLuongDiemNhinThay / soLuongDiemXetDuyet;
    }

    public boolean diemNamTrongDoVatNaoDo(Room room, ToaDo toaDo) {
        DoVatService doVatService = new DoVatService();

        for (DoVat doVat : room.getDanhSachDoVat()) {
            if (doVatService.diemNamTrongDoVat(doVat, toaDo))
                return true;
        }

        return false;
    }

    public boolean diemNamTrongVungNhinDuoc(Room room, ToaDo toaDo) {
        List<Camera> dsCamera = this.danhSachCameraCoKhaNangNhinDuocDiem(room, toaDo);

        if (dsCamera.isEmpty())
            return false;

        List<DoVat> dsDoVat = room.getDanhSachDoVat();
        for (Camera camera : dsCamera) {
            DoanThang doanThangNoiCameraVoiDiem = new DoanThang(toaDo, camera.getToaDo());
            boolean stop = false;
            int i;
            for (i = 0; i < dsDoVat.size(); i++) {
                for (MatPhang matPhang : dsDoVat.get(i).getDanhSachCacMat()) {
                    ToaDo giaoDiem = doanThangNoiCameraVoiDiem.giaoDiemVoiMatPhang(matPhang);
                    if (giaoDiem != null && !giaoDiem.equals(toaDo)) {
                        stop = true;
                        break;
                    }
                }
                if (stop) break;
            }
            if (i == dsDoVat.size())
                return true;
        }

        return false;
    }

    public List<Camera> danhSachCameraCoKhaNangNhinDuocDiem(Room room, ToaDo toaDo) {
        CameraService cameraService = new CameraService();
        List<Camera> result = new ArrayList<Camera>();

        for (Camera camera : room.getDanhSachCamera())
            if (cameraService.diemNamTrongVungNhinDuocCuaCamera(camera, toaDo))
                result.add(camera);

        return result;
    }
}
