package com.oop_lab.service;

import com.oop_lab.model.Camera;
import com.oop_lab.model.DoVat;
import com.oop_lab.model.Room;
import com.oop_lab.model.khong_gian.DoanThang;
import com.oop_lab.model.khong_gian.HinhChop;
import com.oop_lab.model.khong_gian.MatPhang;
import com.oop_lab.model.khong_gian.ToaDo;

import java.util.ArrayList;
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
        if (cameraNamTrenTuong(room, camera) == null) return false;
        if (!cameraKhongBiTrung(room, camera)) return false;
        if (!cameraSoiVaoTrongPhong(room, camera)) return false;

        this.setupVungNhinCameraTuongUngVoiPhong(room, camera);
        room.themCamera(camera);
        return true;
    }

    public void setupVungNhinCameraTuongUngVoiPhong(Room room, Camera camera) {
        MatPhang matPhangChuaCam = null;
        for (MatPhang matPhang : room.getDanhSachCacMat()) {
            if (matPhang.chuaDiem(camera.getToaDo())) {
                matPhangChuaCam = matPhang;
                break;
            }
        }

        ToaDo diemH = null;
        if (matPhangChuaCam == room.getCacMat().get(Room.MAT_DAY_DUOI_ABCD)) {
            diemH = new ToaDo(
                    camera.getToaDo().getX(),
                    camera.getToaDo().getY(),
                    camera.getToaDo().getZ() + camera.getTamNhin()
            );
        }
        if (matPhangChuaCam == room.getCacMat().get(Room.MAT_DAY_TREN_EFGH)) {
            diemH = new ToaDo(
                    camera.getToaDo().getX(),
                    camera.getToaDo().getY(),
                    camera.getToaDo().getZ() - camera.getTamNhin()
            );
        }
        if (matPhangChuaCam == room.getCacMat().get(Room.MAT_ADHE)) {
            diemH = new ToaDo(
                camera.getToaDo().getX() + camera.getTamNhin(),
                camera.getToaDo().getY(),
                camera.getToaDo().getZ()
            );
        }
        if (matPhangChuaCam == room.getCacMat().get(Room.MAT_BCGF)) {
            diemH = new ToaDo(
                camera.getToaDo().getX() - camera.getTamNhin(),
                camera.getToaDo().getY(),
                camera.getToaDo().getZ()
            );
        }
        if (matPhangChuaCam == room.getCacMat().get(Room.MAT_CDHG)) {
            diemH = new ToaDo(
                camera.getToaDo().getX(),
                camera.getToaDo().getY() - camera.getTamNhin(),
                camera.getToaDo().getZ()
            );
        }
        if (matPhangChuaCam == room.getCacMat().get(Room.MAT_AEFB)) {
            diemH = new ToaDo(
                camera.getToaDo().getX(),
                camera.getToaDo().getY() + camera.getTamNhin(),
                camera.getToaDo().getZ()
            );
        }

        double tanRong = Math.tan(camera.getGocRong() / 2);
        double tanCao = Math.tan(camera.getGocCao() / 2);

        camera.setVungNhin(
            new HinhChop(
                camera.getToaDo(),
                new ToaDo(diemH.getX(), diemH.getY(), diemH.getZ() +
                        camera.getToaDo().khoangCach(diemH) * tanRong),
                new ToaDo(diemH.getX(), diemH.getY() -
                        camera.getToaDo().khoangCach(diemH) * tanCao, diemH.getZ()),
                new ToaDo(diemH.getX(), diemH.getY(), diemH.getZ() -
                        camera.getToaDo().khoangCach(diemH) * tanRong),
                new ToaDo(diemH.getX(), diemH.getY() +
                        camera.getToaDo().khoangCach(diemH) * tanCao, diemH.getZ())
            )
        );
    }

    public MatPhang cameraNamTrenTuong(Room room, Camera camera) {
        for (MatPhang matPhang : room.getDanhSachCacMat()) {
            if (matPhang.chuaDiem(camera.getToaDo())) {
                return matPhang;
            }
        }
        return null;
    }

    public boolean cameraKhongBiTrung(Room room, Camera camera) {
        for (Camera cam : room.getDanhSachCamera()) {
            if (cam.getToaDo() == camera.getToaDo())
                return false;
        }
        return true;
    }

    public boolean cameraSoiVaoTrongPhong(Room room, Camera camera) {
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

        double stepX = (endX - startX) / (x - 1);
        double stepY = (endY - startY) / (y - 1);
        double stepZ = (endZ - startZ) / (z - 1);

        int soLuongDiemXetDuyet = 0;
        int soLuongDiemNhinThay = 0;
        for (double i = startZ; i <= endZ; i += stepZ) {
            for (double j = startY; j <= endY; j += stepY) {
                for (double k = startX; k <= endX; k += stepX) {
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
                    if (giaoDiem != null) {
                        stop = true;
                        break;
                    }
                }
                if (stop) break;
            }
            if (i == dsDoVat.size()) {
                return true;
            }
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
