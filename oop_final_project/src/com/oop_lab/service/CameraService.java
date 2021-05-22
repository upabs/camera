package com.oop_lab.service;

import com.oop_lab.model.Camera;
import com.oop_lab.model.DoVat;
import com.oop_lab.model.Room;
import com.oop_lab.model.khong_gian.*;

import java.util.ArrayList;
import java.util.List;

public class CameraService {

    public Camera createCamera(ToaDo toaDo, float gocCao, float gocRong) {
        if (cameraHopLe(gocCao, gocRong))
            return new Camera(toaDo, gocCao, gocRong);
        return null;
    }

    public boolean cameraHopLe(float gocCao, float gocRong) {
        return (gocCao > 0 && gocRong > 0);
    }

    public float theTichNhinThay(Camera camera) {
        return camera.getVungNhin().theTich();
    }

    public boolean diemNamTrongVungNhinDuocCuaCamera(Camera camera, ToaDo toaDo) {
        return camera.getVungNhin().chuaDiem(toaDo);
    }

    public List<ToaDo> toaDoChieuCameraLenOxy(Camera camera, Room room) {
        List<ToaDo> dsGiaoDiem = new ArrayList<ToaDo>();
        ToaDo dinhE = camera.getToaDo();
        ToaDo dinhB = camera.getVungNhin().getCacDinh().get(HinhChop.DINH_B);
        ToaDo dinhD = camera.getVungNhin().getCacDinh().get(HinhChop.DINH_D);
        ToaDo tmp;


        Vector vectorBD = new Vector(dinhB, dinhD);
        float BD = dinhB.khoangCach(dinhD);
        float k = BD / (100 - 1);

        tmp = dinhB.clone();
        while (tmp.khoangCach(dinhB) < BD) {
            DoanThang doanThang = new DoanThang(dinhE, tmp);
            List<ToaDo> cacUngCuVien = new ArrayList<ToaDo>();
            for (DoVat doVat : room.getDanhSachDoVat()) {
                List<ToaDo> cacGiaoDiem = doanThang.giaoDiemVoiHinhHopChuNhat(doVat);
                ToaDo ganNhat = dinhE.diemGanNhat(cacGiaoDiem);
                if (ganNhat != null) {
                    cacUngCuVien.add(ganNhat);
                }
            }
            if (cacUngCuVien.isEmpty()) {
                DoanThang doanEtmp = new DoanThang(dinhE, tmp);
                ToaDo giaoVoiPhong = dinhE.diemGanNhat(doanEtmp.giaoDiemVoiHinhHopChuNhat(room));
                if (giaoVoiPhong != null) {
                    dsGiaoDiem.add(giaoVoiPhong.clone());
                } else {
                    dsGiaoDiem.add(tmp.clone());
                }
            } else if (dinhE.diemGanNhat(cacUngCuVien) != null) {
                dsGiaoDiem.add(dinhE.diemGanNhat(cacUngCuVien).clone());
            }

            tmp.tinhTien(vectorBD.nhanFloat(k));
        }
        // tranh sai so -> lam rieng voi D
        DoanThang doanThang = new DoanThang(dinhE, dinhD);
        List<ToaDo> cacUngCuVien = new ArrayList<ToaDo>();
        for (DoVat doVat : room.getDanhSachDoVat()) {
            List<ToaDo> cacGiaoDiem = doanThang.giaoDiemVoiHinhHopChuNhat(doVat);
            ToaDo ganNhat = dinhE.diemGanNhat(cacGiaoDiem);
            if (ganNhat != null) {
                cacUngCuVien.add(ganNhat);
            }
        }
        if (cacUngCuVien.isEmpty()) {
            DoanThang doanED = new DoanThang(dinhE, dinhD);
            ToaDo giaoVoiPhong = dinhE.diemGanNhat(doanED.giaoDiemVoiHinhHopChuNhat(room));
            if (giaoVoiPhong != null) {
                dsGiaoDiem.add(giaoVoiPhong.clone());
            } else {
                dsGiaoDiem.add(tmp.clone());
            }
        } else if (dinhE.diemGanNhat(cacUngCuVien) != null) {
            dsGiaoDiem.add(dinhE.diemGanNhat(cacUngCuVien).clone());
        }

        return dsGiaoDiem;
    }
}
