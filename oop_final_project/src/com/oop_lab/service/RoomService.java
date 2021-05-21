package com.oop_lab.service;

import com.oop_lab.model.Camera;
import com.oop_lab.model.DoVat;
import com.oop_lab.model.Room;
import com.oop_lab.model.khong_gian.DoanThang;
import com.oop_lab.model.khong_gian.HinhChop;
import com.oop_lab.model.khong_gian.MatPhang;
import com.oop_lab.model.khong_gian.ToaDo;
import com.oop_lab.model.khong_gian.Vector;

import java.util.ArrayList;
import java.util.List;

public class RoomService {

    public Room createRoom(float cao, float rong, float dai) {
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

    public boolean roomHopLe(float cao, float rong, float dai) {
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

        if (matPhangChuaCam == null)
            return;

        ToaDo diemH = null;
        if (matPhangChuaCam.equals(room.getCacMat().get(Room.MAT_DAY_DUOI_ABCD))) {
            diemH = new ToaDo(
                    camera.getToaDo().getX(),
                    camera.getToaDo().getY(),
                    camera.getToaDo().getZ() + camera.getTamNhin()
            );
        }
        if (matPhangChuaCam.equals(room.getCacMat().get(Room.MAT_DAY_TREN_EFGH))) {
            diemH = new ToaDo(
                    camera.getToaDo().getX(),
                    camera.getToaDo().getY(),
                    camera.getToaDo().getZ() - camera.getTamNhin()
            );
        }
        if (matPhangChuaCam.equals(room.getCacMat().get(Room.MAT_ADHE))) {
            diemH = new ToaDo(
                camera.getToaDo().getX() + camera.getTamNhin(),
                camera.getToaDo().getY(),
                camera.getToaDo().getZ()
            );
        }
        if (matPhangChuaCam.equals(room.getCacMat().get(Room.MAT_BCGF))) {
            diemH = new ToaDo(
                    camera.getToaDo().getX() - camera.getTamNhin(),
                    camera.getToaDo().getY(),
                    camera.getToaDo().getZ()
            );
        }
        if (matPhangChuaCam.equals(room.getCacMat().get(Room.MAT_CDHG))) {
            diemH = new ToaDo(
                camera.getToaDo().getX(),
                camera.getToaDo().getY() - camera.getTamNhin(),
                camera.getToaDo().getZ()
            );
        }
        if (matPhangChuaCam.equals(room.getCacMat().get(Room.MAT_AEFB))) {
            diemH = new ToaDo(
                camera.getToaDo().getX(),
                camera.getToaDo().getY() + camera.getTamNhin(),
                camera.getToaDo().getZ()
            );
        }

        float tanRong = (float) Math.tan(Math.toRadians(camera.getGocRong() / 2));
        float tanCao = (float) Math.tan(Math.toRadians(camera.getGocRong() / 2));

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
            if (cam.getToaDo().equals(camera.getToaDo()))
                return false;
        }
        return true;
    }

    public boolean cameraSoiVaoTrongPhong(Room room, Camera camera) {
        return true;
    }

    public float theTichKhongGianPhong(Room room) {
        float tongTheTichVatTrongPhong = 0;

        for (DoVat doVat : room.getDanhSachDoVat())
            tongTheTichVatTrongPhong += doVat.theTich();

        return room.theTich() - tongTheTichVatTrongPhong;
    }

    public float theTichVungNhinThay(Room room, int x, int y, int z) {
        // ToaDo dinhA = room.getCacDinh().get(Room.DINH_A);
        // ToaDo dinhB = room.getCacDinh().get(Room.DINH_B);
        // ToaDo dinhD = room.getCacDinh().get(Room.DINH_D);
        // ToaDo dinhE = room.getCacDinh().get(Room.DINH_E);

        // float startX = dinhA.getX();
        // float startY = dinhA.getY();
        // float startZ = dinhA.getZ();
        // float endX = dinhB.getX();
        // float endY = dinhD.getY();
        // float endZ = dinhE.getZ();

        // float stepX = (endX - startX) / (x - 1);
        // float stepY = (endY - startY) / (y - 1);
        // float stepZ = (endZ - startZ) / (z - 1);

        // int soLuongDiemXetDuyet = 0;
        // int soLuongDiemNhinThay = 0;
        // for (float i = startZ; i <= endZ; i += stepZ) {
        //     for (float j = startY; j <= endY; j += stepY) {
        //         for (float k = startX; k <= endX; k += stepX) {
                    
        //             ToaDo toaDoDiemDangXet = new ToaDo(k, j, i);
        //             if (this.diemNamTrongDoVatNaoDo(room, toaDoDiemDangXet)) {
        //                 continue;
        //             }
        //             if (this.diemNamTrongVungNhinDuoc(room, toaDoDiemDangXet))
        //                 soLuongDiemNhinThay += 1;

        //             soLuongDiemXetDuyet += 1;
        //         }
        //     }
        // }

        ToaDo dinhA = room.getCacDinh().get(Room.DINH_A);
        ToaDo dinhB = room.getCacDinh().get(Room.DINH_B);
        ToaDo dinhD = room.getCacDinh().get(Room.DINH_D);
        ToaDo dinhE = room.getCacDinh().get(Room.DINH_E);

        Vector v_AB = new Vector(dinhA, dinhB);
        Vector v_AD = new Vector(dinhA, dinhD);
        Vector v_AE = new Vector(dinhA, dinhE);
        // System.out.println(v_AB.doDai()+ "; " + v_AD.doDai() + "; " + v_AE.doDai());
        
        Vector stepAB = v_AB.nhanFloat(1.0f / (x-1));
        Vector stepAD = v_AD.nhanFloat(1.0f / (y-1));
        Vector stepAE = v_AE.nhanFloat(1.0f / (z-1));

        // System.out.println(1.0f/(x-1) + "; " + 1.0f/(y-1) + "; " + 1.0f/(z-1));

        // float dAB = v_AB.doDai() / (x-1);
        // float dAD = v_AD.doDai() / (y-1);
        // float dAE = v_AE.doDai() / (z-1);

        // Vector stepAB = v_AB.nhanFloat(dAB/v_AB.doDai());
        // Vector stepAD = v_AD.nhanFloat(dAD/v_AD.doDai());
        // Vector stepAE = v_AE.nhanFloat(dAE/v_AE.doDai());

        // System.out.println(dAB + "; " + dAD + "; " + dAE);
        int soLuongDiemXetDuyet = 0;
        int soLuongDiemNhinThay = 0;
        
        ToaDo toaDoDiemDangXet;
        for (int k = 0; k < z; k++) {
            for (int j = 0; j < y; j++) {
                for (int i = 0; i < x; i++) {
                    toaDoDiemDangXet = new ToaDo(dinhA);
                    
                    toaDoDiemDangXet.tinhTien(stepAB.nhanFloat(i));
                    toaDoDiemDangXet.tinhTien(stepAD.nhanFloat(j));
                    toaDoDiemDangXet.tinhTien(stepAE.nhanFloat(k));
                    
                    if (this.diemNamTrongDoVatNaoDo(room, toaDoDiemDangXet)) {
                        continue;
                    }

                    if (this.diemNamTrongVungNhinDuoc(room, toaDoDiemDangXet))
                        soLuongDiemNhinThay += 1;

                    soLuongDiemXetDuyet += 1;
                    // System.out.println(toaDoDiemDangXet.toString());
                }
            }
        }

        return theTichKhongGianPhong(room) * (float) soLuongDiemNhinThay / (float) soLuongDiemXetDuyet;
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
